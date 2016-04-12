package com.crowd.service;

import com.crowd.bean.category.SimpleCategoryBean;
import com.crowd.dao.CategoyDAO;
import com.crowd.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public ResponseEntity<List<SimpleCategoryBean>> getAllCategories(){
        List<SimpleCategoryBean> categories = categoyDAO.selectAll()
                .stream().map(SimpleCategoryBean::new)
                .collect(Collectors.toList());

        return new ResponseEntity<List<SimpleCategoryBean>>(categories, HttpStatus.OK);
    }
}
