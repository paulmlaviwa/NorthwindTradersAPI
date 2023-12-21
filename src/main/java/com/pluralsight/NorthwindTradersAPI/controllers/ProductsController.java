package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pluralsight.NorthwindTradersAPI.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductDao productDao;

    @Autowired
    public ProductsController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @RequestMapping
    public List<Product> getAllProducts(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) Integer categoryId,
                                        @RequestParam(required = false) Double maxPrice) {
        return productDao.getAll();
    }
}
