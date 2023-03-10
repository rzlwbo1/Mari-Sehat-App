package com.example.marisehat.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marisehat.helper.DBHelper;
import com.example.marisehat.KaloriFood;
import com.example.marisehat.ListBooking;
import com.example.marisehat.ListNewsApi;
import com.example.marisehat.R;
import com.example.marisehat.Spesialis;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class HomeFrag extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public HomeFrag() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment HomeFrag.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static HomeFrag newInstance(String param1, String param2) {
//        HomeFrag fragment = new HomeFrag();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    View view;
    CardView cardBookDok, cardNutrisi, cardArtikel;
    Button btnView;

    DBHelper DB;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DB = new DBHelper(getContext());

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        // current date
        LocalDateTime curDate = LocalDateTime.now();

        // format
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        // add to view
        TextView tanggal = (TextView) view.findViewById(R.id.date);
        String formatedDate = dateFormat.format(curDate);
        tanggal.setText(formatedDate);


        cardBookDok = view.findViewById(R.id.cardBook);
        cardBookDok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toBookDok = new Intent(getContext(), Spesialis.class);
                startActivity(toBookDok);
            }
        });


        cardNutrisi = view.findViewById(R.id.cardNutrisi);
        cardNutrisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toKalori = new Intent(getContext(), KaloriFood.class);
                startActivity(toKalori);
            }
        });

        cardArtikel = view.findViewById(R.id.cardArtikel);
        cardArtikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toArtikel = new Intent(getContext(), ListNewsApi.class);
                startActivity(toArtikel);
            }
        });


        btnView = view.findViewById(R.id.btnView);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor pasienCursor = DB.getPasien();
                if (pasienCursor.getCount() == 0) {
                    Toast.makeText(getContext(), "Belum ada Booking", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent toListBook = new Intent(getContext(), ListBooking.class);
                startActivity(toListBook);

            }
        });


        return view;
    }
}