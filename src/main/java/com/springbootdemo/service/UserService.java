package com.springbootdemo.service;

import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootdemo.domain.UserDomain;
import com.springbootdemo.dto.UserDto;
import com.springbootdemo.entity.UserEntity;
import com.springbootdemo.repository.UserRepository;
import com.springbootdemo.web.form.UserForm;

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

  public boolean create(UserForm userForm) {
    var entity = UserEntity.formToEntity(userForm);
    var result = repository.insert(entity);

    return result;
  }

  public UserForm initForm() {
    return new UserForm();
  }

  public UserForm makeForm(String id) {
    var entity = Optional.ofNullable(repository.get(Integer.parseInt(id)));

    if (!entity.isPresent()) {
      return null;
    }

    var form = UserForm.formToEntity(entity.get());

    return form;
  }

  public boolean update(UserForm userForm, String id) {
    var entity = UserEntity.formToEntity(userForm);
    entity.setId(Integer.parseInt(id));

    var result = repository.update(entity);

    return result;
  }
}
