package com.example.marisehat;

public class ListBookModel {

    String namaPasien;
    String jenkel;
    String usia;
    String keluhan;
    String namaDok;
    String spesialis;
    String namaRS;
    String tglBook;
    String waktu;
    String harga;

    public ListBookModel(String namaPasien, String jenkel, String usia, String keluhan, String namaDok, String namaRS, String spesialis, String tglBook, String waktu, String harga) {
        this.namaPasien = namaPasien;
        this.jenkel = jenkel;
        this.usia = usia;
        this.keluhan = keluhan;
        this.namaDok = namaDok;
        this.namaRS = namaRS;
        this.spesialis = spesialis;
        this.tglBook = tglBook;
        this.waktu = waktu;
        this.harga = harga;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public String getJenkel() {
        return jenkel;
    }

    public String getUsia() {
        return usia;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public String getNamaDok() {
        return namaDok;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public String getNamaRS() {
        return namaRS;
    }

    public String getTglBook() {
        return tglBook;
    }

    public String getWaktu() {
        return waktu;
    }

    public String getHarga() {
        return harga;
    }
}
