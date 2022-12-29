package com.example.marisehat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FormPasien extends AppCompatActivity {

    Button btnLanjut;
    EditText nama, usia, keluhan;
    RadioGroup rgKel;
    RadioButton rbLaki, rbPerem;
    String kelamin;
    String tempnama, tempspesialis, temprs, temptgl1, temptgl2, temptime, tempharga;
    String temp;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pasien);

        DB = new DBHelper(this);

        nama = findViewById(R.id.etNama);
        usia = findViewById(R.id.etUsia);
        rgKel = findViewById(R.id.rgKelamin);
        rbLaki = findViewById(R.id.rbLaki);
        rbPerem = findViewById(R.id.rbPrem);
        keluhan = findViewById(R.id.etKeluhan);
        btnLanjut = findViewById(R.id.btnLanjut);

        nama.addTextChangedListener(validation);
        keluhan.addTextChangedListener(validation);
        usia.addTextChangedListener(validation);

        // data intent
        String nameDok = getIntent().getStringExtra("DOKTOR_NAME");
        String spesialis = getIntent().getStringExtra("SPESIALIS");
        String rsName = getIntent().getStringExtra("RS_NAME");
        String price = getIntent().getStringExtra("PRICE");
        String date_1 = getIntent().getStringExtra("DATE1");
        String date_2 = getIntent().getStringExtra("DATE2");
        String time = getIntent().getStringExtra("TIME");

        tempnama = nameDok;
        tempspesialis = spesialis;
        temprs = rsName;
        tempharga = price;
        temptgl1 = date_1;
        temptgl2 = date_2;
        temptime = time;


    }

    public TextWatcher validation = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String valnama = nama.getText().toString();
            String valusia = usia.getText().toString();
            String valkeluhan = keluhan.getText().toString();

            if (valnama.length() > 0 && valusia.length() > 0 && valkeluhan.length() > 0) {
                if (rbLaki.isChecked() || rbPerem.isChecked()) {
                    btnLanjut.setEnabled(true);

                    btnLanjut.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (rbLaki.isChecked()) {
                                kelamin = rbLaki.getText().toString();
                            } else if(rbPerem.isChecked()) {
                                kelamin = rbPerem.getText().toString();
                            }

                            if (temptgl1.length() > 0) {
                                 temp = temptgl1;
                                System.out.println(temp);
                            } else {
                                temp = temptgl2;
                                System.out.println(temp);
                            }

                            boolean insertData =DB.insertBookPasien(valnama, kelamin, valusia, valkeluhan, tempnama, temprs, tempspesialis, temp, temptime, tempharga);

                            if (insertData) {
                                Toast.makeText(FormPasien.this, "Booking Berhasil", Toast.LENGTH_LONG).show();

                                Intent toSuccess = new Intent(getApplicationContext(), Succes.class);
                                startActivity(toSuccess);
                                finish();
                            } else {
                                Toast.makeText(FormPasien.this, "Booking Gagal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            } else {
                btnLanjut.setEnabled(false);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}