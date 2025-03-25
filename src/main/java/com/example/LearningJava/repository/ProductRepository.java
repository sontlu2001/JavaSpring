package com.example.LearningJava.repository;

import com.example.LearningJava.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    ProductEntity createProduct (ProductEntity product);

    List<ProductEntity> findAllProducts();
}
