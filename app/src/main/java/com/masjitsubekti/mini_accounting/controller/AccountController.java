package com.masjitsubekti.mini_accounting.controller;

import com.masjitsubekti.mini_accounting.model.Account;
import com.masjitsubekti.mini_accounting.service.AccountService;

import java.util.ArrayList;

public class AccountController {
    AccountService acc_service;
    ArrayList<String> mylist;

    public AccountController() {
        acc_service = new AccountService();
    }

    public ArrayList<Account> getListAccount(){
        return acc_service.getListAccounts();
    }

    public void dataAccountDefault(){
        int id [] = {1, 2, 3};
        String nama [] = {"Bank Mandiri", "Uang Tabungan", "Uang Transportasi"};
        String keterangan [] = {"Bank Mandiri", "Uang Tabungan", "Uang Transportasi"};
        for (int i = 0; i < id.length; i++) {
            acc_service.insert(new Account(id[i], nama[i], keterangan[i]));
        }
    }

    public ArrayList<String> getListNameAccount(){
        mylist = new ArrayList<String>();
        for (int i = 0; i < getListAccount().size(); i++) {
            mylist.add(getListAccount().get(i).getNama());
        }

        return mylist;
    }

    public void insert(int id, String nama, String keterangan){
        Account data = new Account();
        data.setId(id);
        data.setNama(nama);
        data.setKeterangan(keterangan);
        // Insert Objection
        acc_service.insert(data);
    }

    public void update(int index, int id, String nama, String keterangan){
        Account data = new Account();
        data.setId(id);
        data.setNama(nama);
        data.setKeterangan(keterangan);
        // Update Objection
        acc_service.update(index, data);
    }


    public void delete(int index){
        // Delete Objection
        acc_service.delete(index);
    }

    public Account getDetail(int index){
        return acc_service.getListAccounts().get(index);
    }
}
