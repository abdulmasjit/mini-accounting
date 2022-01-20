package com.masjitsubekti.mini_accounting.service;

import com.masjitsubekti.mini_accounting.model.CatatanKeuangan;

import java.util.ArrayList;

public class CatatanKeuanganService {
    private ArrayList<CatatanKeuangan> catatanKeuangans;

    public CatatanKeuanganService(){
        catatanKeuangans = new ArrayList<>();
    }

    public ArrayList<CatatanKeuangan> getListCatatanKeuangan(){
        return catatanKeuangans;
    }

    public void insert(Object x) {
        catatanKeuangans.add((CatatanKeuangan) x);
    }

    public void update(int index, Object x) {
        catatanKeuangans.set(index ,(CatatanKeuangan) x);
    }

    public void delete(int index) {
        catatanKeuangans.remove(index);
    }
}
