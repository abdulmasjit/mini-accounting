package com.masjitsubekti.mini_accounting.model;

public class Account {
    private int id;
    private String nama;
    private String keterangan;
    private boolean akunKasBank;

    public Account(int id, String nama, String keterangan, boolean akunKasBank){
        this.id = id;
        this.nama = nama;
        this.keterangan = keterangan;
        this.akunKasBank = akunKasBank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public boolean getAkunKasBank() {
        return akunKasBank;
    }

    public void setAkunKasBank(boolean akunKasBank) {
        this.akunKasBank = akunKasBank;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

}
