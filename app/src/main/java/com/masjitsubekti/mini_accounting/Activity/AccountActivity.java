package com.masjitsubekti.mini_accounting.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.masjitsubekti.mini_accounting.HomeActivity;
import com.masjitsubekti.mini_accounting.Objection;
import com.masjitsubekti.mini_accounting.R;
import com.masjitsubekti.mini_accounting.model.Account;

import java.util.ArrayList;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Account> values;
    private ListView listViewAcc;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
//        Objection.accountController.dataAccountDefault();
        values = Objection.accountController.getListAccount();

        listViewAcc = findViewById(R.id.listAccount);
        btnCreate = findViewById(R.id.btnCreateAccount);
        btnCreate.setOnClickListener(this);

        AdapterAccount adaptor = new AdapterAccount(this,
                R.layout.item_list_account, values);
        listViewAcc.setAdapter(adaptor);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCreateAccount:
                Intent intent = new Intent(this, CreateAccount.class);
                startActivity(intent);
                break;
        }
    }
}
