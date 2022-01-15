package com.kazi_ruhol.tanbee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kazi_ruhol.tanbee.databinding.ActivityOtpVerifyBinding;

public class OtpVerifyActivity extends AppCompatActivity {

    private ActivityOtpVerifyBinding binding;
    private String verficationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpVerifyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvPhone.setText(String.format(
                "+880-%s",getIntent().getStringExtra("phone")


        ));

        verficationId = getIntent().getStringExtra("verificationId");
        binding.reSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OtpVerifyActivity.this, "Otp Send Successfully.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}