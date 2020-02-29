package com.springbootdemo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Getter
  @Setter
  private int id;

  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private String email;

  @Getter
  @Setter
  private String password;
}
