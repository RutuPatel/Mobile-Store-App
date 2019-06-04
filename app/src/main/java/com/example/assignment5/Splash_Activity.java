package com.example.assignment5;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.assignment5.AccountActivity.LoginActivity;
import com.example.assignment5.AccountActivity.SignupActivity;

public class Splash_Activity extends AppCompatActivity {


    private  static  int timeout=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent  intent =new Intent(Splash_Activity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },timeout);
    }
}
