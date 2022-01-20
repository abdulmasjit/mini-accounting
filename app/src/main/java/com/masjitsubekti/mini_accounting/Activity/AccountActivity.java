package com.masjitsubekti.mini_accounting.Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.masjitsubekti.mini_accounting.HomeActivity;
import com.masjitsubekti.mini_accounting.Objection;
import com.masjitsubekti.mini_accounting.R;
import com.masjitsubekti.mini_accounting.model.Account;

import java.util.ArrayList;

public class AccountActivity extends Activity implements View.OnClickListener {
    private ArrayList<Account> values;
    private ListView listViewAcc;
    private FloatingActionButton btnFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        values = Objection.accountController.getListAccount();

        listViewAcc = findViewById(R.id.listAccount);
        listViewAcc.setDivider(null);

        btnFab = findViewById(R.id.fabCreate);
        btnFab.setOnClickListener(this);

        AdapterAccount adaptor = new AdapterAccount(this,
                R.layout.item_list_account, values);
        listViewAcc.setAdapter(adaptor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                Intent intent = new Intent(AccountActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabCreate:
                Intent intent = new Intent(this, CreateAccount.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        values = Objection.accountController.getListAccount();
    }
}
