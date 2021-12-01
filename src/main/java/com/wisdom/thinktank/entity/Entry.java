package com.wisdom.thinktank.entity;


import java.text.SimpleDateFormat;

public class Entry {

  private long entryid;
  private String title;
  private String describe;
  private java.sql.Timestamp date;
  private java.sql.Timestamp createdate;
  private long heat;
  private String image;
  private String text;


  public long getEntryid() {
    return entryid;
  }

  public void setEntryid(long entryid) {
    this.entryid = entryid;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getDescribe() {
    return describe;
  }

  public void setDescribe(String describ) {
    this.describe = describ;
  }


  public String getDate() {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }


  public String getCreatedate() {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createdate);
  }

  public void setCreatedate(java.sql.Timestamp createdate) {
    this.createdate = createdate;
  }


  public long getHeat() {
    return heat;
  }

  public void setHeat(long heat) {
    this.heat = heat;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

}
