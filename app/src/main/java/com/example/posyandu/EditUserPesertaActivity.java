package com.example.posyandu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditUserPesertaActivity extends AppCompatActivity {

    EditText etNama, etNoTelepon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_peserta);

        etNama = findViewById(R.id.et_nama_peserta);
        etNoTelepon = findViewById(R.id.et_no_telepon);

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

        etNama.setText(nama);
        etNoTelepon.setText(telepon);
    }
}