package com.example.LearningJava.service.impl;

import com.example.LearningJava.entity.ProductEntity;
import com.example.LearningJava.repository.ProductRepository;
import com.example.LearningJava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSeviceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.createProduct(product);
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        return productRepository.findAllProducts();
    }
}
