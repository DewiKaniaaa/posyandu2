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

public class KelolaJadwalPesertaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRvKelolaJadwalPeserta adapterRvKelolaJadwalPeserta;
    RecyclerView.LayoutManager rvLayoutManager;
    ArrayList<ModelJadwal> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_jadwal_peserta);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.rv_kelola_jadwal_peserta);
        recyclerView.setHasFixedSize(true);
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        data = new ArrayList<>();
        for (int i=0; i < DataJadwal.jadwal.length; i++){
            data.add(new ModelJadwal(
                    DataJadwal.jadwal[i],
                    DataJadwal.tanggal[i],
                    DataJadwal.status[i]
            ));
        }
        adapterRvKelolaJadwalPeserta = new AdapterRvKelolaJadwalPeserta(this,data);
        recyclerView.setAdapter(adapterRvKelolaJadwalPeserta);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_only_search, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                ArrayList<ModelJadwal> itemFilter = new ArrayList<>();
                for (ModelJadwal modelJadwal : data){
                    String jadwal = modelJadwal.getJadwal().toLowerCase();
                    String tanggal = modelJadwal.getTanggal().toLowerCase();

                    if (jadwal.contains(newText)){
                        itemFilter.add(modelJadwal);
                    } else if (tanggal.contains(newText)){
                        itemFilter.add(modelJadwal);
                    }
                }
                adapterRvKelolaJadwalPeserta.setFilter(itemFilter);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}