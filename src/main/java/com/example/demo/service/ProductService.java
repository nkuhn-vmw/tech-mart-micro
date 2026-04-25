package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.StoreInventory;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    StoreInventory getStoreInventoryForProduct(Long productId, Long storeId);
    List<Product> getAllProducts();
}