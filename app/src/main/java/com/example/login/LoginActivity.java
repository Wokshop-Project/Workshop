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

public class LoginActivity extends AppCompatActivity {
    EditText lEmail,lPassword;
    Button lLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar probar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lLoginBtn = findViewById(R.id.lLogin);
        lEmail = findViewById(R.id.email_login);
        lPassword = findViewById(R.id.login_password);
        probar = findViewById(R.id.progressBar2);

        fAuth = FirebaseAuth.getInstance();

        lLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password;
                email = lEmail.getText().toString().trim();
                password = lPassword.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    lEmail.setError("Email is Required");
                }
                if(TextUtils.isEmpty(password))
                {
                    lPassword.setError("Password is Required");
                    return;
                }
                probar.setVisibility(View.VISIBLE);
                // authenticate the user
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Logged in Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Error !" + task.getException(),Toast.LENGTH_SHORT).show();
                            probar.setVisibility(View.INVISIBLE);


                        }
                    }
                });
            }
        });
    }

    public void goBack(View view) {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);
    }
}
