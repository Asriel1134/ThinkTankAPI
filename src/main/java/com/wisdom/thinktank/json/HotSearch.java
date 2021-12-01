package com.wisdom.thinktank.json;

import com.alibaba.fastjson.annotation.JSONField;

public class HotSearch {
    @JSONField(name = "ID")
    private int id;
    @JSONField(name = "title")
    private String title;
    @JSONField(name = "describe")
    private String describe;
    @JSONField(name = "heat")
    private int heat;

    public HotSearch(int id, String title, String describe, int heat){
        this.id = id;
        this.title = title;
        this.describe = describe;
        this.heat = heat;
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

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public int getHeat() {
        return heat;
    }
}
