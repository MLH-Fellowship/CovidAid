package com.bit_loons.covidaid.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bit_loons.covidaid.databinding.ContentSheetHelpOthersBinding;
import com.bit_loons.covidaid.models.HelpRequest;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class HelpOthersSheetFragment extends BottomSheetDialogFragment {

    private ContentSheetHelpOthersBinding binding;
    private HelpRequest helpRequest;

    public HelpOthersSheetFragment(HelpRequest helpRequest) {
        super();
        this.helpRequest = helpRequest;
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

        binding.tvHeading.setText(helpRequest.getSubject());
        binding.tvDescription.setText(helpRequest.getDescription());
        binding.tvFullName.setText(helpRequest.getName());
        binding.tvLocation.setText( helpRequest.getAddress() + " , " + helpRequest.getLocation());
        setUpListeners();
    }

    private void setUpListeners() {
        binding.btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBrowser("https://api.whatsapp.com/send?phone=" + helpRequest.getContact_number());
            }
        });
        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDailer(helpRequest.getContact_number());
            }
        });
        binding.btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                Toast.makeText(getContext(), "Request Accepted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    private void openDailer(String contact){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+contact));
        startActivity(intent);
    }
}
