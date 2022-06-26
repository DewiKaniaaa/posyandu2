package com.example.posyandu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditJadwalActivity extends AppCompatActivity {

    EditText etNamaJadwal, etTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_jadwal);

        etNamaJadwal = findViewById(R.id.et_nama_jadwal);
        etTanggal = findViewById(R.id.et_tanggal);

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

        etNamaJadwal.setText(jadwal);
        etTanggal.setText(tanggal);
    }
}