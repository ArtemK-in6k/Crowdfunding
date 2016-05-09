package com.crowd.dao;


import com.crowd.entity.Project;

import java.util.List;

public interface ProjectDAO {
    void insert(Project project);

    List<Project> selectAll();

    Project findById(int id);

    void delete(Project project);

    void update(Project project);

    Project findByProjectName(String name);

    List<Project> findByPartOfProjectName(String projectName);

    List<Project> findAllByCategory(int category);

}
