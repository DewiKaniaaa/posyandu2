package com.example.posyandu.ui.menu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.posyandu.CekStatusGiziActivity;
import com.example.posyandu.KelolaAbsenKaderActivity;
import com.example.posyandu.KelolaJadwalActivity;
import com.example.posyandu.KelolaLaporanActivity;
import com.example.posyandu.KelolaUserActivity;
import com.example.posyandu.LoginActivity;
import com.example.posyandu.ProfilActivity;
import com.example.posyandu.R;


public class MenuFragment extends Fragment {

    CardView cvLogout, cvKelolaAbsen, cvKelolaJadwal, cvKelolaUser, cvStatusGizi, cvProfil, cvKelolaLaporan;
    SharedPreferences sharedPreferences;
    int mode =0;

    private static final String pref_posyandu ="prefPosyandu";
    private static final String key_username ="keyUsername";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

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

        cvKelolaAbsen = view.findViewById(R.id.cv_kelola_absen);
        cvKelolaAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), KelolaAbsenKaderActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

        cvKelolaJadwal = view.findViewById(R.id.cv_kelola_jadwal);
        cvKelolaJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), KelolaJadwalActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

        cvKelolaUser = view.findViewById(R.id.cv_Kelola_user);
        cvKelolaUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), KelolaUserActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
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
            }
        });

        cvProfil = view.findViewById(R.id.cv_profil);
        cvProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ProfilActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

        cvKelolaLaporan = view.findViewById(R.id.cv_kelola_laporan);
        cvKelolaLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), KelolaLaporanActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
        return view;

    }
}