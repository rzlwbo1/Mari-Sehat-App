package com.example.marisehat.retrofit;

import com.example.marisehat.retrofit.ListNewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiService {

    @GET("top-headlines?country=id&apiKey=9be866acf7874f90b3a6d60f9a02a564")
    Call<ListNewsModel> getHeadlineNewsHealth(@Query("key") String key,
                                              @Query("country") String country,
                                              @Query("category") String category,
                                              @Query("pageSize") Integer pageSize,
                                              @Query("q") String query);

}
