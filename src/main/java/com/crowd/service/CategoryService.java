package com.crowd.service;

import com.crowd.dao.CategoyDAO;
import com.crowd.entity.Category;
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
