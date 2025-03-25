package com.example.LearningJava.entity;

import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;

@Data
public class ProductEntity {
    private Long id;
    private String name;
    private BigDecimal price;
}
