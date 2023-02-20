package com.example.demo.domain.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.domain.model.ShopDetail;

@Transactional
@Service
public class ShopService {

  @Autowired
  RestTemplate restTemplate;

  private String shopDetailURL = "http://item:8082/api/shopDetail/";

  public List<ShopDetail> getMyShopDetail() throws DataAccessException {
    String userId = SecurityContextHolder.getContext().getAuthentication().getName();
    return Arrays.asList(restTemplate.getForObject(shopDetailURL + userId, ShopDetail[].class));
  }

}
