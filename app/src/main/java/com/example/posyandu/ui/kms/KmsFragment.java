package com.example.posyandu.ui.kms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.posyandu.databinding.FragmentKmsBinding;


public class KmsFragment extends Fragment {

    private FragmentKmsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        KmsViewModel kmsViewModel =
                new ViewModelProvider(this).get(KmsViewModel.class);

        binding = FragmentKmsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}