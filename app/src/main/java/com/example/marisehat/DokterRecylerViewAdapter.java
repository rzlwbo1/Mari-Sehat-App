package com.example.marisehat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class DokterRecylerViewAdapter extends RecyclerView.Adapter<DokterRecylerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<DokterModel> dokterModels;

    public DokterRecylerViewAdapter(Context context, ArrayList<DokterModel> dokterModels) {
        this.context = context;
        this.dokterModels = dokterModels;
    }

    @NonNull
    @Override
    public DokterRecylerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // disini proses memberitahu infalate layout mana yg akan di saambungkan

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dokter_row, parent, false);

        return new DokterRecylerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DokterRecylerViewAdapter.MyViewHolder holder, int position) {
        // disini proses memberikan value / assigne ke layout row nya
        // based on the position of recylcer view

        holder.dokterName.setText(dokterModels.get(position).getDokterName());
        holder.dokterSp.setText(dokterModels.get(position).getDokterSp());
        holder.rsName.setText(dokterModels.get(position).getRsName());
        holder.price.setText(dokterModels.get(position).getPriceBooking());

    }

    @Override
    public int getItemCount() {
        // disini recyler nya mau tau brapa sih row yg mau di tampilin
        return dokterModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // disini akan get id dari row layoutnya
        // disini seperti oncreate method

        TextView dokterName, dokterSp, rsName, price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            dokterName = itemView.findViewById(R.id.dokter_name);
            dokterSp = itemView.findViewById(R.id.spesialisasi);
            rsName = itemView.findViewById(R.id.rs_name);
            price = itemView.findViewById(R.id.price);

        }


    }
}
