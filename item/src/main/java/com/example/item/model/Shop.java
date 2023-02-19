package com.example.item.model;

import java.util.Date;

public class Shop {
  private int id;
  private int itemId;
  private String userId;
  private int unit;
  private Date createdAt;

  public Shop() {}

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public int getItemId() {
    return itemId;
  }
  public void setItemId(int itemId) {
    this.itemId = itemId;
  }
  public String getUserId() {
    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }
  public int getUnit() {
    return unit;
  }
  public void setUnit(int unit) {
    this.unit = unit;
  }
  public Date getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}
