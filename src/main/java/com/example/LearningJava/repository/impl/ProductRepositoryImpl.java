package com.example.LearningJava.repository.impl;

import com.example.LearningJava.entity.ProductEntity;
import com.example.LearningJava.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public ProductEntity createProduct(ProductEntity product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setName("Product 1");
        productEntity.setPrice(new BigDecimal("21.6"));

        return productEntity;
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(2L);
        productEntity.setName("Product 2");
        productEntity.setPrice(new BigDecimal("21.6"));
        return List.of(productEntity);
    }
}
