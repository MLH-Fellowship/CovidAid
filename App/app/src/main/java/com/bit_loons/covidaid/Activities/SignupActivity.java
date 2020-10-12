package com.bit_loons.covidaid.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bit_loons.covidaid.databinding.ActivitySignupBinding;
import com.bit_loons.covidaid.handlers.DataHandler;
import com.bit_loons.covidaid.models.LogIn;
import com.bit_loons.covidaid.models.LogInResponse;
import com.bit_loons.covidaid.models.SignUp;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.bit_loons.covidaid.handlers.DataHandler.JSON;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    private OkHttpClient client;
    private Gson gson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeVars();
        setupListeners();
    }

    private void initializeVars() {
        client = new OkHttpClient();
        gson = new Gson();
    }

    private void setupListeners() {
        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData(DataHandler.SIGNUP, fetchBody());
            }
        });

        binding.tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, LogInActivity.class));
            }
        });
    }

    private String fetchBody() {
        SignUp signUp = new SignUp();
        signUp.setFirst_name(binding.etGetFirstName.getText().toString());
        signUp.setLast_name(binding.etGetLastName.getText().toString());
        signUp.setEmail(binding.etGetEmail.getText().toString());
        signUp.setPassword(binding.etGetPassword.getText().toString());
        signUp.setContact_number(binding.etGetContact.getText().toString());
        return gson.toJson(signUp);
    }

    private void postData(String url, String bodyStr){
        binding.progressBar.setVisibility(View.VISIBLE);
        RequestBody body = RequestBody.create(bodyStr, JSON);
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
                            if (logInResponse.isLogedIn()) {
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
        startActivity(new Intent(SignupActivity.this, HomeActivity.class));
    }

    private void makeToast(String text){
        Toast.makeText(this, ""+text, Toast.LENGTH_SHORT).show();
    }
}
