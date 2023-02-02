package com.example.marisehat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.example.marisehat.adapter.ListBookingAdapter;
import com.example.marisehat.helper.DBHelper;
import com.example.marisehat.model.ListBookModel;

import java.util.ArrayList;

public class ListBooking extends AppCompatActivity {

    RecyclerView recyclerViewBooking;
    DBHelper DB;
    ArrayList<ListBookModel> listBookModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_booking);

        recyclerViewBooking = findViewById(R.id.listBookRecylerView);

        DB = new DBHelper(this);

        setListBookModels();

        // set adapter
        ListBookingAdapter bookingAdapter = new ListBookingAdapter(this, listBookModels);
        recyclerViewBooking.setAdapter(bookingAdapter);
        recyclerViewBooking.setLayoutManager(new LinearLayoutManager(this));


    }

    public void setListBookModels() {
        Cursor cursor = DB.getPasien();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Data masih kosong", Toast.LENGTH_SHORT).show();
        } else {

            while (cursor.moveToNext()) {
                listBookModels.add(new ListBookModel(cursor.getString(1), cursor.getString(2), cursor.getString(3).concat(" Tahun"),
                        cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7),
                        cursor.getString(8), cursor.getString(9), cursor.getString(10)));
            }

        }
    }

}







