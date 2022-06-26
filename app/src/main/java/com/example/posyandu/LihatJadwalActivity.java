package com.example.posyandu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LihatJadwalActivity extends AppCompatActivity {

    TextView tvJadwal, tvTanggal, tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_jadwal);

        tvJadwal = findViewById(R.id.text_jadwal);
        tvTanggal = findViewById(R.id.text_tanggal);
        tvStatus = findViewById(R.id.text_status);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intentData = getIntent();
        String jadwal = intentData.getStringExtra("JADWAL");
        String tanggal = intentData.getStringExtra("TANGGAL");
        String status = intentData.getStringExtra("STATUS");

        tvJadwal.setText(jadwal);
        tvTanggal.setText(tanggal);
        tvStatus.setText(status);
    }
}