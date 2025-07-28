package com.example.productService.mapper;

import com.example.productService.dto.ProductDto;
import com.example.productService.model.Product;

public class ProductMapper {
    public static ProductDto toDto(Product product, boolean inStock) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setInStock(inStock);
        return dto;
    }
}
