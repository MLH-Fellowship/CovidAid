package com.bit_loons.covidaid.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bit_loons.covidaid.databinding.ActivityPostRequestBinding;
import com.bit_loons.covidaid.handlers.DataHandler;
import com.bit_loons.covidaid.handlers.OkHttpSingleton;
import com.bit_loons.covidaid.models.LogInResponse;
import com.bit_loons.covidaid.models.NewRequest;
import com.bit_loons.covidaid.models.SignUp;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.bit_loons.covidaid.handlers.DataHandler.JSON;

public class PostRequestActivity extends AppCompatActivity {

    private static final String TAG = "PostRequestActivity";
    private ActivityPostRequestBinding binding;
    private OkHttpClient client;
    private Gson gson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPostRequestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeVars();
        setupListeners();

    }

    private void setupListeners() {
        binding.btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData(DataHandler.NEW_REQUEST, fetchBody());
            }
        });
    }

    private void initializeVars() {
        client = OkHttpSingleton.getInstance().getClient();
        gson = new Gson();
    }

    private String fetchBody() {
        NewRequest newRequest = new NewRequest();
        newRequest.setName(binding.etGetFullname.getText().toString());
        newRequest.setAddress(binding.etGetAddress.getText().toString());
        newRequest.setLocation(binding.etGetLocation.getText().toString());
        newRequest.setContact_number(binding.etGetContact.getText().toString());
        newRequest.setSubject(binding.etGetSubject.getText().toString());
        newRequest.setDescription(binding.etGetDescription.getText().toString());
        return gson.toJson(newRequest);
    }

    private void postData(String url, String bodyStr){
        binding.progressBar.setVisibility(View.VISIBLE);
        RequestBody body = RequestBody.create(bodyStr, JSON);
        final Request request = new Request.Builder()
                .addHeader("Cookie", DataHandler.COOKIE)
                .url(url)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        binding.progressBar.setVisibility(View.GONE);
                        makeToast("Network Error : Failed! Try again.");
                    }
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        binding.progressBar.setVisibility(View.GONE);
                        try {
                            String res = response.body().string();
                            LogInResponse logInResponse = gson.fromJson(res, LogInResponse.class);
                            if (logInResponse.isLogedIn()) {
                                makeToast("Help registered!");
                                nextActivity();
                            }else {
                                makeToast(""+logInResponse.getMsg());
                            }
                        } catch (IOException e) {
                            makeToast("JSON Error : Failed! Try again.");
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void nextActivity() {
        startActivity(new Intent(PostRequestActivity.this, HomeActivity.class));
        this.finish();
    }

    private void makeToast(String text){
        Toast.makeText(this, ""+text, Toast.LENGTH_SHORT).show();
    }
}
