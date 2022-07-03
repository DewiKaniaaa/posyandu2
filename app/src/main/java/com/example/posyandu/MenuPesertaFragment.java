package com.example.posyandu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MenuPesertaFragment extends Fragment {

    CardView cvLogout, cvKelolaAbsenPeserta, cvKelolaJadwal, cvStatusGizi;
    SharedPreferences sharedPreferences;
    int mode =0;

    private static final String pref_posyandu ="prefPosyandu";
    private static final String key_username ="keyUsername";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_peserta, container, false);

        cvLogout = view.findViewById(R.id.cv_logout);
        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getContext().getSharedPreferences(pref_posyandu, mode);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();

                Intent i = new Intent(getContext(), LoginActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                getActivity().finish();
            }
        });

        cvKelolaAbsenPeserta = view.findViewById(R.id.cv_kelola_absen_peserta);
        cvKelolaAbsenPeserta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), KelolaAbsenPesertaActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                getActivity().finish();
            }
        });

        cvKelolaJadwal = view.findViewById(R.id.cv_kelola_jadwal);
        cvKelolaJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), KelolaJadwalPesertaActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                getActivity().finish();
            }
        });

        cvStatusGizi = view.findViewById(R.id.cv_status_gizi);
        cvStatusGizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), CekStatusGiziActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                getActivity().finish();
            }
        });
        return view;
    }
}