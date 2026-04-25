package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.entity.StoreInventory;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StoreInventoryRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private StoreInventoryRepository storeInventoryRepository;
    
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    
    @Override
    public StoreInventory getStoreInventoryForProduct(Long productId, Long storeId) {
        return storeInventoryRepository.findByProductIdAndStoreId(productId, storeId);
    }
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}