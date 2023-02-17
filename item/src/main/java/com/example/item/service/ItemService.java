
package com.example.item.service;

import java.util.List;

import com.example.item.model.Item;
import com.example.item.repository.ItemMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ItemService {

  @Autowired
  ItemMapper itemMapper;

  public boolean insert(Item item) throws DataAccessException {
    return itemMapper.insert(item);
  }

  public Item selectOne(int itemId) throws DataAccessException {
    return itemMapper.selectOne(itemId);
  }

  public List<Item> selectMany() throws DataAccessException {
    return itemMapper.selectMany();
  }

  public boolean updateOne(Item item) throws DataAccessException {
    return itemMapper.updateOne(item);
  }

  public boolean deleteOne(int itemId) throws DataAccessException {
    return itemMapper.deleteOne(itemId);
  }

  public int count() throws DataAccessException {
    return itemMapper.count();
  }
}
