package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class CategoriesController {

    private final List<Category> categories = Arrays.asList(

    );

    @RequestMapping("/categories")
    public List<Category> getAllCategories(
            @RequestParam(required = false) String name) {

        // Filters based on user input
        List<Category> filteredCategories = categories;

        if (name != null) {
            filteredCategories = filteredCategories.stream()
                    .filter(category -> category.getCategoryName().contains(name))
                    .collect(Collectors.toList());
        }

        return filteredCategories;
    }
}
