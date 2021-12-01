package com.wisdom.thinktank.json;

import com.alibaba.fastjson.annotation.JSONField;
import com.wisdom.thinktank.entity.Entry;

public class HistoryCollection {
    @JSONField(name = "date")
    private String date;
    @JSONField(name = "entry")
    private Entry entry;

    public HistoryCollection(String date, Entry entry){
        this.date = date;
        this.entry = entry;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public Entry getEntry() {
        return entry;
    }
}
