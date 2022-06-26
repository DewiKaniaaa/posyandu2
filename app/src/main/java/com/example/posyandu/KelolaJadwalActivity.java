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

public class KelolaJadwalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRvKelolaJadwal adapterRvKelolaJadwal;
    RecyclerView.LayoutManager rvLayoutManager;
    ArrayList<ModelJadwal> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_jadwal);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.rv_kelola_jadwal);
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
        adapterRvKelolaJadwal = new AdapterRvKelolaJadwal(this,data);
        recyclerView.setAdapter(adapterRvKelolaJadwal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_kelola_jadwal, menu);
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
                adapterRvKelolaJadwal.setFilter(itemFilter);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.menu_tambah:
                Intent intent = new Intent(KelolaJadwalActivity.this, TambahJadwalActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}