package com.example.productService.controller;


import com.example.productService.dto.ProductDto;
import com.example.productService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    @GetMapping
    public List<ProductDto> getAll() {
        return service.getAllProducts();
    }

}
