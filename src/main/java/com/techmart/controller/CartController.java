package com.techmart.controller;

import com.techmart.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.techmart.domain.CartItem;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * Add a product to the cart stored in the HttpSession.
     * Returns an HTML fragment for the cart badge count (HTMX target).
     */
    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam("productId") Long productId,
                                            @RequestParam(value = "quantity", defaultValue = "1") int quantity,
                                            HttpSession session) {
        try {
            int count = cartService.addToCart(productId, quantity, session);
            // Return a simple span fragment that HTMX can replace the badge with
            String fragment = "<span id=\"cart-badge\" class=\"badge\">" + count + "</span>";
            return ResponseEntity.ok(fragment);
        } catch (Exception e) {
            // Return error response
            return ResponseEntity.status(500).body("<span id=\"cart-badge\" class=\"badge\">0</span>");
        }
    }

    /**
     * Get current cart item count.
     */
    @GetMapping("/count")
    public ResponseEntity<Integer> getCartCount(HttpSession session) {
        return ResponseEntity.ok(cartService.getCartCount(session));
    }

    /**
     * Get all items in the cart.
     */
    @GetMapping("/items")
    public ResponseEntity<List<CartItem>> getCartItems(HttpSession session) {
        return ResponseEntity.ok(cartService.getCartItems(session));
    }
}
