package com.kazi_ruhol.tanbee;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class PhoneAuth extends AppCompatActivity {

    private EditText edtPhone, edtCode, edtName, edtEmail, edtPassword;
    private Button btnGetOTP, btnLogin, btnBack, btnResend;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_auth);
        edtCode = (EditText) findViewById(R.id.edtOTPAuth);
        edtPhone = (EditText) findViewById(R.id.edtPhoneNumberAuth);
        edtName = (EditText) findViewById(R.id.edtUsername);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnGetOTP = (Button) findViewById(R.id.btnGetOTP);
        btnLogin = (Button) findViewById(R.id.btnLoginPhoneAuth);
        btnBack = (Button) findViewById(R.id.btnLoginT);
        btnResend = (Button) findViewById(R.id.btnResendAuth);



        btnGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phoneNumber = edtPhone.getText().toString().trim();


                if (phoneNumber.isEmpty() || phoneNumber.length() !=11) {
                    edtPhone.setError("please enter valid phone");
                }
                else {
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            "+88" + phoneNumber, 60, TimeUnit.SECONDS, PhoneAuth.this,
                            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                @Override
                                public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                                    signInUser(phoneAuthCredential);
                                }

                                @Override
                                public void onVerificationFailed(FirebaseException e) {
                                    edtPhone.setError("Verification Failed!!");
                                    Toast.makeText(PhoneAuth.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onCodeSent(final String verificationId, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                    super.onCodeSent(verificationId, forceResendingToken);

                                    btnLogin.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String verificationCode = edtCode.getText().toString();
                                            if (verificationId.isEmpty()) return;

                                                //create a credential
                                                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, verificationCode);
                                                signInUser(credential);





                                        }
                                    });
                                }
                            }
                    );
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneAuth.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void signInUser(PhoneAuthCredential phoneAuthCredential) {
        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                .addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
                            rootNode = FirebaseDatabase.getInstance("https://tanbee-7438a-default-rtdb.asia-southeast1.firebasedatabase.app/");
                            reference = rootNode.getReference("users");
                            String username = edtName.getText().toString().trim();
                            String phoneNo = edtPhone.getText().toString().trim();
                            String email = edtEmail.getText().toString();
                            String password = edtPassword.getText().toString();
                            UserHelperClass helperClass = new UserHelperClass(username,phoneNo,email,password);
                            reference.child(phoneNo).setValue(helperClass);
                            startActivity(new Intent(PhoneAuth.this, dashboardActivity.class));
                            finish();
                        } else {
  //                              Log.d(TAG, "onComplete:"+task.getException().getLocalizedMessage());

                        }
                    }
                });
    }




}