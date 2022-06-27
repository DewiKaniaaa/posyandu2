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
import android.widget.Toast;

import java.util.ArrayList;

public class KelolaUserKaderActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRvKelolaUserKader adapterRvKelolaUserKader;
    RecyclerView.LayoutManager rvLayoutManager;
    ArrayList<ModelKelolaUserKader> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_user_kader);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.rv_kelola_user_kader);
        recyclerView.setHasFixedSize(true);
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        data = new ArrayList<>();
        for (int i=0; i < DataKelolaUserKader.nama.length; i++){
            data.add(new ModelKelolaUserKader(
                    DataKelolaUserKader.nama[i],
                    DataKelolaUserKader.no_telepon[i],
                    DataKelolaUserKader.jenis_kelamin[i],
                    DataKelolaUserKader.tanggal_lahir[i]
            ));
        }
        adapterRvKelolaUserKader = new AdapterRvKelolaUserKader(this,data);
        recyclerView.setAdapter(adapterRvKelolaUserKader);
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
                ArrayList<ModelKelolaUserKader> itemFilter = new ArrayList<>();
                for (ModelKelolaUserKader modelKelolaUserKader : data){
                    String nama = modelKelolaUserKader.getNama().toLowerCase();
                    String telepon = modelKelolaUserKader.getNo_telepon().toLowerCase();

                    if (nama.contains(newText)){
                        itemFilter.add(modelKelolaUserKader);
                    } else if (telepon.contains(newText)){
                        itemFilter.add(modelKelolaUserKader);
                    }
                }
                adapterRvKelolaUserKader.setFilter(itemFilter);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.menu_tambah:
                Toast.makeText(this, "Halaman Tambah User Kader", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(KelolaJadwalActivity.this, TambahJadwalActivity.class);
//                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}