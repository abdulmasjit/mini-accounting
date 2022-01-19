package com.masjitsubekti.mini_accounting.model;

public class Account {
    private int id;
    private String nama;
    private String keterangan;

    public Account(){}
    public Account(int id, String nama, String keterangan){
        this.id = id;
        this.nama = nama;
        this.keterangan = keterangan;
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

}
