package com.gcu.dongdong2.club;

public class Club {
    private String name;
    private String explain;
    private String category;
    private int logoResId;

    public Club(String name, String explain, String category, int logoResId) {
        this.name = name;
        this.explain = explain;
        this.category = category;
        this.logoResId = logoResId;
    }

    public String getName() {
        return name;
    }

    public String getExplain(){return explain;};

    public String getCategory() {
        return category;
    }

    public int getLogoResId() {
        return logoResId;
    }
}