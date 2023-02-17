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
  public String postUserOne(@RequestBody User user){
    boolean result = service.insert(user);

    String str = "";

    if(result == true) {
      str = "{\"result\":\"ok\"}";
    } else {
      str = "{\"result\":\"error\"}";
    }

    return str;
  }

  @PutMapping("/user")
  public String putUserOne(@RequestBody User user) {
    boolean result = service.updateOne(user);

    String str = "";

    if(result == true) {
      str = "{\"result\":\"ok\"}";
    } else {
      str = "{\"result\":\"error\"}";
    }

    return str;
  }

  @DeleteMapping("/user/{id:.+}")
  public String deleteUserOne(@PathVariable("id") String userId) {
    boolean result = service.deleteOne(userId);

    String str = "";

    if(result == true) {
      str = "{\"result\":\"ok\"}";
    } else {
      str = "{\"result\":\"error\"}";
    }

    return str;
  }
}
