package com.techmart.controller;

import com.techmart.domain.Category;
import com.techmart.domain.Product;
import com.techmart.domain.Store;
import com.techmart.domain.StoreInventory;
import com.techmart.repository.CategoryRepository;
import com.techmart.repository.ProductRepository;
import com.techmart.repository.StoreRepository;
import com.techmart.repository.StoreInventoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;
    private final StoreRepository storeRepo;
    private final StoreInventoryRepository inventoryRepo;

    public HomeController(ProductRepository productRepo, CategoryRepository categoryRepo,
                          StoreRepository storeRepo, StoreInventoryRepository inventoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
        this.storeRepo = storeRepo;
        this.inventoryRepo = inventoryRepo;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("featuredProducts", productRepo.findAll().stream().limit(8).toList());
        model.addAttribute("deals", productRepo.findAll().stream()
                .filter(p -> p.getPrice().doubleValue() < 500).limit(4).toList());
        model.addAttribute("stores", storeRepo.findAll());
        return "index";
    }

    @GetMapping("/category/{id}")
    public String category(@PathVariable Long id, Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("category", categoryRepo.findById(id).orElse(null));
        model.addAttribute("products", productRepo.findByCategoryId(id));
        model.addAttribute("stores", storeRepo.findAll());
        return "category";
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable Long id,
                          @RequestParam(value = "storeId", required = false) Long storeId,
                          Model model) {
        Product product = productRepo.findById(id).orElse(null);
        model.addAttribute("product", product);
        List<Store> stores = storeRepo.findAll();
        model.addAttribute("stores", stores);
        Store selectedStore = null;
        if (storeId != null) {
            Optional<Store> opt = storeRepo.findById(storeId);
            selectedStore = opt.orElse(null);
        } else if (!stores.isEmpty()) {
            selectedStore = stores.get(0);
        }
        String inventoryStatus = "Ship This Item";
        if (product != null && selectedStore != null) {
            Optional<StoreInventory> invOpt = inventoryRepo.findByStoreIdAndProductId(selectedStore.getId(), product.getId());
            if (invOpt.isPresent() && invOpt.get().getQuantity() != null && invOpt.get().getQuantity() > 0) {
                inventoryStatus = "In Stock at " + selectedStore.getName();
            }
        }
        model.addAttribute("inventoryStatus", inventoryStatus);
        model.addAttribute("selectedStoreId", selectedStore != null ? selectedStore.getId() : null);
        return "product";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String q, Model model) {
        model.addAttribute("query", q);
        model.addAttribute("products", q.isBlank() ? List.of() : productRepo.findByNameContainingIgnoreCase(q));
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("stores", storeRepo.findAll());
        return "search";
    }
}
