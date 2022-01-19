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

import java.util.List;

public class AdapterAccount extends ArrayAdapter<Account> {

    private List<Account> listAccount;
    private Context context;
    private int resource;

    AdapterAccount(Context context, int resource, List<Account> listAccount) {
        super(context, resource, listAccount);
        this.context = context;
        this.resource = resource;
        this.listAccount = listAccount;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        @SuppressLint("ViewHolder")
        View view = layoutInflater.inflate(resource, null, false);

        TextView teks = view.findViewById(R.id.txtNama);
        TextView tekstil = view.findViewById(R.id.txtKeterangan);
        Button tombolHapus = view.findViewById(R.id.btnDelete);
        Button tombolEdit = view.findViewById(R.id.btnEdit);

        Account acc = listAccount.get(position);

        teks.setText(acc.getNama());
        tekstil.setText(acc.getKeterangan());

        tombolHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAccount(position);
            }
        });

        tombolEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editAccount(position);
            }
        });

        return view;
    }

    private void deleteAccount(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Apakah Kamu yakin ingin menghapus Account ?");

        builder.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialogInterface, int i) {
                Objection.accountController.delete(position);
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

    private void editAccount(final int position) {
        Account acc = listAccount.get(position);

        Intent intent = new Intent(context, UpdateAccount.class);
        intent.putExtra("index", position);
        intent.putExtra("id", acc.getId());
        intent.putExtra("nama", acc.getNama());
        intent.putExtra("keterangan", acc.getKeterangan());
        context.startActivity(intent);

//        ((Activity)context).finish();
    }
}
