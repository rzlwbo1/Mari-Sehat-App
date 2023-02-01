package com.example.marisehat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marisehat.helper.ReadOnClickInterface;
import com.example.marisehat.model.ListNewsModelRecyler;
import com.example.marisehat.R;

import java.util.ArrayList;

public class ListNewsAdapter extends RecyclerView.Adapter<ListNewsAdapter.NewsViewHolder> {

    private final ReadOnClickInterface readOnClickInterface;
    Context context;
    ArrayList<ListNewsModelRecyler> newsModelRecylers;

    public ListNewsAdapter(Context context, ArrayList<ListNewsModelRecyler> newsModelRecylers, ReadOnClickInterface readOnClickInterface) {
        this.context = context;
        this.newsModelRecylers = newsModelRecylers;
        this.readOnClickInterface = readOnClickInterface;
    }

    @NonNull
    @Override
    public ListNewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // disini proses memberitahu infalate layout mana yg akan di saambungkan

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.news_row, parent, false);

        return new NewsViewHolder(view, readOnClickInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ListNewsAdapter.NewsViewHolder holder, int position) {
        // disini proses memberikan value / assigne ke layout row nya
        // based on the position of recylcer view

        holder.newsTitle.setText(newsModelRecylers.get(position).getTitle());
        holder.newsSubs.setText(newsModelRecylers.get(position).getDesc());
        holder.newsAuthor.setText(newsModelRecylers.get(position).getAuthor());


    }

    @Override
    public int getItemCount() {
        return newsModelRecylers.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        // disini akan get id dari row layoutnya
        // disini seperti oncreate method

        TextView newsTitle, newsSubs, newsAuthor;
        Button btnRead;

        public NewsViewHolder(@NonNull View itemView, ReadOnClickInterface readOnClickInterface) {
            super(itemView);

            newsTitle = itemView.findViewById(R.id.titleNews);
            newsSubs = itemView.findViewById(R.id.descNews);
            newsAuthor = itemView.findViewById(R.id.authorNews);

            btnRead = itemView.findViewById(R.id.btnRead);
            btnRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (readOnClickInterface != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            readOnClickInterface.onClickBtnArtickle(pos);
                        }
                    }
                }
            });

        }
    }
}
