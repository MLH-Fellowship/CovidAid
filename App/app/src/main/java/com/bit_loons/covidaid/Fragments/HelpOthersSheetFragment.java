package com.bit_loons.covidaid.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bit_loons.covidaid.R;
import com.bit_loons.covidaid.databinding.ContentSheetHelpOthersBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class HelpOthersSheetFragment extends BottomSheetDialogFragment {

    ContentSheetHelpOthersBinding binding;

    public HelpOthersSheetFragment() {
        super();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ContentSheetHelpOthersBinding.inflate(LayoutInflater.from(getContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpListeners();
    }

    private void setUpListeners() {
        binding.btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                Toast.makeText(getContext(), "Request Accepted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
