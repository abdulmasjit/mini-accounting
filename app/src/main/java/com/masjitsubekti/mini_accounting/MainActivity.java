package com.masjitsubekti.mini_accounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.masjitsubekti.mini_accounting.Activity.CatatanKeuanganActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String username, password;
    private EditText edtUsername, edtPassword;
    Button cirLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.editTextEmail);
        edtPassword = findViewById(R.id.editTextPassword);

        cirLoginButton = findViewById(R.id.cirLoginButton);
        cirLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cirLoginButton:
                login();
                break;
        }
    }

    public void login(){
        try {
            username = "user";
            password = "123456";
            String uname = edtUsername.getText().toString();
            String pass = edtPassword.getText().toString();

            if(uname.length()==0) {
                edtUsername.setError("Username wajib diisi !");
            }else if(pass.length()==0) {
                edtPassword.setError("Password wajib diisi !");
            }else{
                if(uname.equals(username) && pass.equals(password)){
                    Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "Login Gagal!", Toast.LENGTH_SHORT).show();
        }
    }
}
