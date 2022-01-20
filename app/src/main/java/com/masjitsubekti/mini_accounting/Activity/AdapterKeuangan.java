package com.masjitsubekti.mini_accounting.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.masjitsubekti.mini_accounting.Objection;
import com.masjitsubekti.mini_accounting.R;
import com.masjitsubekti.mini_accounting.model.Account;
import com.masjitsubekti.mini_accounting.model.CatatanKeuangan;

import java.util.List;

public class AdapterKeuangan extends ArrayAdapter<CatatanKeuangan> {

    private List<CatatanKeuangan> listKeuangan;
    private Context context;
    private int resource;

    AdapterKeuangan(Context context, int resource, List<CatatanKeuangan> listKeuangan) {
        super(context, resource, listKeuangan);
        this.context = context;
        this.resource = resource;
        this.listKeuangan = listKeuangan;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        @SuppressLint("ViewHolder")
        View view = layoutInflater.inflate(resource, null, false);

        TextView teksKet = view.findViewById(R.id.txtKeterangan);
        TextView teksJenis = view.findViewById(R.id.txtJenis);
        TextView teksTanggal = view.findViewById(R.id.txtTanggal);
        TextView teksJumlah = view.findViewById(R.id.txtJumlah);
        Button tombolHapus = view.findViewById(R.id.btnDeleteKeu);
        Button tombolEdit = view.findViewById(R.id.btnEditKeu);

        CatatanKeuangan keu = listKeuangan.get(position);

        teksKet.setText(keu.getKeterangan());
        teksTanggal.setText(keu.getTanggal());
        teksJenis.setText(keu.getJenis() + " - " + keu.getAccount());
        teksJumlah.setText(keu.getJumlah());

        tombolHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteKeu(position);
            }
        });

        tombolEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editKeu(position);
            }
        });

        return view;
    }

    private void deleteKeu(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Apakah Kamu yakin ingin menghapus catatan keuangan ?");

        builder.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialogInterface, int i) {
                Objection.keuanganController.delete(position);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void editKeu(final int position) {
        CatatanKeuangan keu = listKeuangan.get(position);

        Intent intent = new Intent(context, UpdateCatatanKeuangan.class);
        intent.putExtra("index", position);
        intent.putExtra("id", keu.getId());
        intent.putExtra("keterangan", keu.getKeterangan());
        intent.putExtra("tanggal", keu.getTanggal());
        intent.putExtra("jenis", keu.getJenis());
        intent.putExtra("account", keu.getAccount());
        intent.putExtra("jumlah", keu.getJumlah());
        context.startActivity(intent);

        ((Activity)context).finish();
    }
}
