package com.example.posyandu;

public class ModelBayi {
    String nama;
    String berat_badan;

    public ModelBayi(String nama, String berat_badan){
        this.nama = nama;
        this.berat_badan = berat_badan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBerat_badan() {
        return berat_badan;
    }

    public void setBerat_badan(String berat_badan) {
        this.berat_badan = berat_badan;
    }
}
