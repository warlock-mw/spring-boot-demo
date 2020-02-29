package com.springbootdemo.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springbootdemo.entity.UserEntity;
import com.springbootdemo.mapper.UserMapper;

@Repository
public class UserRepository {
  @Autowired
  private UserMapper mapper;

  public List<UserEntity> getAll() {
    return mapper.getAll();
  }

  public UserEntity get(int id) {
    return mapper.get(id);
  }

  public boolean insert(UserEntity userEntity) {
    return mapper.insert(userEntity);
  }

  public boolean update(UserEntity userEntity) {
    return mapper.update(userEntity);
  }

  public boolean delete(int id) {
    return mapper.delte(id);
  }
}
