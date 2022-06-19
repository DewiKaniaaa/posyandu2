package com.example.posyandu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;

public class RekapAbsenActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRvRekapAbsen adapterRvRekapAbsen;
    RecyclerView.LayoutManager rvLayoutManager;
    ArrayList<ModelRekapAbsen> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap_absen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.rv_rekap_absen);
        recyclerView.setHasFixedSize(true);
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        data = new ArrayList<>();
        for (int i=0; i < DataRekapAbsen.jadwal.length; i++){
            data.add(new ModelRekapAbsen(
                    DataRekapAbsen.jadwal[i],
                    DataRekapAbsen.tanggal[i],
                    DataRekapAbsen.status[i]
            ));
        }
        adapterRvRekapAbsen = new AdapterRvRekapAbsen(this,data);
        recyclerView.setAdapter(adapterRvRekapAbsen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rekap_absen, menu);
        return true;

    }
}