package com.example.LearningJava.service;

import com.example.LearningJava.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductEntity createProduct (ProductEntity product);

    List<ProductEntity> findAllProducts();
}
