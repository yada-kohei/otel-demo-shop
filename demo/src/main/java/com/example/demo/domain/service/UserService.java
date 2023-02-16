package com.example.demo.domain.service;

import java.util.List;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {

  @Autowired
  UserMapper userMapper;

  @Autowired
  PasswordEncoder passwordEncoder;

  public boolean insert(User user) throws DataAccessException {

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    return userMapper.insert(user);
  }

  public User selectOne(String userId) throws DataAccessException {
    return userMapper.selectOne(userId);
  }

  public List<User> selectMany() throws DataAccessException {
    return userMapper.selectMany();
  }

  public boolean updateOne(User user) throws DataAccessException {

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    return userMapper.updateOne(user);
  }

  public boolean deleteOne(String userId) throws DataAccessException {
    return userMapper.deleteOne(userId);
  }

  public int count() throws DataAccessException {
    return userMapper.count();
  }
}
