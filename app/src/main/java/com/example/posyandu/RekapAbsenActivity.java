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
import java.util.Locale;

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
//        getMenuInflater().inflate(R.menu.menu_rekap_absen, menu);
//        return true;

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_rekap_absen, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                ArrayList<ModelRekapAbsen> itemFilter = new ArrayList<>();
                for (ModelRekapAbsen modelRekapAbsen : data){
                    String jadwal = modelRekapAbsen.getJadwal().toLowerCase();
                    String tanggal = modelRekapAbsen.getTanggal().toLowerCase();

                    if (jadwal.contains(newText)){
                        itemFilter.add(modelRekapAbsen);
                    } else if (tanggal.contains(newText)){
                        itemFilter.add(modelRekapAbsen);
                    }
                }
                adapterRvRekapAbsen.setFilter(itemFilter);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}