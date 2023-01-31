package com.example.marisehat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import com.example.marisehat.retrofit.ListNewsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListNewsApi extends AppCompatActivity {

    private NewsApiService newsApiService;

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


            }

            @Override
            public void onFailure(Call<ListNewsModel> call, Throwable t) {

            }
        });

    }
}