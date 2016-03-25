package dao;

import crowdfunding.Project;

import java.util.List;

public interface ProjectDAO {
    void insert(Project project);

    List<Project> selectAll();

    Project findById(int id);

    void delete(Project project);

    void update(Project project);

}
