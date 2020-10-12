package com.bit_loons.covidaid.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bit_loons.covidaid.Adapters.LeaderboardAdapter;
import com.bit_loons.covidaid.databinding.ActivityLeaderboardBinding;
import com.bit_loons.covidaid.handlers.DataHandler;
import com.bit_loons.covidaid.handlers.OkHttpSingleton;
import com.bit_loons.covidaid.models.LeaderBoard;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LeaderboardActivity extends AppCompatActivity {

    private ActivityLeaderboardBinding binding;
    private OkHttpClient client;
    private Gson gson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLeaderboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeVars();
        postData(DataHandler.LEADERBOARD);
    }

    private void setupRecyclerView(LeaderBoard[] leaderBoards) {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new LeaderboardAdapter(this, leaderBoards));
    }

    private void initializeVars() {
        client = OkHttpSingleton.getInstance().getClient();
        gson = new Gson();
    }

    private void postData(String url){
        binding.progressBar.setVisibility(View.VISIBLE);
        RequestBody body = RequestBody.create(null, new byte[]{});
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
                            LeaderBoard[] leaderBoards = gson.fromJson(res, LeaderBoard[].class);
                            setupRecyclerView(leaderBoards);
                        } catch (Exception e) {
                            makeToast("JSON Error : Failed! Try again.");
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void makeToast(String text){
        Toast.makeText(this, ""+text, Toast.LENGTH_SHORT).show();
    }
}
