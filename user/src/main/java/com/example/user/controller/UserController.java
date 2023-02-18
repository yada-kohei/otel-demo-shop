package com.example.user.controller;

import java.util.List;

// import com.example.user.model.SignupForm;
import com.example.user.model.User;
import com.example.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

  @Autowired
  UserService service;

  @GetMapping("/user")
  public List<User> getUserMany() {
    return service.selectMany();
  }

  @GetMapping("/user/{id:.+}")
  public User getUserOne(@PathVariable("id") String userId){
    return service.selectOne(userId);
  }

  @PostMapping("/user")
  public boolean postUserOne(@RequestBody User user){
    boolean result = service.insert(user);
    return result;
    // JSONを返す場合
    //String str = "";
    // if(result == true) {
    //   str = "{\"result\":\"ok\"}";
    // } else {
    //   str = "{\"result\":\"error\"}";
    // }

    // return str;
  }

  @PutMapping("/user")
  public boolean putUserOne(@RequestBody User user) {
    boolean result = service.updateOne(user);
    return result;
  }

  @DeleteMapping("/user/{id:.+}")
  public boolean deleteUserOne(@PathVariable("id") String userId) {
    boolean result = service.deleteOne(userId);
    return result;
  }
}
