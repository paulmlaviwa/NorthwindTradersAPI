package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.pluralsight.NorthwindTradersAPI.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping
    public List<Category> getAllCategories() {
        return categoryDao.getAll();
    }
}
