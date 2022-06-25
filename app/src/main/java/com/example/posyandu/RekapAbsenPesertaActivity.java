package com.example.posyandu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import java.util.ArrayList;

public class RekapAbsenPesertaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRvRekapAbsenPeserta adapterRvRekapAbsenPeserta;
    RecyclerView.LayoutManager rvLayoutManager;
    ArrayList<ModelRekapAbsenPeserta> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap_absen_peserta);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.rv_rekap_absen_peserta);
        recyclerView.setHasFixedSize(true);
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        data = new ArrayList<>();
        for (int i=0; i < DataRekapAbsenPeserta.jadwal.length; i++){
            data.add(new ModelRekapAbsenPeserta(
                    DataRekapAbsenPeserta.jadwal[i],
                    DataRekapAbsenPeserta.tanggal[i]
            ));
        }
        adapterRvRekapAbsenPeserta = new AdapterRvRekapAbsenPeserta(this,data);
        recyclerView.setAdapter(adapterRvRekapAbsenPeserta);
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
                ArrayList<ModelRekapAbsenPeserta> itemFilter = new ArrayList<>();
                for (ModelRekapAbsenPeserta modelRekapAbsenPeserta : data){
                    String jadwal = modelRekapAbsenPeserta.getJadwal().toLowerCase();
                    String tanggal = modelRekapAbsenPeserta.getTanggal().toLowerCase();

                    if (jadwal.contains(newText)){
                        itemFilter.add(modelRekapAbsenPeserta);
                    } else if (tanggal.contains(newText)){
                        itemFilter.add(modelRekapAbsenPeserta);
                    }
                }
                adapterRvRekapAbsenPeserta.setFilter(itemFilter);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}