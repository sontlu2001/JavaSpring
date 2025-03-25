package com.example.LearningJava.controller;

import com.example.LearningJava.entity.ProductEntity;
import com.example.LearningJava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping()
    public ProductEntity createProduct(ProductEntity product){
        return productService.createProduct(product);
    }

    @GetMapping("")
    public List<ProductEntity> findAll(){
        return productService.findAllProducts();
    }
}
