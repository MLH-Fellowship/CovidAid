package com.bit_loons.covidaid.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bit_loons.covidaid.R;
import com.bit_loons.covidaid.databinding.ActivityPostRequestBinding;

public class PostRequestActivity extends AppCompatActivity {

    ActivityPostRequestBinding activityPostRequestBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityPostRequestBinding = ActivityPostRequestBinding.inflate(getLayoutInflater());
        setContentView(activityPostRequestBinding.getRoot());

        setupListeners();

    }

    private void setupListeners() {
        activityPostRequestBinding.btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PostRequestActivity.this, HomeActivity.class));
            }
        });
    }
}
