package com.bit_loons.covidaid.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bit_loons.covidaid.Adapters.LeaderboardAdapter;
import com.bit_loons.covidaid.R;
import com.bit_loons.covidaid.databinding.ActivityLeaderboardBinding;

public class LeaderboardActivity extends AppCompatActivity {

    ActivityLeaderboardBinding activityLeaderboardBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLeaderboardBinding = ActivityLeaderboardBinding.inflate(getLayoutInflater());
        setContentView(activityLeaderboardBinding.getRoot());

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        activityLeaderboardBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityLeaderboardBinding.recyclerView.setAdapter(new LeaderboardAdapter(this));
    }
}
