package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    private EditText newPasswod,reenterPassword;
    private Button registerButton;

    public void checkPassword(View view) {
        registerButton = (Button)findViewById(R.id.register);
        newPasswod = (EditText)findViewById(R.id.newPass);
        reenterPassword = (EditText)findViewById(R.id.reenterPass);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String npass;
                String rpass;
                npass = newPasswod.getText().toString();
                rpass = reenterPassword.getText().toString();
                if(npass.equals(rpass)){
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Password Mismatched",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
