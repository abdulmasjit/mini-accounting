package com.masjitsubekti.mini_accounting.controller;

import com.masjitsubekti.mini_accounting.model.Account;
import com.masjitsubekti.mini_accounting.model.CatatanKeuangan;
import com.masjitsubekti.mini_accounting.service.CatatanKeuanganService;

import java.util.ArrayList;

public class CatatanKeuanganController {
    CatatanKeuanganService keu_service;

    public CatatanKeuanganController() {
        keu_service = new CatatanKeuanganService();
    }

    public ArrayList<CatatanKeuangan> getListCatatanKeuangan(){
        return keu_service.getListCatatanKeuangan();
    }

    public void insert(int id, String keterangan, String tanggal, String account, String jenis, String jumlah){
        CatatanKeuangan data = new CatatanKeuangan();
        data.setId(id);
        data.setKeterangan(keterangan);
        data.setTanggal(tanggal);
        data.setAccount(account);
        data.setJenis(jenis);
        data.setJumlah(jumlah);
        // Insert Objection
        keu_service.insert(data);
    }

    public void update(int index, int id, String keterangan, String tanggal, String account, String jenis, String jumlah){
        CatatanKeuangan data = new CatatanKeuangan();
        data.setId(id);
        data.setKeterangan(keterangan);
        data.setTanggal(tanggal);
        data.setAccount(account);
        data.setJenis(jenis);
        data.setJumlah(jumlah);
        // Update Objection
        keu_service.update(index, data);
    }


    public void delete(int index){
        // Delete Objection
        keu_service.delete(index);
    }

    public CatatanKeuangan getDetail(int index){
        return keu_service.getListCatatanKeuangan().get(index);
    }
}
