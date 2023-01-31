package com.example.marisehat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.marisehat.R;
import com.google.android.material.textfield.TextInputEditText;

public class BMIFrag extends Fragment {

    View view;
    TextInputEditText etTinggi, etBerat;
    Button btnHitung;
    TextView tvCatBMI, tvNumBMI;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_b_m_i, container, false);

        etTinggi = view.findViewById(R.id.etTinggi);
        etBerat = view.findViewById(R.id.etBerat);
        btnHitung = view.findViewById(R.id.btnHitung);

        etTinggi.addTextChangedListener(validationBMI);
        etBerat.addTextChangedListener(validationBMI);

        return view;
    }


    protected TextWatcher validationBMI = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String strTinggi = etTinggi.getText().toString();
            String strBerat = etBerat.getText().toString();

            if (strTinggi.length() > 0 && strBerat.length() > 0) {
                btnHitung.setEnabled(true);

                btnHitung.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View viewBtn) {
                        Double a = Double.valueOf(strTinggi);
                        Integer b = Integer.valueOf(strBerat);
                        Double tempA = a * a;
                        Double hasil = Math.floor( b / tempA );


                        tvCatBMI = view.findViewById(R.id.tvCategoryBMI);
                        tvNumBMI = view.findViewById(R.id.numBMI);

                        if (hasil < 18.5) {
                            tvCatBMI.setText("Underweight");
                            tvNumBMI.setText(String.valueOf(hasil));
                        } else if (hasil > 18.5 && hasil <= 24.9) {
                            tvCatBMI.setText("Normal");
                            tvNumBMI.setText(String.valueOf(hasil));
                        } else if (hasil >= 25  && hasil <= 29.9) {
                            tvCatBMI.setText("Overweight");
                            tvNumBMI.setText(String.valueOf(hasil));
                        } else {
                            tvCatBMI.setText("Obesitas");
                            tvNumBMI.setText(String.valueOf(hasil));
                        }
                    }
                });

            }




        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

}