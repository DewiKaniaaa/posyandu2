package com.example.posyandu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class KelolaAbsenKaderActivity extends AppCompatActivity {

    CardView cvAbsen, cvRekapAbsen, cvRekapAbsenPeserta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_absen_kader);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        cvAbsen=findViewById(R.id.cv_absen);
        cvAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KelolaAbsenKaderActivity.this, AbsenActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

        cvRekapAbsenPeserta=findViewById(R.id.cv_rekap_absen_peserta);
        cvRekapAbsenPeserta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KelolaAbsenKaderActivity.this, RekapAbsenPesertaActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                Toast.makeText(KelolaAbsenKaderActivity.this, "Rekap Absen Peserta", Toast.LENGTH_SHORT).show();
            }
        });

        cvRekapAbsen=findViewById(R.id.cv_rekap_absen);
        cvRekapAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KelolaAbsenKaderActivity.this, RekapAbsenActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
//                Toast.makeText(KelolaAbsenKaderActivity.this, "Rekap Absen Peserta", Toast.LENGTH_SHORT).show();
            }
        });
    }


}