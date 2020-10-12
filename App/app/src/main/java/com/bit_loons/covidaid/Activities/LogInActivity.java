package com.bit_loons.covidaid.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bit_loons.covidaid.databinding.ActivityLoginBinding;
import com.bit_loons.covidaid.handlers.DataHandler;
import com.bit_loons.covidaid.handlers.OkHttpSingleton;
import com.bit_loons.covidaid.models.LogIn;
import com.bit_loons.covidaid.models.LogInResponse;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LogInActivity extends AppCompatActivity {

    private static final String TAG = "LogInActivity";

    private ActivityLoginBinding binding;

    private Gson gson;

    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeVars();
        setListeners();
    }

    private void initializeVars() {
        client = OkHttpSingleton.getInstance().getClient();
        gson = new Gson();
    }

    private void setListeners() {
        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLogIn();
            }
        });

        binding.tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInActivity.this, SignupActivity.class));
            }
        });
    }

    private void startLogIn() {
        postData(DataHandler.LOGIN, fetchBody());
    }

    private String fetchBody() {
        LogIn logIn = new LogIn();
        logIn.setEmail(binding.etGetUsername.getText().toString());
        logIn.setPassword(binding.etGetPassword.getText().toString());
        return gson.toJson(logIn);
    }

    private void postData(String url, String bodyStr){
        binding.progressBar.setVisibility(View.VISIBLE);
        RequestBody body = RequestBody.create(bodyStr, DataHandler.JSON);
        Request request = new Request.Builder()
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
                            LogInResponse logInResponse = gson.fromJson(response.body().string(), LogInResponse.class);
                            Log.d(TAG, ""+response.headers().get("Set-Cookie"));
                            DataHandler.COOKIE = response.headers().get("Set-Cookie");
                            if (logInResponse.isLogedIn()) {
                                nextActivity();
                                makeToast("LogIn Success");
                            }else {
                                makeToast("User Doesnt Exist");
                            }
                        } catch (Exception e) {
                            makeToast("JSON Error : Failed! Try again.");
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void nextActivity() {
        startActivity(new Intent(LogInActivity.this, HomeActivity.class));
        this.finish();
    }

    private void makeToast(String text){
        Toast.makeText(this, ""+text, Toast.LENGTH_SHORT).show();
    }
}