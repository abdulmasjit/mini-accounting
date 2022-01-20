package com.masjitsubekti.mini_accounting.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.masjitsubekti.mini_accounting.Objection;
import com.masjitsubekti.mini_accounting.R;
import com.masjitsubekti.mini_accounting.model.Account;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class CreateCatatanKeuangan extends AppCompatActivity implements View.OnClickListener {
    private EditText edtJumlah, edtKeterangan;
    private Button btnCreate;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private EditText btDatePicker;

    Spinner spinnerAccount, spinnerJenis;
    ArrayList<String> accountArrayList = new ArrayList<String>();
    private ArrayList<String> listAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_catatan);
        listAccount = Objection.accountController.getListNameAccount();

        // inisialisasi
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvDateResult = (TextView) findViewById(R.id.edtDatePicker);
        btDatePicker = (EditText) findViewById(R.id.edtDatePicker);

        edtJumlah = findViewById(R.id.edtJumlah);
        edtKeterangan = findViewById(R.id.edtKeterangan);
        spinnerJenis = findViewById(R.id.spinnerJenis);

        btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);

        // Spinner
        spinnerAccount = (Spinner) findViewById(R.id.spinnerAccount);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listAccount);
        spinnerAccount.setAdapter(adapter);

        // Date picker
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvDateResult = (TextView) findViewById(R.id.edtDatePicker);
        btDatePicker = (EditText) findViewById(R.id.edtDatePicker);
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                Intent intent = new Intent(CreateCatatanKeuangan.this, CatatanKeuanganActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View v) {
        try {
            String jumlah = edtJumlah.getText().toString();
            String keterangan = edtKeterangan.getText().toString();
            String jenis = spinnerJenis.getSelectedItem().toString();
            String account = spinnerAccount.getSelectedItem().toString();
            String tanggal = String.valueOf(tvDateResult.getText().toString());

            if(keterangan.length()==0) {
                edtKeterangan.setError("Keterangan wajib diisi !");
            }else if(jumlah.length()==0) {
                edtJumlah.setError("Jumlah wajib diisi !");
            }else{
                if (v.getId() == R.id.btnCreate) {
                    Objection.keuanganController.insert(1, keterangan, tanggal, account, jenis, jumlah);

                    Toast.makeText(this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, CatatanKeuanganActivity.class);
                    startActivity(intent);
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "Please fill in the data!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showDateDialog(){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                tvDateResult.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }
}


