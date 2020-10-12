package com.bit_loons.covidaid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bit_loons.covidaid.Fragments.HelpOthersSheetFragment;
import com.bit_loons.covidaid.databinding.ContentHelpOthersBinding;
import com.bit_loons.covidaid.models.HelpRequest;

public class HelpOthersAdapter extends RecyclerView.Adapter<HelpOthersAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private FragmentManager fragmentManager;
    private HelpRequest[] helpRequests;

    public HelpOthersAdapter(Context context, FragmentManager fragmentManager, HelpRequest[] helpRequests) {
        this.context =context;
        this.mInflater = LayoutInflater.from(context);
        this.fragmentManager = fragmentManager;
        this.helpRequests = helpRequests;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ContentHelpOthersBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final HelpRequest helpRequest = helpRequests[position];
        holder.binding.tvHead.setText(helpRequest.getSubject());
        holder.binding.tvLocation.setText("at " + helpRequest.getLocation());
        holder.binding.tvKnowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelpOthersSheetFragment fragment = new HelpOthersSheetFragment(helpRequest);
                fragment.show(fragmentManager, "Bottom Sheet");
            }
        });
    }

    @Override
    public int getItemCount() {
        return helpRequests.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ContentHelpOthersBinding binding;
        ViewHolder(@NonNull ContentHelpOthersBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
