package com.springbootdemo.domain;

import java.util.List;
import com.springbootdemo.dto.ProjectDto;
import com.springbootdemo.dto.UserDto;
import lombok.Data;

@Data
public class ProjectDomain {

  private List<ProjectDto> projectList;

  private List<UserDto> userList;

}
