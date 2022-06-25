package com.example.posyandu;

public class ModelPeserta {
    String nama;
    String tanggal_lahir;
    String jenis_kelamin;

    public ModelPeserta(String nama, String tanggal_lahir, String jenis_kelamin){
        this.tanggal_lahir = tanggal_lahir;
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }
}
