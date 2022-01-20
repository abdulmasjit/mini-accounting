package com.masjitsubekti.mini_accounting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.masjitsubekti.mini_accounting.Activity.AccountActivity;
import com.masjitsubekti.mini_accounting.Activity.CatatanKeuanganActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAccount, btnCatatanKeuangan, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
    }

    public void initComponent(){
        btnAccount = findViewById(R.id.btnAccount);
        btnAccount.setOnClickListener(this);

        btnCatatanKeuangan = findViewById(R.id.btnCatatanKeuangan);
        btnCatatanKeuangan.setOnClickListener(this);

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAccount :
                // start account activity
                Intent i1 = new Intent(this, AccountActivity.class);
                startActivity(i1);
                break;
            case R.id.btnCatatanKeuangan :
                // start catatan keuangan activity
                Intent i2 = new Intent(this, CatatanKeuanganActivity.class);
                startActivity(i2);
                break;
            case R.id.btnLogout :
                // start logout activity
                Intent i3 = new Intent(this, MainActivity.class);
                startActivity(i3);
                break;
        }
    }
}
