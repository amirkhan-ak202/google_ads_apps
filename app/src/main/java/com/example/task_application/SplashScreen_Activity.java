package com.example.task_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.window.SplashScreen;

public class SplashScreen_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen_Activity.this, MainActivity.class));
                finish();
            }
        };
        handler.postDelayed(runnable, 5000);
    }
}