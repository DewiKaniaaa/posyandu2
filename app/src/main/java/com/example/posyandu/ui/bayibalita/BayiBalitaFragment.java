package com.example.posyandu.ui.bayibalita;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.posyandu.databinding.FragmentBayibalitaBinding;

public class BayiBalitaFragment extends Fragment {

    private FragmentBayibalitaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BayiBalitaViewModel bayiBalitaViewModel =
                new ViewModelProvider(this).get(BayiBalitaViewModel.class);

        binding = FragmentBayibalitaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}