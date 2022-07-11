package com.example.posyandu.ui.bayibalita;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.posyandu.AdapterRvBayiBalita;
import com.example.posyandu.DataBayiBalita;
import com.example.posyandu.ModelBayiBalita;
import com.example.posyandu.R;
import com.example.posyandu.databinding.FragmentBayibalitaBinding;

import java.util.ArrayList;

public class BayiBalitaFragment extends Fragment {

    private FragmentBayibalitaBinding binding;

    RecyclerView recyclerView;
    AdapterRvBayiBalita adapterRvBayiBalita;
    RecyclerView.LayoutManager rvLayoutManager;
    ArrayList<ModelBayiBalita> data;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BayiBalitaViewModel bayiBalitaViewModel =
                new ViewModelProvider(this).get(BayiBalitaViewModel.class);

        binding = FragmentBayibalitaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        recyclerView = root.findViewById(R.id.rv_bayi_balita);
        recyclerView.setHasFixedSize(true);
        rvLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        data = new ArrayList<>();
        for (int i = 0; i < DataBayiBalita.nama.length; i++){
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
        adapterRvBayiBalita = new AdapterRvBayiBalita(getActivity(),data);
        recyclerView.setAdapter(adapterRvBayiBalita);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}