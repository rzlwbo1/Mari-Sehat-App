package com.example.marisehat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;

import com.example.marisehat.adapter.ListNewsAdapter;
import com.example.marisehat.model.ListNewsModelRecyler;
import com.example.marisehat.retrofit.ListNewsModel;
import com.example.marisehat.retrofit.NewsApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListNewsApi extends AppCompatActivity {

    private NewsApiService newsApiService;
    ArrayList<ListNewsModelRecyler> newsModelRecyler = new ArrayList<>();
    RecyclerView newsRecylerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news_api);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        newsApiService = retrofit.create(NewsApiService.class);

        // get recylerview container
        newsRecylerview = findViewById(R.id.newsRecyler);

        getNewsApi("9be866acf7874f90b3a6d60f9a02a564", "id", "health", 10, "sehat");


    }


    private void getNewsApi(String key, String country, String category, Integer pageSize, String query) {

        Call<ListNewsModel> call = newsApiService.getHeadlineNewsHealth(key, country, category, pageSize, query);

        call.enqueue(new Callback<ListNewsModel>() {
            @Override
            public void onResponse(Call<ListNewsModel> call, Response<ListNewsModel> response) {

                if (!response.isSuccessful()) {
                    System.out.println(response.code());
                    return;
                }

                // loop data ke model baru untuk display data ke adapter
                for (int i = 0; i < response.body().getArticles().size(); i++) {
                    newsModelRecyler.add(new ListNewsModelRecyler(response.body().getArticles().get(i).getTitle(),
                            response.body().getArticles().get(i).getDescription(),
                            response.body().getArticles().get(i).getUrl(),
                            response.body().getArticles().get(i).getAuthor()));
                }

                if (newsModelRecyler.size() == 10) {
                    ListNewsAdapter adapterNews = new ListNewsAdapter(getApplicationContext(), newsModelRecyler);
                    newsRecylerview.setAdapter(adapterNews);
                    newsRecylerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }


            }

            @Override
            public void onFailure(Call<ListNewsModel> call, Throwable t) {

            }
        });

    }
}