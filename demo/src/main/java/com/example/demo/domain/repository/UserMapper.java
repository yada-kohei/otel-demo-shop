package com.example.demo.domain.repository;

import java.util.List;

import com.example.demo.domain.model.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  public boolean insert(User user);

  public User selectOne(String userId);

  public List<User> selectMany();

  public boolean updateOne(User user);

  public boolean deleteOne(String userId);

  public int count();
}
