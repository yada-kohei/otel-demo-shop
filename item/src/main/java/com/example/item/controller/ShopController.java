package com.example.item.controller;

import java.util.List;

import com.example.item.model.Shop;
import com.example.item.model.ShopDetail;
import com.example.item.service.ShopService;
import com.example.item.service.ShopDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopController {

  @Autowired
  ShopService service;

  @Autowired
  ShopDetailService shopDetailService;

  @GetMapping("/shop")
  public List<Shop> getShopMany() {
    return service.selectMany();
  }

  @GetMapping("/shop/{id:.+}")
  public Shop getShopOne(@PathVariable("id") int id){
    return service.selectOne(id);
  }

  @PostMapping("/shop")
  public boolean postShopOne(@RequestBody Shop shop){
    boolean result = service.insert(shop);

    return result;
  }

  @PutMapping("/shop")
  public boolean putShopOne(@RequestBody Shop shop) {
    boolean result = service.updateOne(shop);
    return result;
  }

  @DeleteMapping("/shop/{id:.+}")
  public boolean deleteShopOne(@PathVariable("id") int id) {
    boolean result = service.deleteOne(id);
    return result;
  }

  @DeleteMapping("/shop/user/{id:.+}")
  public boolean deleteShopbyUserId(@PathVariable("id") String userId) {
    boolean result = service.deleteByUserId(userId);
    return result;
  }

  @GetMapping("/shopDetail")
  public List<ShopDetail> getShopDetailMany() {
    return shopDetailService.selectMany();
  }

  @GetMapping("/shopDetail/{id:.+}")
  public List<ShopDetail> getShopDetailByUserId(@PathVariable("id") String userId){
    return shopDetailService.selectByUserId(userId);
  }
}
