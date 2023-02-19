package com.example.item.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.item.model.ShopDetail;

@Mapper
public interface ShopDetailMapper {

  public List<ShopDetail> selectMany();

  public List<ShopDetail> selectByUserId(String userId);

}
