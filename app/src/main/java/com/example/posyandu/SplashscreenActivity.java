package com.example.posyandu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashscreenActivity extends AppCompatActivity {


    private ProgressBar progressBar;
    private int value=0;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        sessionManager =new SessionManager(getApplicationContext());
        progressBar = findViewById(R.id.loading);

        progressBar.setProgress(value);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex){
                    ex.printStackTrace();
                } finally{

                    sessionManager.cekLogin();
//                    startActivity(new Intent(SplashscreenActivity.this, LoginActivity.class));
                    finish();
                }

            }
        });
        thread.start();
    }
}