package com.example.marisehat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class ListNewsApi extends AppCompatActivity {

    List<ListNewsModel> newsModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news_api);
    }


    private void getNewsApi() {



    }
}