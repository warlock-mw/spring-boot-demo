package com.springbootdemo.dto;

import java.io.Serializable;
import com.springbootdemo.entity.ProjectEntity;
import lombok.Data;

@Data
public class ProjectDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;

  private String name;

  public static ProjectDto valueOf(ProjectEntity entity) {
    var dto = new ProjectDto();
    dto.setId(entity.getId());
    dto.setName(entity.getName());

    return dto;
  }
}
