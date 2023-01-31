package com.example.marisehat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marisehat.R;
import com.example.marisehat.model.ListBookModel;

import java.util.ArrayList;

public class ListBookingAdapter extends RecyclerView.Adapter<ListBookingAdapter.MyViewHolder> {

    Context context;
    ArrayList<ListBookModel> listBookModels;

    public ListBookingAdapter(Context context, ArrayList<ListBookModel> listBookModels) {
        this.context = context;
        this.listBookModels = listBookModels;
    }

    @NonNull
    @Override
    public ListBookingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // disini proses memberitahu infalate layout mana yg akan di saambungkan

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.booking_row, parent, false);

        return new ListBookingAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListBookingAdapter.MyViewHolder holder, int position) {
        // disini proses memberikan value / assign ke layout row nya
        // based on the position of recylcer view

        holder.tvPasien.setText(listBookModels.get(position).getNamaPasien());
        holder.tvJenkel.setText(listBookModels.get(position).getJenkel());
        holder.tvAge.setText(listBookModels.get(position).getUsia());
        holder.tvKeluhan.setText(listBookModels.get(position).getKeluhan());

        holder.tvDokter.setText(listBookModels.get(position).getNamaDok());
        holder.tvSpes.setText(listBookModels.get(position).getSpesialis());
        holder.tvRsName.setText(listBookModels.get(position).getNamaRS());
        holder.tvDate.setText(listBookModels.get(position).getTglBook());
        holder.tvTime.setText(listBookModels.get(position).getWaktu());
        holder.tvPrice.setText(listBookModels.get(position).getHarga());


    }

    @Override
    public int getItemCount() {
        return listBookModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // disini akan get id dari row layoutnya
        // disini seperti oncreate method

        TextView tvPasien, tvJenkel, tvAge, tvKeluhan;
        TextView tvDokter, tvSpes, tvRsName, tvDate, tvTime, tvPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPasien = itemView.findViewById(R.id.tvNamaPasList);
            tvJenkel = itemView.findViewById(R.id.tvGenderList);
            tvAge = itemView.findViewById(R.id.tvAgeList);
            tvKeluhan = itemView.findViewById(R.id.tvKeluhanList);

            tvDokter = itemView.findViewById(R.id.tvNamaDokList);
            tvSpes = itemView.findViewById(R.id.tvSepesialisList);
            tvRsName = itemView.findViewById(R.id.tvRSNameList);
            tvDate = itemView.findViewById(R.id.tvDateList);
            tvTime = itemView.findViewById(R.id.tvTimeList);
            tvPrice = itemView.findViewById(R.id.tvPriceList);


        }
    }
}
