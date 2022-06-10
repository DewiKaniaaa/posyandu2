package com.example.posyandu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.posyandu.ui.bayibalita.BayiBalitaFragment;
import com.example.posyandu.ui.home.HomeFragment;
import com.example.posyandu.ui.kms.KmsFragment;
import com.example.posyandu.ui.menu.MenuFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContainerActivity extends AppCompatActivity {

    private static final String TAG = ContainerActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigationView;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.inflateMenu(R.menu.bottom_nav_menu);
        fragmentManager = getSupportFragmentManager();

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        if (username.equals("kader")){
            fragmentManager.beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();
        }
        else if (username.equals("peserta")){
            fragmentManager.beginTransaction().replace(R.id.main_container, new HomePesertaFragment()).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.navigation_home:
                        if (username.equals("kader")){
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
                        fragment = new MenuFragment();
                        break;
                }
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });
    }
}