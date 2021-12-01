package com.wisdom.thinktank.entity;


import java.text.SimpleDateFormat;

public class History {

  private long userid;
  private long entryid;
  private java.sql.Timestamp date;


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }


  public long getEntryid() {
    return entryid;
  }

  public void setEntryid(long entryid) {
    this.entryid = entryid;
  }


  public String getDate() {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }

}
