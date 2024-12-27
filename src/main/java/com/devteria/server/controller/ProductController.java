package com.devteria.server.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PostMapping
    public void createProduct() {
        // Create a new product
    }

    @DeleteMapping
    public void deleteProduct(String id){
        // Delete a product
    }

    @GetMapping
    public Boolean updateProduct(String id){
        // Update a product
        return true;
    }
}