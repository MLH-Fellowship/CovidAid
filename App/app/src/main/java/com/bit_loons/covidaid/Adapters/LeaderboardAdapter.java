package com.bit_loons.covidaid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bit_loons.covidaid.databinding.ContentLeaderboardBinding;
import com.bit_loons.covidaid.models.LeaderBoard;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private LeaderBoard[] leaderBoards;

    public LeaderboardAdapter(Context context, LeaderBoard[] leaderBoards) {
        this.context =context;
        this.mInflater = LayoutInflater.from(context);
        this.leaderBoards = leaderBoards;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ContentLeaderboardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LeaderBoard leaderBoard = leaderBoards[position];
        holder.binding.tvRank.setText(position + 1 + "");
        holder.binding.tvLbName.setText(leaderBoard.getName());
        holder.binding.tvLBpoints.setText(leaderBoard.getPoints());
    }

    @Override
    public int getItemCount() {
        return leaderBoards.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ContentLeaderboardBinding binding;
        ViewHolder(@NonNull ContentLeaderboardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}