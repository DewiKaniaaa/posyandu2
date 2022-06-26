package com.example.posyandu;

public class ModelJadwal {
    String jadwal;
    String tanggal;
    String status;

    public ModelJadwal(String jadwal, String tanggal, String status){
        this.jadwal = jadwal;
        this.tanggal = tanggal;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
