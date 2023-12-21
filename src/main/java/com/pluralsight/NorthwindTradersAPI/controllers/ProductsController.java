package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductsController {

    private final List<Product> products = Arrays.asList(
            new Product(1, "Chicken Gizzard", 1, 2.59),
            new Product(2, "Tylenol", 2, 6.99)
    );

    @RequestMapping("/products")
    public List<Product> getAllProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Double maxPrice) {

        List<Product> filteredProducts = products;

        if (name != null) {
            filteredProducts = filteredProducts.stream()
                    .filter(product -> product.getProductName().contains(name))
                    .collect(Collectors.toList());
        }

        if (categoryId != null) {
            filteredProducts = filteredProducts.stream()
                    .filter(product -> product.getCategoryId() == categoryId)
                    .collect(Collectors.toList());
        }

        if (maxPrice != null) {
            filteredProducts = filteredProducts.stream()
                    .filter(product -> product.getUnitPrice() <= maxPrice)
                    .collect(Collectors.toList());
        }

        return filteredProducts;
    }
}
