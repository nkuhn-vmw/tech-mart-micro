package com.techmart.controller;

import com.techmart.domain.Category;
import com.techmart.domain.Product;
import com.techmart.repository.CategoryRepository;
import com.techmart.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;

    public HomeController(ProductRepository productRepo, CategoryRepository categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
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
    public String product(@PathVariable Long id, Model model) {
        model.addAttribute("product", productRepo.findById(id).orElse(null));
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
