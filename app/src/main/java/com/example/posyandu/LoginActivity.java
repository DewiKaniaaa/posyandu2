package com.example.posyandu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    TextView tvDaftar;
    EditText etUsername, etPassword;

    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager =new SessionManager(getApplicationContext());

        loginButton = findViewById(R.id.btn_masuk);
        tvDaftar = findViewById(R.id.tv_daftar);
        etUsername =findViewById(R.id.et_username);
        etPassword =findViewById(R.id.et_password);

        tvDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.equals("kader") && password.equals("kader")){
                    sessionManager.createSession(username);
                    Intent intent = new Intent(LoginActivity.this,ContainerActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(LoginActivity.this, etUsername.getText(), Toast.LENGTH_SHORT).show();
                }else if (username.equals("peserta") && password.equals("peserta")){
                    sessionManager.createSession(username);
                    Intent intent = new Intent(LoginActivity.this,ContainerActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(LoginActivity.this, etUsername.getText(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "user tidak ditemukan", Toast.LENGTH_SHORT).show();
                }
//                startActivity(new Intent(LoginActivity.this, ContainerActivity.class));
//                Intent intent = new Intent(LoginActivity.this,ContainerActivity.class);
//                intent.putExtra("USERNAME", etUsername.getText());
//                finish();
            }
        });
    }
}