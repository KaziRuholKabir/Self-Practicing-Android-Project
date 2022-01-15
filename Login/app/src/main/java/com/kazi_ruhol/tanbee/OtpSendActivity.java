package com.kazi_ruhol.tanbee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.kazi_ruhol.tanbee.databinding.ActivityOtpSendBinding;

import java.util.concurrent.TimeUnit;

public class OtpSendActivity extends AppCompatActivity {
    private ActivityOtpSendBinding binding;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpSendBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();


        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.etPhone.getText().toString().trim().isEmpty()){
                    Toast.makeText(OtpSendActivity.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                } else if(binding.etPhone.getText().toString().trim().length() != 10){
                    Toast.makeText(OtpSendActivity.this, "Enter a Valid Phone Number", Toast.LENGTH_SHORT).show();
                }
                else{
                    otpSent();
                }
            }
        });


    }

    private void otpSent() {
        binding.sentProgressBar.setVisibility(View.VISIBLE);
        binding.btnSend.setVisibility(View.INVISIBLE);

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                binding.sentProgressBar.setVisibility(View.GONE);
                binding.btnSend.setVisibility(View.VISIBLE);
                Toast.makeText(OtpSendActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                binding.sentProgressBar.setVisibility(View.GONE);
                binding.btnSend.setVisibility(View.VISIBLE);
                Intent intent = new Intent(OtpSendActivity.this, OtpVerifyActivity.class);
                intent.putExtra("phone", binding.etPhone.getText().toString().trim());
                intent.putExtra("verificationId", verificationId);
                startActivity(intent);


            }
        };
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+880" + binding.etPhone.getText().toString().trim())       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}