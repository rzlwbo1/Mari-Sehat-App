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

public class Dokter extends AppCompatActivity {

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
        DokterRecylerViewAdapter adapter = new DokterRecylerViewAdapter(this, dokterModels);
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

        // loop buat isi data ke model
        for (int i = 0; i < dokterNames.length; i++) {
            dokterModels.add(new DokterModel(dokterNames[i], "Dokter Gigi", rsNames[i], prices[i]));
        }
    }
}