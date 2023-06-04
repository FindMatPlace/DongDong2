package com.gcu.dongdong2.test.dto;

public class BoardItemDto {
    private int idx;
    private int profileImage;
    private String name;
    private String content;
    private int contentImage;

    public BoardItemDto(int profileImage, String name, String content, int contentImage) {
        this.profileImage = profileImage;
        this.name = name;
        this.content = content;
        this.contentImage = contentImage;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getContentImage() {
        return contentImage;
    }

    public void setContentImage(int contentImage) {
        this.contentImage = contentImage;
    }
}
