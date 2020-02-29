package com.springbootdemo.entity;

import java.io.Serializable;
import com.springbootdemo.web.form.UserForm;
import lombok.Data;

@Data
public class UserEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;

  private String name;

  private String email;

  private String password;

  public static UserEntity formToEntity(UserForm form) {
    var entity = new UserEntity();
    entity.setName(form.getName());
    entity.setEmail(form.getEmail());
    entity.setPassword(form.getPassword());

    return entity;
  }
}
