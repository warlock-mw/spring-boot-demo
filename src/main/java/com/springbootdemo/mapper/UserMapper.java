package com.springbootdemo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.springbootdemo.entity.UserEntity;

@Mapper
public interface UserMapper {
  List<UserEntity> getAll();

  UserEntity get(int id);

  boolean insert(UserEntity userEntity);

  boolean update(UserEntity userEntity);

  boolean delete(int id);
}
