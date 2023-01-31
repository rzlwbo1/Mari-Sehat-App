package com.example.marisehat;

public class ListNewsModel {

    private String title;
    private String desc;
    private String urlWeb;
    private String author;

    public ListNewsModel(String title, String desc, String urlWeb, String author) {
        this.title = title;
        this.desc = desc;
        this.urlWeb = urlWeb;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public String getAuthor() {
        return author;
    }
}
