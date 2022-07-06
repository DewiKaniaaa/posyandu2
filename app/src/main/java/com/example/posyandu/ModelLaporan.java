package com.example.posyandu;

public class ModelLaporan {
    String judul;
    String bulan;
    String tahun;
    String keterangan;

    public ModelLaporan(String judul, String bulan, String tahun, String keterangan){
        this.judul = judul;
        this.bulan = bulan;
        this.tahun = tahun;
        this.keterangan = keterangan;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
