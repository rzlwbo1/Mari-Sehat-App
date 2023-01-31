package com.example.marisehat.retrofit;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ListNewsModel{

	@SerializedName("totalResults")
	private int totalResults;

	@SerializedName("articles")
	private List<ArticlesItem> articles;

	@SerializedName("status")
	private String status;

	public ListNewsModel(int totalResults, List<ArticlesItem> articles, String status) {
		this.totalResults = totalResults;
		this.articles = articles;
		this.status = status;
	}

	public int getTotalResults(){
		return totalResults;
	}

	public List<ArticlesItem> getArticles(){
		return articles;
	}

	public String getStatus(){
		return status;
	}

}