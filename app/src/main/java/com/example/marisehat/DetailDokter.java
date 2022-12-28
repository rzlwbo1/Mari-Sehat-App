package com.example.marisehat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailDokter extends AppCompatActivity {

    TextView dokName, date1, date2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dokter);

        String name = getIntent().getStringExtra("DOKTOR_NAME");
        String date_1 = getIntent().getStringExtra("DATE1");
        String date_2 = getIntent().getStringExtra("DATE2");

    }
}