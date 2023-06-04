package com.gcu.dongdong2.mainpage.dto;

public class PostDto {
    private int idx;
    private String title;
    private String writer;
    private String contents;

    public PostDto(int idx, String title, String writer, String contents) {
        this.idx = idx;
        this.title = title;
        this.writer = writer;
        this.contents = contents;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
