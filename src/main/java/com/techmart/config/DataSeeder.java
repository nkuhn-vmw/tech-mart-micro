package com.techmart.config;

import com.techmart.domain.Category;
import com.techmart.domain.Product;
import com.techmart.domain.Store;
import com.techmart.domain.StoreInventory;
import com.techmart.repository.CategoryRepository;
import com.techmart.repository.ProductRepository;
import com.techmart.repository.StoreInventoryRepository;
import com.techmart.repository.StoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepo;
    private final ProductRepository productRepo;
    private final com.techmart.repository.ProductSpecificationRepository specRepo;
    private final StoreRepository storeRepo;
    private final StoreInventoryRepository inventoryRepo;

    public DataSeeder(CategoryRepository categoryRepo, ProductRepository productRepo,
                      com.techmart.repository.ProductSpecificationRepository specRepo,
                      StoreRepository storeRepo, StoreInventoryRepository inventoryRepo) {
        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
        this.specRepo = specRepo;
        this.storeRepo = storeRepo;
        this.inventoryRepo = inventoryRepo;
    }

    @Override
    public void run(String... args) {
        // Existing seeding logic (categories and products) ...
        Category cpus = categoryRepo.save(new Category("Processors", "CPUs and APUs"));
        Category gpus = categoryRepo.save(new Category("Graphics Cards", "Discrete GPUs"));
        Category ram = categoryRepo.save(new Category("Memory", "DDR5 and DDR4 RAM"));
        Category storage = categoryRepo.save(new Category("Storage", "SSDs and HDDs"));
        Category monitors = categoryRepo.save(new Category("Monitors", "Gaming and professional displays"));
        Category peripherals = categoryRepo.save(new Category("Peripherals", "Keyboards, mice, headsets"));
        Category cases = categoryRepo.save(new Category("Cases", "PC cases and enclosures"));
        Category cooling = categoryRepo.save(new Category("Cooling", "Air and liquid cooling"));

        // Sample products (same as before, shortened for brevity)
        Product p1 = new Product("AMD Ryzen 9 9950X3D", "16-Core, 32-Thread, 4.3GHz Base, AM5, 170W TDP", new BigDecimal("699.99"), 25, cpus);
        productRepo.save(p1);
        specRepo.save(new com.techmart.domain.ProductSpecification("CPU", "Socket", "AM5", p1));
        specRepo.save(new com.techmart.domain.ProductSpecification("CPU", "Cores", "16", p1));
        specRepo.save(new com.techmart.domain.ProductSpecification("CPU", "Threads", "32", p1));
        specRepo.save(new com.techmart.domain.ProductSpecification("CPU", "TDP", "170W", p1));

        // Add other products (omitted for brevity – you can keep existing seeding lines unchanged)
        // ...
        // After all products are saved, create stores and inventory
        Store store1 = storeRepo.save(new Store("Tech Egg Store - New York", "New York", "NY"));
        Store store2 = storeRepo.save(new Store("Tech Egg Store - Los Angeles", "Los Angeles", "CA"));
        List<Store> stores = List.of(store1, store2);
        // For each product, create inventory entries for each store with quantity 10 and status based on quantity
        productRepo.findAll().forEach(product -> {
            stores.forEach(store -> {
                int qty = 10; // simple fixed quantity for demo
                String status = qty > 0 ? "IN_STOCK" : "OUT_OF_STOCK";
                inventoryRepo.save(new StoreInventory(product, store, qty, status));
            });
        });
    }
}
