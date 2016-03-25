package service;

import crowdfunding.Project;
import dao.ProjectDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectDAO projectDAO;

    public List<Project> selectAll() {
        return projectDAO.selectAll();
    }

    public Project findById(int id){
       return projectDAO.findById(id);
    }

}
