package com.springbootdemo.service;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootdemo.domain.ProjectDomain;
import com.springbootdemo.dto.ProjectDto;
import com.springbootdemo.dto.UserDto;
import com.springbootdemo.repository.ProjectRepository;
import com.springbootdemo.repository.UserRepository;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private UserRepository userRepository;

  public ProjectDomain getDomain() {
    var projectList = projectRepository.getAll().stream().map(e -> ProjectDto.valueOf(e))
        .collect(Collectors.toList());

    var userList =
        userRepository.getAll().stream().map(e -> UserDto.valueOf(e)).collect(Collectors.toList());

    var domain = new ProjectDomain();
    domain.setProjectList(projectList);
    domain.setUserList(userList);

    return domain;
  }
}
