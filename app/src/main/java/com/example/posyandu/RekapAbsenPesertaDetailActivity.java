package com.example.posyandu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import java.util.ArrayList;

public class RekapAbsenPesertaDetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRvPeserta adapterRvPeserta;
    RecyclerView.LayoutManager rvLayoutManager;
    ArrayList<ModelPeserta> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap_absen_peserta_detail);

        Intent intentData = getIntent();
        String jadwal = intentData.getStringExtra("JADWAL");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(jadwal);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.rv_rekap_absen_peserta_detail);
        recyclerView.setHasFixedSize(true);
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        data = new ArrayList<>();
        for (int i=0; i < DataPeserta.nama.length; i++){
            data.add(new ModelPeserta(
                    DataPeserta.nama[i],
                    DataPeserta.tanggal_lahir[i],
                    DataPeserta.jenis_kelamin[i]
            ));
        }
        adapterRvPeserta = new AdapterRvPeserta(this,data);
        recyclerView.setAdapter(adapterRvPeserta);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_rekap_absen_peserta, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                ArrayList<ModelPeserta> itemFilter = new ArrayList<>();
                for (ModelPeserta modelPeserta : data){
                    String nama = modelPeserta.getNama().toLowerCase();

                    if (nama.contains(newText)){
                        itemFilter.add(modelPeserta);
                    }
                }
                adapterRvPeserta.setFilter(itemFilter);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}