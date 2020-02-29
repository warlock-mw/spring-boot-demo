package com.springbootdemo.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springbootdemo.entity.ProjectEntity;
import com.springbootdemo.mapper.ProjectMapper;

@Repository
public class ProjectRepository {
  @Autowired
  private ProjectMapper mapper;

  public List<ProjectEntity> getAll() {
    return mapper.getAll();
  }

  public ProjectEntity get(int id) {
    return mapper.get(id);
  }

  public boolean insert(ProjectEntity projectEntity) {
    return mapper.insert(projectEntity);
  }

  public boolean update(ProjectEntity projectEntity) {
    return mapper.update(projectEntity);
  }

  public boolean delete(int id) {
    return mapper.delte(id);
  }
}
