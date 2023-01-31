package com.example.marisehat.model;

public class DokterModel {

    // variabel untuk menampung data di card nya
    String dokterName;
    String dokterSp;
    String rsName;
    String priceBooking;
    String experience;
    String distance;
    String date_1;
    String date_2;
    String time;
    String desc;

    public DokterModel(String dokterName, String dokterSp, String rsName, String priceBooking, String experience, String distance, String date_1, String date_2, String time, String desc) {
        this.dokterName = dokterName;
        this.dokterSp = dokterSp;
        this.rsName = rsName;
        this.priceBooking = priceBooking;
        this.experience = experience;
        this.distance = distance;
        this.date_1 = date_1;
        this.date_2 = date_2;
        this.time = time;
        this.desc = desc;
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

    public String getExperience() {
        return experience;
    }

    public String getDistance() {
        return distance;
    }

    public String getDate_1() {
        return date_1;
    }

    public String getDate_2() {
        return date_2;
    }

    public String getTime() {
        return time;
    }

    public String getDesc() {
        return desc;
    }
}
