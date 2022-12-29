package com.example.marisehat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DetailDokter extends AppCompatActivity {

    TextView tvdokName, tvspesialis, tvexperience;
    TextView tvrsName, tvprice, tvdistantce;
    RadioButton rbdate1, rbdate2;
    RadioGroup rgdates;
    TextView tvtime1, tvtime2, tvdesc;
    Button btnBookDok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dokter);

        String nameDok = getIntent().getStringExtra("DOKTOR_NAME");
        String spesialis = getIntent().getStringExtra("SPESIALIS");
        String experience = getIntent().getStringExtra("EXPERIENCE");
        String rsName = getIntent().getStringExtra("RS_NAME");
        String distance = getIntent().getStringExtra("DISTANCE");
        String price = getIntent().getStringExtra("PRICE");
        String date_1 = getIntent().getStringExtra("DATE1");
        String date_2 = getIntent().getStringExtra("DATE2");
        String time = getIntent().getStringExtra("TIME");
        String desc = getIntent().getStringExtra("DESC");

        tvdokName = findViewById(R.id.dokter_name_detail);
        tvspesialis = findViewById(R.id.spesialisasi2);
        tvexperience = findViewById(R.id.experience);
        tvrsName = findViewById(R.id.rs_name2);
        tvprice = findViewById(R.id.price2);
        tvdistantce = findViewById(R.id.distance);
        rbdate1 = findViewById(R.id.rbDate1);
        rbdate2 = findViewById(R.id.rbDate2);
        rgdates = (RadioGroup) findViewById(R.id.rgDates);
        tvtime1 = findViewById(R.id.tvTime1);
        tvtime2 = findViewById(R.id.tvTime2);
        tvdesc = findViewById(R.id.desc);

        btnBookDok = findViewById(R.id.btnBookDok);

        tvdokName.setText(nameDok);
        tvspesialis.setText(spesialis);
        tvexperience.setText(experience);
        tvrsName.setText(rsName);
        tvdistantce.setText(distance);
        tvprice.setText(price);
        rbdate1.setText(date_1);
        rbdate2.setText(date_2);
        tvtime1.setText(time);
        tvtime2.setText(time);
        tvdesc.setText(desc);


        btnBookDok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnBookDok.isEnabled()) {
                    Intent toForm = new Intent(getApplicationContext(), FormPasien.class);

                    toForm.putExtra("DOKTOR_NAME", nameDok);
                    toForm.putExtra("SPESIALIS", spesialis);
                    toForm.putExtra("RS_NAME", rsName);
                    toForm.putExtra("PRICE", price);
                    toForm.putExtra("DATE1",date_1);
                    toForm.putExtra("DATE2", date_2);
                    toForm.putExtra("TIME", time);

                    startActivity(toForm);
                }
            }
        });


    }

    public void onRbDateChecked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbDate1:
                if (checked) {
                    btnBookDok.setEnabled(true);
                }
                break;
            case R.id.rbDate2:
                if (checked) {
                    btnBookDok.setEnabled(true);
                }
                break;
        }
    }
}