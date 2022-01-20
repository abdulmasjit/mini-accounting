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
import com.masjitsubekti.mini_accounting.model.CatatanKeuangan;

import java.util.ArrayList;

public class CatatanKeuanganActivity extends Activity implements View.OnClickListener {
    private ArrayList<CatatanKeuangan> values;
    private ListView listViewKeu;
    private FloatingActionButton btnFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan_keuangan);
        values = Objection.keuanganController.getListCatatanKeuangan();

        listViewKeu = findViewById(R.id.listCatatanKeuangan);
        listViewKeu.setDivider(null);

        btnFab = findViewById(R.id.fabCreate);
        btnFab.setOnClickListener(this);

        AdapterKeuangan adaptor = new AdapterKeuangan(this,
                R.layout.item_list_catatan_keuangan, values);
        listViewKeu.setAdapter(adaptor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                Intent intent = new Intent(CatatanKeuanganActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabCreate:
                Intent intent = new Intent(this, CreateCatatanKeuangan.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        values = Objection.accountController.getListAccount();
    }
}
