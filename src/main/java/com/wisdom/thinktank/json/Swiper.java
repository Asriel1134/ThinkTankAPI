package com.wisdom.thinktank.json;

import com.alibaba.fastjson.annotation.JSONField;

public class Swiper {
    @JSONField(name = "ID")
    private int id;
    @JSONField(name = "title")
    private String title;
    @JSONField(name = "author")
    private String author;
    @JSONField(name = "avatar")
    private String avatar;
    @JSONField(name = "mainColor")
    private String color;
    @JSONField(name = "imageUrl")
    private String url;

    public Swiper(int id, String title, String author,String avatar, String color, String url){
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.avatar = avatar;
        this.color = color;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }
}
