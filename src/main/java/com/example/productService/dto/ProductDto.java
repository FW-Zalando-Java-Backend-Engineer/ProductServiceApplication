package com.example.productService.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private double price;

    private boolean inStock; // populated via inventory-service
}
