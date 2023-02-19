
package com.example.item.service;

import java.util.List;

import com.example.item.model.ShopDetail;
import com.example.item.repository.ShopDetailMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ShopDetailService {

  @Autowired
  ShopDetailMapper shopDetailMapper;

  public List<ShopDetail> selectMany() throws DataAccessException {
    return shopDetailMapper.selectMany();
  }

  public List<ShopDetail> selectByUserId(String userId) throws DataAccessException {
    return shopDetailMapper.selectByUserId(userId);
  }

}
