package com.example.demo.domain.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.model.Item;

@Transactional
@Service
public class ItemService {

  @Autowired
  RestTemplate restTemplate;

  private String url = "http://item:8082/api/item";

  public List<Item> getItems() throws DataAccessException {
    return Arrays.asList(restTemplate.getForObject(url, Item[].class));
  }

  public Item getItembyId(int itemId) throws DataAccessException {
    return restTemplate.getForObject(url + "/{id}", Item.class, itemId);
  }

  public boolean createItem(Item item) throws DataAccessException {
    return restTemplate.postForObject(url, item, boolean.class);
  }

  public boolean updateItem(Item item) throws DataAccessException {
    restTemplate.put(url, item);
    return true;
  }

  public boolean deleteItem(int itemId) throws DataAccessException {
    restTemplate.delete(url + "/{id}", boolean.class, itemId);
    int count = Arrays.asList(restTemplate.getForObject(url + "/{id}", Item.class, itemId)).size();
    if (count == 0) {
      return true;
    } else {
      return false;
    }
  }

  public int countItem() throws DataAccessException {
    return Arrays.asList(restTemplate.getForObject(url, Item[].class)).size();
  }
}
