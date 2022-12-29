package com.example.marisehat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "marisehat.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE pasien (id_pasien INTEGER PRIMARY KEY, nama VARCHAR(50) NOT NULL, jenkel VARCHAR(15) NOT NULL, usia VARCHAR(10) NOT NULL, keluhan TEXT NOT NULL, nama_dokter VARCHAR(80) NOT NULL, nama_rs VARCHAR(50) NOT NULL, spesialis VARCHAR(50) NOT NULL, tanggal VARCHAR(50) NOT NULL, waktu VARCHAR(50) NOT NULL, harga VARCHAR(50) NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS pasien");
    }


    // insert pasien
    public boolean insertBookPasien(String nama, String jenkel, String usia, String keluhan, String namaDok, String namaRS, String spesialis, String tanggal, String waktu, String harga) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nama", nama);
        contentValues.put("jenkel", jenkel);
        contentValues.put("usia", usia);
        contentValues.put("keluhan", keluhan);

        contentValues.put("nama_dokter", namaDok);
        contentValues.put("nama_rs", namaRS);
        contentValues.put("spesialis", spesialis);
        contentValues.put("tanggal", tanggal);
        contentValues.put("waktu", waktu);
        contentValues.put("harga", harga);

        long res = DB.insert("pasien", null, contentValues);
        return res != -1;
    }


    // get user
    public Cursor getPasien() {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("SELECT * FROM pasien", null);
        return cursor;
    }

}
