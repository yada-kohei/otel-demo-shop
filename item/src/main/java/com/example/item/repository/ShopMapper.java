package com.example.item.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.item.model.Shop;

@Mapper
public interface ShopMapper {

  public boolean insert(Shop shop);

  public Shop selectOne(int id);

  public List<Shop> selectMany();

  public List<Shop> selectByUserId(String userId);

  public boolean updateOne(Shop shop);

  public boolean deleteOne(int id);

  public boolean deleteByUserId(String userId);

  public int count();
}
