package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.entity.StoreInventory;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private StoreService storeService;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @GetMapping("/product/{id}")
    public String getProductDetail(@PathVariable Long id, 
                                   @RequestParam(required = false) Long storeId,
                                   Model model) {
        Product product = productService.getProductById(id);
        List<Store> stores = storeService.getAllStores();
        List<Category> categories = categoryRepository.findAll();
        
        if (product != null) {
            model.addAttribute("product", product);
            model.addAttribute("stores", stores);
            model.addAttribute("categories", categories);
            
            // Set default store ID if not provided
            Long selectedStoreId = storeId != null ? storeId : (stores.isEmpty() ? null : stores.get(0).getId());
            model.addAttribute("selectedStoreId", selectedStoreId);
            
            // Determine inventory status for the selected store
            String inventoryStatus = "Ship This Item";
            if (selectedStoreId != null) {
                StoreInventory inventory = productService.getStoreInventoryForProduct(product.getId(), selectedStoreId);
                if (inventory != null) {
                    if ("IN_STOCK".equals(inventory.getStatus())) {
                        inventoryStatus = "In Stock at " + inventory.getStore().getName();
                    } else if ("LOW_STOCK".equals(inventory.getStatus())) {
                        inventoryStatus = "Limited Stock at " + inventory.getStore().getName();
                    } else if ("OUT_OF_STOCK".equals(inventory.getStatus())) {
                        inventoryStatus = "Ship This Item";
                    }
                }
            }
            model.addAttribute("inventoryStatus", inventoryStatus);
        }
        
        return "product";
    }
}