package com.springbootdemo.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class ProjectEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;

  private String name;
}
