package com.example.posyandu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.posyandu.ui.bayibalita.BayiBalitaFragment;
import com.example.posyandu.ui.home.HomeFragment;
import com.example.posyandu.ui.kms.KmsFragment;
import com.example.posyandu.ui.menu.MenuFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

public class ContainerActivity extends AppCompatActivity {


    private static final String TAG = ContainerActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigationView;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    SessionManager sessionManager;
    String user;
    SharedPreferences sharedPreferences;
    int mode =0;

    private static final String pref_posyandu ="prefPosyandu";
    private static final String key_username ="keyUsername";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.inflateMenu(R.menu.bottom_nav_menu);
        fragmentManager = getSupportFragmentManager();

        sharedPreferences = getSharedPreferences(pref_posyandu, mode);
        user = sharedPreferences.getString(key_username, null);
        if (user.equals("kader")){
            fragmentManager.beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();
        }
        else if (user.equals("peserta")){
            fragmentManager.beginTransaction().replace(R.id.main_container, new HomePesertaFragment()).commit();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.navigation_home:
                        if (user.equals("kader")){
                            fragment = new HomeFragment();
                        }
                        else {
                            fragment = new HomePesertaFragment();
                        }
                        break;
                    case R.id.navigation_bayibalita:
                        fragment = new BayiBalitaFragment();
                        break;
                    case R.id.navigation_kms:
                        fragment = new KmsFragment();
                        break;
                    case R.id.navigation_menu:
                        if (user.equals("kader")){
                            fragment = new MenuFragment();
                        }else {
                            fragment = new MenuPesertaFragment();
                        }
                        break;
                }
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });
    }
}