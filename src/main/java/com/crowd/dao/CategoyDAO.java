package com.crowd.dao;


import com.crowd.entity.Category;

import java.util.List;

public interface CategoyDAO {
    void insert(Category category);

    List<Category> selectAll();

    Category findById(int id);

    void delete(Category category);

    void update(Category category);
}
