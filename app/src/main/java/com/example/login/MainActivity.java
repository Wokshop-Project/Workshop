package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
//    checking...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton =(Button)findViewById(R.id.loginBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
 
    public void register(View view) {
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
