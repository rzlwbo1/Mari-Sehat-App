package com.example.marisehat.model;

public class ListNewsModelRecyler {

    private String title;
    private  String desc;
    private String url;
    private String author;

    public ListNewsModelRecyler(String title, String desc, String url, String author) {
        this.title = title;
        this.desc = desc;
        this.url = url;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }

    public String getAuthor() {
        return author;
    }
}
