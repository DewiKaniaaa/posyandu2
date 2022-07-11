package com.example.posyandu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class BayiBalitaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRvBayiBalita adapterRvBayiBalita;
    RecyclerView.LayoutManager rvLayoutManager;
    ArrayList<ModelBayiBalita> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayi_balita);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.rv_bayi_balita);
        recyclerView.setHasFixedSize(true);
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        data = new ArrayList<>();
        for (int i=0; i < DataBayiBalita.nama.length; i++){
            data.add(new ModelBayiBalita(
                    DataBayiBalita.nama[i],
                    DataBayiBalita.jenis_kelamin[i],
                    DataBayiBalita.tanggal_lahir[i],
                    DataBayiBalita.anak_ke[i],
                    DataBayiBalita.nama_ibu[i],
                    DataBayiBalita.nama_ayah[i],
                    DataBayiBalita.status[i]
            ));
        }
        adapterRvBayiBalita = new AdapterRvBayiBalita(this,data);
        recyclerView.setAdapter(adapterRvBayiBalita);
    }
}