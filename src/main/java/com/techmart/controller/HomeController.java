package com.techmart.controller;

import com.techmart.domain.Category;
import com.techmart.domain.Product;
import com.techmart.domain.Store;
import com.techmart.domain.StoreInventory;
import com.techmart.repository.CategoryRepository;
import com.techmart.repository.ProductRepository;
import com.techmart.repository.StoreInventoryRepository;
import com.techmart.repository.StoreRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @ModelAttribute("stores")
    public List<Store> stores() {
        return storeRepo.findAll();
    }

    @ModelAttribute("selectedStoreId")
    public Long selectedStoreId(HttpSession session) {
        Object attr = session.getAttribute("selectedStoreId");
        return attr instanceof Long ? (Long) attr : null;
    }

    @PostMapping("/store/select")
    public String selectStore(@RequestParam Long storeId, HttpSession session) {
        session.setAttribute("selectedStoreId", storeId);
        return "redirect:" + (session.getAttribute("referer") != null ? session.getAttribute("referer") : "/");
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("featuredProducts", productRepo.findAll().stream().limit(8).toList());
        model.addAttribute("deals", productRepo.findAll().stream()
                .filter(p -> p.getPrice().doubleValue() < 500).limit(4).toList());
        return "index";
    }

    @GetMapping("/category/{id}")
    public String category(@PathVariable Long id, Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("category", categoryRepo.findById(id).orElse(null));
        model.addAttribute("products", productRepo.findByCategoryId(id));
        return "category";
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable Long id, Model model, HttpSession session) {
        Product product = productRepo.findById(id).orElse(null);
        model.addAttribute("product", product);
        Long storeId = (Long) session.getAttribute("selectedStoreId");
        if (product != null && storeId != null) {
            Optional<Store> storeOpt = storeRepo.findById(storeId);
            if (storeOpt.isPresent()) {
                Optional<StoreInventory> inv = inventoryRepo.findByProductAndStore(product, storeOpt.get());
                if (inv.isPresent() && inv.get().getQuantity() > 0) {
                    model.addAttribute("stockMessage", "In Stock at " + storeOpt.get().getName());
                } else {
                    model.addAttribute("stockMessage", "Ship This Item");
                }
            }
        } else {
            model.addAttribute("stockMessage", "Ship This Item");
        }
        return "product";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String q, Model model) {
        model.addAttribute("query", q);
        model.addAttribute("products", q.isBlank() ? List.of() : productRepo.findByNameContainingIgnoreCase(q));
        model.addAttribute("categories", categoryRepo.findAll());
        return "search";
    }
}
