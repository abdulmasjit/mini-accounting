package com.masjitsubekti.mini_accounting.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.masjitsubekti.mini_accounting.Objection;
import com.masjitsubekti.mini_accounting.R;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {
    private EditText edtAccName, edtAccKeterangan;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        edtAccName = findViewById(R.id.edtAccName);
        edtAccKeterangan = findViewById(R.id.edtAccKeterangan);

        btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                Intent intent = new Intent(CreateAccount.this, AccountActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View v) {
        try {
            String accName = edtAccName.getText().toString();
            String accKet = edtAccKeterangan.getText().toString();

            if(accName.length()==0) {
                edtAccName.setError("Nama wajib diisi !");
            }else{
                if (v.getId() == R.id.btnCreate) {
                    Objection.accountController.insert(1, accName, accKet);

                    Toast.makeText(this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, AccountActivity.class);
                    startActivity(intent);
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "Please fill in the data!", Toast.LENGTH_SHORT).show();
        }
    }
}
