package com.gcu.dongdong2.mainpage;

public class BoardItem {
    private int profileImage;
    private String name;
    private String content;
    private int contentImage;
    private int id;

    public BoardItem(int profileImage, String name, String content, int contentImage, int id) {
        this.profileImage = profileImage;
        this.name = name;
        this.content = content;
        this.contentImage = contentImage;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
