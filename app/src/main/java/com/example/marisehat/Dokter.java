package com.example.marisehat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class Dokter extends AppCompatActivity implements RecylerViewInterface{

    // model buat nampung data dokter
    ArrayList<DokterModel> dokterModels = new ArrayList<>();

    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokter);

        RecyclerView recyclerViewDokter = findViewById(R.id.drRecyclerView);

        setDokterModels();

        // pastikan adapter setelah set data
        DokterRecylerViewAdapter adapter = new DokterRecylerViewAdapter(this, dokterModels, this);
        recyclerViewDokter.setAdapter(adapter);
        recyclerViewDokter.setLayoutManager(new LinearLayoutManager(this));


        // navigasi back
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(getApplicationContext(), Spesialis.class);
                startActivity(toHome);
                finish();
            }
        });
    }

    private void setDokterModels() {
        // get data dari string.xml
        String[] dokterNames = getResources().getStringArray(R.array.dokter_gigi_names);
        String[] rsNames = getResources().getStringArray(R.array.rs_names);
        String[] prices = getResources().getStringArray(R.array.prices);
        String[] experience = getResources().getStringArray(R.array.experiences);
        String[] distances = getResources().getStringArray(R.array.distance);
        String[] date_1 = getResources().getStringArray(R.array.date_1);
        String[] date_2 = getResources().getStringArray(R.array.date_2);
        String[] times = getResources().getStringArray(R.array.time);
        String[] desc = getResources().getStringArray(R.array.info_dokter);

        // loop buat isi data ke model
        for (int i = 0; i < dokterNames.length; i++) {
            dokterModels.add(new DokterModel(dokterNames[i], "Dokter Gigi", rsNames[i], prices[i],
                    experience[i], distances[i], date_1[i], date_2[i], times[i], desc[i]));
        }
    }

    @Override
    public void onClickDokter(int positon) {

        Intent detailDokter = new Intent(Dokter.this, DetailDokter.class);

        detailDokter.putExtra("DOKTOR_NAME", dokterModels.get(positon).getDokterName());
        detailDokter.putExtra("DATE1", dokterModels.get(positon).getDate_1());
        detailDokter.putExtra("DATE2", dokterModels.get(positon).getDate_2());

        startActivity(detailDokter);

    }
}