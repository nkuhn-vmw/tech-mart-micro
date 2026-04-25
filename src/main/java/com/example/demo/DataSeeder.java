package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {
    
    @Autowired
    private StoreRepository storeRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private StoreInventoryRepository storeInventoryRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Create sample stores
        Store store1 = new Store("Downtown Store", "New York", "NY");
        Store store2 = new Store("Westside Store", "Los Angeles", "CA");
        Store store3 = new Store("North Plaza", "Chicago", "IL");
        
        storeRepository.saveAll(Arrays.asList(store1, store2, store3));
        
        // Create sample products
        Product product1 = new Product(
            "Gaming Laptop",
            "High-performance gaming laptop with RTX graphics",
            1299.99,
            25,
            "https://placehold.co/400x400?text=Gaming+Laptop"
        );
        
        Product product2 = new Product(
            "Wireless Mouse",
            "Ergonomic wireless mouse with precision tracking",
            49.99,
            50,
            "https://placehold.co/400x400?text=Wireless+Mouse"
        );
        
        Product product3 = new Product(
            "Mechanical Keyboard",
            "Full-size mechanical keyboard with RGB lighting",
            129.99,
            15,
            "https://placehold.co/400x400?text=Mechanical+Keyboard"
        );
        
        productRepository.saveAll(Arrays.asList(product1, product2, product3));
        
        // Create store inventory entries
        StoreInventory inventory1 = new StoreInventory(store1, product1, 10, "IN_STOCK");
        StoreInventory inventory2 = new StoreInventory(store2, product1, 5, "LOW_STOCK");
        StoreInventory inventory3 = new StoreInventory(store3, product2, 30, "IN_STOCK");
        StoreInventory inventory4 = new StoreInventory(store1, product3, 0, "OUT_OF_STOCK");
        
        storeInventoryRepository.saveAll(Arrays.asList(inventory1, inventory2, inventory3, inventory4));
    }
}