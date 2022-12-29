package com.example.marisehat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Succes extends AppCompatActivity {

    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes);

        btnHome = findViewById(R.id.btnToHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome2 = new Intent(getApplicationContext(), HomeSreen.class);
                startActivity(toHome2);
                finish();
            }
        });

    }
}