package com.bit_loons.covidaid.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bit_loons.covidaid.Adapters.HelpOthersAdapter;
import com.bit_loons.covidaid.R;
import com.bit_loons.covidaid.databinding.ActivityHelpOthersBinding;

public class HelpOthersActivity extends AppCompatActivity {

    ActivityHelpOthersBinding activityHelpOthersBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityHelpOthersBinding = ActivityHelpOthersBinding.inflate(getLayoutInflater());
        setContentView(activityHelpOthersBinding.getRoot());

        setRecyclerView();

    }

    private void setRecyclerView() {
        activityHelpOthersBinding.recylerView.setLayoutManager(new LinearLayoutManager(this));
        activityHelpOthersBinding.recylerView.setAdapter(new HelpOthersAdapter(this, getSupportFragmentManager()));
    }
}
