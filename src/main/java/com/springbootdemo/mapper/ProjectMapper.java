package com.springbootdemo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.springbootdemo.entity.ProjectEntity;

@Mapper
public interface ProjectMapper {
  List<ProjectEntity> getAll();

  ProjectEntity get(int id);

  boolean insert(ProjectEntity ProjectEntity);

  boolean update(ProjectEntity ProjectEntity);

  boolean delte(int id);
}
