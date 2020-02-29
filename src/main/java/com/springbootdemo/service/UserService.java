package com.springbootdemo.service;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootdemo.domain.UserDomain;
import com.springbootdemo.dto.UserDto;
import com.springbootdemo.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public UserDomain getDomain() {
    var userList =
        repository.getAll().stream().map(e -> UserDto.valueOf(e)).collect(Collectors.toList());

    var domain = new UserDomain();
    domain.setUserList(userList);

    return domain;
  }
}