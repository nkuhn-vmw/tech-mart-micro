package com.techmart.controller;

import com.techmart.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    @ResponseBody
    public String addToCart(@RequestParam Long productId, @RequestParam(defaultValue = "1") int quantity) {
        cartService.addToCart(productId, quantity);
        // Return the updated cart item count for HTMX replacement
        return String.valueOf(cartService.getItemCount());
    }

    @RequestMapping("/view")
    public String viewCart(Model model) {
        model.addAttribute("items", cartService.getItems());
        return "cart";
    }
}
