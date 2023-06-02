package com.gcu.dongdong2.test.dto;

public class GroupCreateDto {
    private String name;
    private String category;
    private String imgLink;

    public GroupCreateDto(String name, String category, String imgLink) {
        this.name = name;
        this.category = category;
        this.imgLink = imgLink;
    }
}
