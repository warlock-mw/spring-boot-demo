package com.springbootdemo.dto;

import java.io.Serializable;
import com.springbootdemo.entity.UserEntity;
import lombok.Data;

@Data
public class UserDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;

  private String name;

  private String email;

  public static UserDto valueOf(UserEntity entity) {
    var dto = new UserDto();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setEmail(entity.getEmail());

    return dto;
  }
}
