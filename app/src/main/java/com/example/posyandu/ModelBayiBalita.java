package com.example.posyandu;

public class ModelBayiBalita {
    String nama;
    String jenis_kelamin;
    String tanggal_lahir;
    String anak_ke;
    String nama_ibu;
    String nama_ayah;
    String status;

    public ModelBayiBalita(String nama, String jenis_kelamin, String tanggal_lahir, String anak_ke, String nama_ibu, String nama_ayah, String status){
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.tanggal_lahir = tanggal_lahir;
        this.anak_ke = anak_ke;
        this.nama_ibu = nama_ibu;
        this.nama_ayah = nama_ayah;
        this.status = status;
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

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getAnak_ke() {
        return anak_ke;
    }

    public void setAnak_ke(String anak_ke) {
        this.anak_ke = anak_ke;
    }

    public String getNama_ibu() {
        return nama_ibu;
    }

    public void setNama_ibu(String nama_ibu) {
        this.nama_ibu = nama_ibu;
    }

    public String getNama_ayah() {
        return nama_ayah;
    }

    public void setNama_ayah(String nama_ayah) {
        this.nama_ayah = nama_ayah;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
