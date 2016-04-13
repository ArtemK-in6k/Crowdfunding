package com.crowd.controller.api;

import com.crowd.bean.category.SimpleCategoryBean;
import com.crowd.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryApiController {

    @Autowired private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SimpleCategoryBean>> getCategories(){
        return categoryService.getAllCategories();
    }
}
