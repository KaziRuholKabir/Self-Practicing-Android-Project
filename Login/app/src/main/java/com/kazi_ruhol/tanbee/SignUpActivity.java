package com.kazi_ruhol.tanbee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kazi_ruhol.tanbee.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    TextInputLayout regUsername, regEmail, regPhoneNo, regPassword;
    Button login, signUp;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    AwesomeValidation awesomeValidation;

    private ActivitySignUpBinding binding;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        regUsername = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_email);
        regPhoneNo = findViewById(R.id.reg_phone_number);
        regPassword = findViewById(R.id.reg_password);
        signUp = findViewById(R.id.sign_up);
        login = findViewById(R.id.have_account);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.reg_username, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.reg_phone_number, "[0-1]{2}[0-9]{9}$",R.string.invalid_phone);
        awesomeValidation.addValidation(this,R.id.reg_email, Patterns.EMAIL_ADDRESS,R.string.invalid_email);
        awesomeValidation.addValidation(this,R.id.reg_password, ".{8,}",R.string.invalid_pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(awesomeValidation.validate()){
                    Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
                    rootNode = FirebaseDatabase.getInstance("https://tanbee-7438a-default-rtdb.asia-southeast1.firebasedatabase.app/");
                    reference = rootNode.getReference("users");
                    String username = regUsername.getEditText().getText().toString().trim();
                    String phoneNo = regPhoneNo.getEditText().getText().toString().trim();
                    String email = regEmail.getEditText().getText().toString();
                    String password = regPassword.getEditText().getText().toString();
                    //UserHelperClass helperClass = new UserHelperClass(username,phoneNo,email,password);
                    //reference.child(phoneNo).setValue(helperClass);
                    Intent intent = new Intent(SignUpActivity.this, VerifyPhoneActivity.class);
                    intent.putExtra("phoneNo",phoneNo);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Oops",Toast.LENGTH_SHORT).show();
                }



            }
        });



    }



    /*private Boolean validateUsername(){
        String val = regUsername.getEditText().getText().toString().trim();
        String noWhiteSpace = "(?=\\s+$)";

        if(val.isEmpty()){
            regUsername.setError("Field cannot be empty");
            return false;

        } else if(val.length()>=15) {
            regUsername.setError("Username is too long");
            return false;

        } else if(val.matches(noWhiteSpace)){
            regUsername.setError("No Space please");
            return false;

        }

        else{
            regUsername.setError(null);;
            return true;

        }


    }
    private Boolean validatePhoneNo(){
        String val = regUsername.getEditText().getText().toString();


        if(val.isEmpty()){
            regUsername.setError("Field cannot be empty");
            return false;

        }
        if(val.length()>11 || val.length()<11){
            regUsername.setError("Phone No must be 11 Digit");
            return false;
        }
        else{
            regUsername.setError(null);;
            return true;

        }


    }
    private Boolean validateEmail(){
        String val = regUsername.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        if(val.isEmpty()){
            regUsername.setError("Field cannot be empty");
            return false;

        } else if(!val.matches(emailPattern)){
            regUsername.setError("Invalid Email Address");
            return false;
        }
        else{
            regUsername.setError(null);;
            return true;

        }


    }
    private Boolean validatePassword(){
        String val = regUsername.getEditText().getText().toString();
        String passwordVal = "^" + "(?=.*[a-zA-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\s+$)" + ".{8,}" + "$";

        if(val.isEmpty()){
            regUsername.setError("Field cannot be empty");
            return false;

        } else if(!val.matches(passwordVal)){
            regUsername.setError("Invalid Password");
            return false;

        }
        else{
            regUsername.setError(null);;
            return true;

        }


    }


    public void registerUser(View view){

        if(!validateUsername() || !validatePhoneNo() || !validateEmail() || !validatePassword()){
            return;
        }
        String username = regUsername.getEditText().getText().toString().trim();
        String phoneNo = regPhoneNo.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();
        UserHelperClass helperClass = new UserHelperClass(username,phoneNo,email,password);
        reference.child(phoneNo).setValue(helperClass);


    }
*/
}