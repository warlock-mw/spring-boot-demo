package com.springbootdemo.dto;

import java.io.Serializable;
import com.springbootdemo.entity.ProjectEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProjectDto implements Serializable {
  private static final long serialVersionUID = 1L;

  @Getter
  @Setter
  private int id;

  @Getter
  @Setter
  private String name;

  public static ProjectDto valueOf(ProjectEntity entity) {
    var dto = new ProjectDto();
    dto.setId(entity.getId());
    dto.setName(entity.getName());

    return dto;
  }
}
