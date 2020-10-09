package com.bit_loons.covidaid.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bit_loons.covidaid.Fragments.HelpOthersSheetFragment;
import com.bit_loons.covidaid.R;
import com.bit_loons.covidaid.databinding.ContentHelpOthersBinding;

public class HelpOthersAdapter extends RecyclerView.Adapter<HelpOthersAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private FragmentManager fragmentManager;

    public HelpOthersAdapter(Context context, FragmentManager fragmentManager) {
        this.context =context;
        this.mInflater = LayoutInflater.from(context);
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ContentHelpOthersBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvKnowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelpOthersSheetFragment fragment = new HelpOthersSheetFragment();
                fragment.show(fragmentManager, "Bottom Sheet");
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ContentHelpOthersBinding binding;
        ViewHolder(@NonNull ContentHelpOthersBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
