package com.example.moblieprogrammingtermproject;

public class Comment {
    private String name;
    private String comment;
    private int logoResId;

    public Comment(String name, String comment, int logoResId) {
        this.name = name;
        this.comment = comment;
        this.logoResId = logoResId;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public int getLogoResId() {
        return logoResId;
    }
}