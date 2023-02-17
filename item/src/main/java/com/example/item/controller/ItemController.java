package com.example.item.controller;

import java.util.List;

// import com.example.item.model.SignupForm;
import com.example.item.model.Item;
import com.example.item.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

  @Autowired
  ItemService service;

  @GetMapping("/item")
  public List<Item> getItemMany() {
    return service.selectMany();
  }

  @GetMapping("/item/{id:.+}")
  public Item getItemOne(@PathVariable("id") int itemId){
    return service.selectOne(itemId);
  }

  @PostMapping("/item")
  public String postItemOne(@RequestBody Item item){
    boolean result = service.insert(item);

    String str = "";

    if(result == true) {
      str = "{\"result\":\"ok\"}";
    } else {
      str = "{\"result\":\"error\"}";
    }

    return str;
  }

  @PutMapping("/item")
  public String putItemOne(@RequestBody Item item) {
    boolean result = service.updateOne(item);

    String str = "";

    if(result == true) {
      str = "{\"result\":\"ok\"}";
    } else {
      str = "{\"result\":\"error\"}";
    }

    return str;
  }

  @DeleteMapping("/item/{id:.+}")
  public String deleteItemOne(@PathVariable("id") int itemId) {
    boolean result = service.deleteOne(itemId);

    String str = "";

    if(result == true) {
      str = "{\"result\":\"ok\"}";
    } else {
      str = "{\"result\":\"error\"}";
    }

    return str;
  }
}
