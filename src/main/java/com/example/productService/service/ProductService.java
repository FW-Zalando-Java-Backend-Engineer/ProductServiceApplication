package com.example.productService.service;

import com.example.productService.dto.ProductDto;
import com.example.productService.mapper.ProductMapper;
import com.example.productService.model.Product;
import com.example.productService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;
    private final InventoryClient inventoryClient;

    public Product addProduct(Product product){
        return repo.save(product);
    }

    public List<ProductDto> getAllProducts(){
        return repo.findAll().stream()
                .map(
                        product -> {
                            boolean inStock = inventoryClient.isInStock(product.getId());
                            return ProductMapper.toDto(product, inStock);
                        }
                )
                .collect(Collectors.toList());
    }

}
