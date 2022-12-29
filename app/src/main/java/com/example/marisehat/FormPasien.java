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

public class FormPasien extends AppCompatActivity {

    Button btnLanjut;
    EditText nama, usia, keluhan;
    RadioGroup rgKel;
    RadioButton rbLaki, rbPerem;
    String kelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pasien);

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
                            Intent toSuccess = new Intent(getApplicationContext(), Succes.class);
                            startActivity(toSuccess);
                            finish();
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