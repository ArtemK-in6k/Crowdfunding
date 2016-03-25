package service;

import crowdfunding.Category;
import dao.CategoyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoyDAO categoyDAO;

    public List<Category> selectAll() {
        return categoyDAO.selectAll();
    }

    public Category findById(int id) {
        return categoyDAO.findById(id);
    }
}
