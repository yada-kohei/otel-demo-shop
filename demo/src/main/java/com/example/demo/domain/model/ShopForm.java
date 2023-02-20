package com.example.demo.domain.model;

import javax.validation.constraints.NotBlank;

public class ShopForm {

  @NotBlank(groups = ValidGroup1.class)
  private int itemId;

  @NotBlank(groups = ValidGroup1.class)
  private String itemName;

  private String description;

  @NotBlank(groups = ValidGroup1.class)
  private int price;

  @NotBlank(groups = ValidGroup1.class)
  private int unit;

  public ShopForm() {
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getUnit() {
    return unit;
  }

  public void setUnit(int unit) {
    this.unit = unit;
  }

}