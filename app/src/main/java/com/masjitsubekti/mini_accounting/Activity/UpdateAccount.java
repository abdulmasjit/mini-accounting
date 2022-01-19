package com.masjitsubekti.mini_accounting.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.masjitsubekti.mini_accounting.Objection;
import com.masjitsubekti.mini_accounting.R;

public class UpdateAccount extends AppCompatActivity implements View.OnClickListener {
    private EditText edtAccName, edtAccKeterangan;
    private Button btnUpdate;
    private String accName, accKeterangan;
    private int indexID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        indexID = getIntent().getExtras().getInt("index");
        accName = getIntent().getExtras().getString("nama");
        accKeterangan = getIntent().getExtras().getString("keterangan");

        edtAccName = (EditText) findViewById(R.id.edtAccName);
        edtAccName.setText(accName);

        edtAccKeterangan = (EditText) findViewById(R.id.edtAccKeterangan);
        edtAccKeterangan.setText(accKeterangan);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);
    }

    public void onClick(View v) {
        try {
            accName = edtAccName.getText().toString();
            accKeterangan = edtAccKeterangan.getText().toString();

            if(accName.length()==0) {
                edtAccName.setError("Nama wajib diisi!");
            }else{
                if (v.getId() == R.id.btnUpdate) {
                    Objection.accountController.update(indexID,1, accName, accKeterangan);

                    Toast.makeText(this, "Data berhasil diupdate!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(this, AccountActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "Please fill in the data!", Toast.LENGTH_SHORT).show();
        }
    }
}
