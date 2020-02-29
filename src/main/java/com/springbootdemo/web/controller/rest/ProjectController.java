package com.springbootdemo.web.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springbootdemo.domain.ProjectDomain;
import com.springbootdemo.service.ProjectService;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @GetMapping("/")
  public ProjectDomain index() {
    return projectService.getDomain();
  }
}
