package com.example.marisehat;

public class DokterModel {

    // variabel untuk menampung data di card nya
    String dokterName;
    String dokterSp;
    String rsName;
    String priceBooking;

    public DokterModel(String dokterName, String dokterSp, String rsName, String priceBooking) {
        this.dokterName = dokterName;
        this.dokterSp = dokterSp;
        this.rsName = rsName;
        this.priceBooking = priceBooking;
    }

    public String getDokterName() {
        return dokterName;
    }

    public String getDokterSp() {
        return dokterSp;
    }

    public String getRsName() {
        return rsName;
    }

    public String getPriceBooking() {
        return priceBooking;
    }
}
