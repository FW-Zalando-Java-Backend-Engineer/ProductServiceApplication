package com.example.productService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class InventoryClient {

    private final RestTemplate restTemplate;

    @Value("${INVENTORY_SERVICE_URL}")
    private String inventoryUrl;

    public boolean isInStock(Long productId) {
        Boolean response = restTemplate.getForObject(inventoryUrl + productId, Boolean.class);
        return response != null && response;
    }

}
