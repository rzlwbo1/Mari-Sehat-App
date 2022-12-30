package com.example.marisehat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Spesialis extends AppCompatActivity {

    ImageButton btnBack;
    Spinner lokasiSpin;
    CardView sp_gigi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_spesialis);

        // navigasi back
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(getApplicationContext(), HomeSreen.class);
                startActivity(toHome);
                finish();
            }
        });

        sp_gigi = findViewById(R.id.sp_gigi);
        sp_gigi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toDokter = new Intent(getApplicationContext(), Dokter.class);
                startActivity(toDokter);
            }
        });

    }
}