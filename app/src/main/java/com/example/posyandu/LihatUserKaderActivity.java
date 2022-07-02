package com.example.posyandu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LihatUserKaderActivity extends AppCompatActivity {

    TextView tvNama, tvNoTelepon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_user_kader);

        tvNama = findViewById(R.id.text_nama_kader);
        tvNoTelepon = findViewById(R.id.text_no_telepon);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intentData = getIntent();
        String nama = intentData.getStringExtra("NAMA");
        String telepon = intentData.getStringExtra("TELEPON");

        tvNama.setText(nama);
        tvNoTelepon.setText(telepon);
    }

}