package com.kazi_ruhol.tanbee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    Button  callSignUp, loginbtn, forget;
    ImageView image;
    TextView logoText;
    AwesomeValidation awesomeValidation;
    TextInputLayout loginEmail, loginPassword;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        callSignUp = findViewById(R.id.create_account);
        loginbtn = findViewById(R.id.sign_in);
        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        forget = findViewById(R.id.login_forget_password);
        mAuth = FirebaseAuth.getInstance();

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.login_email, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.login_password, ".{6,}",R.string.invalid_pass);





        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(awesomeValidation.validate()){
                    Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                    userLogin();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Oops",Toast.LENGTH_SHORT).show();
                }

            }
        });

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PhoneAuth.class);
                startActivity(intent);
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, dashboardActivity.class);
                startActivity(intent);
            }
        });

    }

    private void userLogin() {
        String email = loginEmail.getEditText().getText().toString().trim();
        String password = loginPassword.getEditText().getText().toString().trim();
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent intent = new Intent(LoginActivity.this,dashboardActivity.class);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Sorry Boo", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}