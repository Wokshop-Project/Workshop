package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText mFullname,mGmail,mNewPass,mRenterPass,mPhone;
    Button mRegister;
    FirebaseAuth fAuth;
    ProgressBar proBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFullname = findViewById(R.id.lEmail);
        mGmail = findViewById(R.id.gmail);
        mNewPass = findViewById(R.id.newPass);
        mRenterPass = findViewById(R.id.reenterPass);
        mRegister = findViewById(R.id.lLogin);
        mPhone = findViewById(R.id.ph_number);
        mFullname = findViewById(R.id.lEmail);

        fAuth = FirebaseAuth.getInstance();
        proBar = findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            finish();
        }

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mGmail.getText().toString().trim();
//                registerButton = (Button)findViewById(R.id.register);
//                newPasswod = (EditText)findViewById(R.id.newPass);
//                reenterPassword = (EditText)findViewById(R.id.reenterPass);
                mRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String newPassword;
                        String reenterPassword;
                        String phoneNumber;
                        String fullName;
                        newPassword = mNewPass.getText().toString().trim();
                        reenterPassword = mRenterPass.getText().toString().trim();
                        phoneNumber = mPhone.getText().toString().trim();
                        fullName = mFullname.getText().toString().trim();
                        if(TextUtils.isEmpty(fullName))
                        {
                            mFullname.setError("Name is required");
                        }
                        if(TextUtils.isEmpty(reenterPassword))
                        {
                            mRenterPass.setError("Password is required");
                        }
                        if(TextUtils.isEmpty(phoneNumber))
                        {
                            mPhone.setError("Phone Number is required");
                        }
                        if(TextUtils.isEmpty(email)) {
                            mGmail.setError("Email is Required");
                        }
                        if(TextUtils.isEmpty(newPassword))
                        {
                            mNewPass.setError("Password is required");
                            return;
                        }
                        if(newPassword.length() < 6)
                        {
                            mNewPass.setError("Password must contain atleast 6 characters");
                        }
                        if(newPassword.equals(reenterPassword)){
//                            Toast.makeText(getApplicationContext(),"Password Matched",Toast.LENGTH_SHORT).show();
                        }

                        else
                            {
                            mNewPass.setError("Password Mismatched");
                            return;

//                            Toast.makeText(getApplicationContext(),"Password Mismatched",Toast.LENGTH_SHORT).show();
                        }
                        proBar.setVisibility(View.VISIBLE);
                        // register the user
                        fAuth.createUserWithEmailAndPassword(email,newPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"User Created",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(),"Error !"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                }

                            }
                        });


                    }
        });

    }
    private EditText newPasswod,reenterPassword;
    private Button registerButton;

    public void checkPassword(View view) {

            }
        });

    }
}
