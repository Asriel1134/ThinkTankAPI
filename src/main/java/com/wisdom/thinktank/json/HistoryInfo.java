package com.wisdom.thinktank.json;

import com.alibaba.fastjson.annotation.JSONField;

public class HistoryInfo {
    @JSONField(name = "ID")
    private int id;
    @JSONField(name = "title")
    private String title;
    @JSONField(name = "describe")
    private String describe;
    @JSONField(name = "imageUrl")
    private String url;

    public HistoryInfo(int id, String title, String describe, String url){
        this.id = id;
        this.title = title;
        this.describe = describe;
        this.url = url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getDescribe() {
        return describe;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
