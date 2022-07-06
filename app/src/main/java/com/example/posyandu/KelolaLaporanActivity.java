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
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class KelolaLaporanActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRvKelolaLaporan adapterRvKelolaLaporan;
    RecyclerView.LayoutManager rvLayoutManager;
    ArrayList<ModelLaporan> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_laporan);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.rv_kelola_laporan);
        recyclerView.setHasFixedSize(true);
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        data = new ArrayList<>();
        for (int i=0; i < DataLaporan.judul.length; i++){
            data.add(new ModelLaporan(
                    DataLaporan.judul[i],
                    DataLaporan.bulan[i],
                    DataLaporan.tahun[i],
                    DataLaporan.keterangan[i]
            ));
        }
        adapterRvKelolaLaporan = new AdapterRvKelolaLaporan(this,data);
        recyclerView.setAdapter(adapterRvKelolaLaporan);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_cari_tambah, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                ArrayList<ModelLaporan> itemFilter = new ArrayList<>();
                for (ModelLaporan modelLaporan : data){
                    String judul = modelLaporan.getJudul().toLowerCase();
                    String bulan = modelLaporan.getBulan().toLowerCase();

                    if (judul.contains(newText)){
                        itemFilter.add(modelLaporan);
                    } else if (bulan.contains(newText)){
                        itemFilter.add(modelLaporan);
                    }
                }
                adapterRvKelolaLaporan.setFilter(itemFilter);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.menu_tambah:
//                Intent intent = new Intent(KelolaLaporanActivity.this, KelolaLaporanActivity.class);
//                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}