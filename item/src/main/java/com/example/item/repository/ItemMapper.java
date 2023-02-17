package com.example.item.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.item.model.Item;

@Mapper
public interface ItemMapper {

  public boolean insert(Item item);

  public Item selectOne(int itemId);

  public List<Item> selectMany();

  public boolean updateOne(Item item);

  public boolean deleteOne(int itemId);

  public int count();
}
