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

public class KelolaUserPesertaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRvKelolaUserPeserta adapterRvKelolaUserPeserta;
    RecyclerView.LayoutManager rvLayoutManager;
    ArrayList<ModelPeserta> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_user_peserta);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        recyclerView = findViewById(R.id.rv_kelola_peserta);
        recyclerView.setHasFixedSize(true);
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        data = new ArrayList<>();
        for (int i=0; i < DataPeserta.nama.length; i++){
            data.add(new ModelPeserta(
                    DataPeserta.nama[i],
                    DataPeserta.no_telepon[i],
                    DataPeserta.jenis_kelamin[i],
                    DataPeserta.tanggal_lahir[i]
            ));
        }
        adapterRvKelolaUserPeserta = new AdapterRvKelolaUserPeserta(this,data);
        recyclerView.setAdapter(adapterRvKelolaUserPeserta);
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
                ArrayList<ModelPeserta> itemFilter = new ArrayList<>();
                for (ModelPeserta modelPeserta : data){
                    String nama = modelPeserta.getNama().toLowerCase();
                    String telepon = modelPeserta.getNo_telepon().toLowerCase();

                    if (nama.contains(newText)){
                        itemFilter.add(modelPeserta);
                    } else if (telepon.contains(newText)){
                        itemFilter.add(modelPeserta);
                    }
                }
                adapterRvKelolaUserPeserta.setFilter(itemFilter);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}