
package com.example.item.service;

import java.util.List;

import com.example.item.model.Shop;
import com.example.item.repository.ShopMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ShopService {

  @Autowired
  ShopMapper shopMapper;

  public boolean insert(Shop shop) throws DataAccessException {
    return shopMapper.insert(shop);
  }

  public Shop selectOne(int id) throws DataAccessException {
    return shopMapper.selectOne(id);
  }

  public List<Shop> selectMany() throws DataAccessException {
    return shopMapper.selectMany();
  }

  public List<Shop> selectByUserId(String userId) throws DataAccessException {
    return shopMapper.selectByUserId(userId);
  }

  public boolean updateOne(Shop shop) throws DataAccessException {
    return shopMapper.updateOne(shop);
  }

  public boolean deleteOne(int id) throws DataAccessException {
    return shopMapper.deleteOne(id);
  }

  public boolean deleteByUserId(String userId) throws DataAccessException {
    return shopMapper.deleteByUserId(userId);
  }

  public int count() throws DataAccessException {
    return shopMapper.count();
  }
}
