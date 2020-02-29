package com.springbootdemo.domain;

import java.util.List;
import com.springbootdemo.dto.ProjectDto;
import com.springbootdemo.dto.UserDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProjectDomain {

  @Getter
  @Setter
  private List<ProjectDto> projectList;

  @Getter
  @Setter
  private List<UserDto> userList;

}
