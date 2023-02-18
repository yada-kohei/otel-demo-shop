package com.example.demo.domain.service;

import java.util.List;
import java.util.Arrays;

import com.example.demo.domain.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Transactional
@Service
public class UserService {

  @Autowired
  RestTemplate restTemplate;

  String url = "http://user:8081/api/user";

  public List<User> getUsers() throws DataAccessException {
    return Arrays.asList(restTemplate.getForObject(url, User[].class));
  }

  public User getUserbyId(String userId) throws DataAccessException {
    return restTemplate.getForObject(url + "/{id}", User.class, userId);
  }

  public boolean createUser(User user) throws DataAccessException {
    return restTemplate.postForObject(url, user, boolean.class);
  }

  public boolean updateUser(User user) throws DataAccessException {
    restTemplate.put(url, user);
    return true;
  }

  public boolean deleteUser(String userId) throws DataAccessException {
    restTemplate.delete(url + "/{id}", boolean.class, userId);
    int count = Arrays.asList(restTemplate.getForObject(url + "/{id}", User.class, userId)).size();
    if (count == 0) {
      return true;
    } else {
      return false;
    }
  }

  public int countUser() throws DataAccessException {
    return Arrays.asList(restTemplate.getForObject(url, User[].class)).size();
  }

}
