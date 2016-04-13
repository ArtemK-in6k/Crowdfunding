package com.crowd.bean.category;


import com.crowd.entity.Category;

public class SimpleCategoryBean {
    private int id;
    private String title;

    public SimpleCategoryBean(Category category){
        setId(category.getId());
        setTitle(category.getTitle());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
