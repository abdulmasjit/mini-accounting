package com.masjitsubekti.mini_accounting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.masjitsubekti.mini_accounting.Activity.AccountActivity;
import com.masjitsubekti.mini_accounting.Activity.PemasukanActivity;
import com.masjitsubekti.mini_accounting.Activity.PengeluaranActivity;
import com.masjitsubekti.mini_accounting.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAccount, btnPemasukan, btnPengeluaran, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
    }

    public void initComponent(){
        btnAccount = findViewById(R.id.btnAccount);
        btnAccount.setOnClickListener(this);

        btnPemasukan = findViewById(R.id.btnPemasukan);
        btnPemasukan.setOnClickListener(this);

        btnPengeluaran = findViewById(R.id.btnPengeluaran);
        btnPengeluaran.setOnClickListener(this);

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAccount :
                // start create activity
                Intent i1 = new Intent(this, AccountActivity.class);
                startActivity(i1);
                break;
            case R.id.btnPemasukan :
                // start read activity
                Intent i2 = new Intent(this, PemasukanActivity.class);
                startActivity(i2);
                break;
            case R.id.btnPengeluaran :
                // start update
                Intent i3 = new Intent(this, PengeluaranActivity.class);
                startActivity(i3);
                break;
            case R.id.btnLogout :
                // start delete activity
                Intent i4 = new Intent(this, MainActivity.class);
                startActivity(i4);
                break;
        }
    }
}
