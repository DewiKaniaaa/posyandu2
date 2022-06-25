package com.example.posyandu;

public class ModelRekapAbsenPeserta {
    String jadwal;
    String tanggal;

    public ModelRekapAbsenPeserta(String jadwal, String tanggal){
        this.jadwal = jadwal;
        this.tanggal = tanggal;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
