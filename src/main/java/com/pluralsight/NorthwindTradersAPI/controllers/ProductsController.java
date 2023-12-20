package com.pluralsight.NorthwindTradersAPI.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductsController {

    @RequestMapping("/products")
    public List<Product> getAllProducts() {
        return Arrays.asList();
    }
}
