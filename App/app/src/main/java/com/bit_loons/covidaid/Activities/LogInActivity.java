package com.bit_loons.covidaid.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bit_loons.covidaid.R;
import com.bit_loons.covidaid.databinding.ActivityLoginBinding;

public class LogInActivity extends AppCompatActivity {

    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityLoginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(activityLoginBinding.getRoot());

        setListeners();
    }

    private void setListeners() {
        activityLoginBinding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLogIn();
            }
        });

        activityLoginBinding.tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInActivity.this, SignupActivity.class));
            }
        });
    }

    private void startLogIn() {
        //ProcessLogin
        startActivity(new Intent(LogInActivity.this, HomeActivity.class));
    }
}