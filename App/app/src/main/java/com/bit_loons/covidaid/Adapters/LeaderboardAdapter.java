package com.bit_loons.covidaid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bit_loons.covidaid.R;
import com.bit_loons.covidaid.databinding.ContentLeaderboardBinding;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context context;

    public LeaderboardAdapter(Context context) {
        this.context =context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.content_leaderboard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ContentLeaderboardBinding binding;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ContentLeaderboardBinding.inflate(mInflater);
        }
    }
}