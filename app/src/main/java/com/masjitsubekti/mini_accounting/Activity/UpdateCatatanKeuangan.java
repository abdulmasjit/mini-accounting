package com.masjitsubekti.mini_accounting.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class UpdateCatatanKeuangan extends Activity implements View.OnClickListener {
    private EditText edtKeterangan, edtJumlah, edtTanggal;
    private Button btnUpdate;
    private String keterangan, tanggal, jenis, account, jumlah;
    private int indexID;

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
        setContentView(R.layout.update_catatan_keuangan);
        listAccount = Objection.accountController.getListNameAccount();

        indexID = getIntent().getExtras().getInt("index");
        keterangan = getIntent().getExtras().getString("keterangan");
        tanggal = getIntent().getExtras().getString("tanggal");
        jenis = getIntent().getExtras().getString("jenis");
        account = getIntent().getExtras().getString("account");
        jumlah = getIntent().getExtras().getString("jumlah");

        spinnerJenis = findViewById(R.id.spinnerJenis);
        spinnerAccount = findViewById(R.id.spinnerAccount);

        edtKeterangan = (EditText) findViewById(R.id.edtKeterangan);
        edtKeterangan.setText(keterangan);

        edtJumlah = (EditText) findViewById(R.id.edtJumlah);
        edtJumlah.setText(jumlah);

        edtTanggal = (EditText) findViewById(R.id.edtDatePicker);
        edtTanggal.setText(tanggal);

        btnUpdate = findViewById(R.id.btnUpdateKeu);
        btnUpdate.setOnClickListener(this);

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
                Intent intent = new Intent(UpdateCatatanKeuangan.this, CatatanKeuanganActivity.class);
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
                if (v.getId() == R.id.btnUpdateKeu) {
                    Objection.keuanganController.update(indexID,1, keterangan, tanggal, account, jenis, jumlah);

                    Toast.makeText(this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, CatatanKeuanganActivity.class);
                    startActivity(intent);
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
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
