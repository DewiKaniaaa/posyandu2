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

public class LihatLaporanActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRvLaporanListBayi adapterRvLaporanListBayi;
    RecyclerView.LayoutManager rvLayoutManager;
    ArrayList<ModelBayi> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_laporan);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.rv_laporan_list_bayi);
        recyclerView.setHasFixedSize(true);
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        data = new ArrayList<>();
        for (int i=0; i < DataBayi.nama.length; i++){
            data.add(new ModelBayi(
                    DataBayi.nama[i],
                    DataBayi.berat_badan[i]
            ));
        }
        adapterRvLaporanListBayi = new AdapterRvLaporanListBayi(this,data);
        recyclerView.setAdapter(adapterRvLaporanListBayi);
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
                ArrayList<ModelBayi> itemFilter = new ArrayList<>();
                for (ModelBayi modelBayi : data){
                    String nama = modelBayi.getNama().toLowerCase();
                    String berat_badan = modelBayi.getBerat_badan().toLowerCase();

                    if (nama.contains(newText)){
                        itemFilter.add(modelBayi);
                    } else if (berat_badan.contains(newText)){
                        itemFilter.add(modelBayi);
                    }
                }
                adapterRvLaporanListBayi.setFilter(itemFilter);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.menu_tambah:
                Intent intent = new Intent(LihatLaporanActivity.this, LaporanTambahBayiActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}