package com.example.posyandu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class KelolaUserActivity extends AppCompatActivity {

    CardView cvKelolaUserKader, cvKelolaUserPeserta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_user);

        cvKelolaUserKader = findViewById(R.id.cv_kelola_user_kader);
        cvKelolaUserPeserta= findViewById(R.id.cv_kelola_user_peserta);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        cvKelolaUserKader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KelolaUserActivity.this, KelolaUserKaderActivity.class);
                startActivity(intent);
            }
        });

        cvKelolaUserPeserta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KelolaUserActivity.this, KelolaUserPesertaActivity.class);
                startActivity(intent);
            }
        });
    }
}