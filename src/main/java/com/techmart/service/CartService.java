package com.techmart.service;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import com.techmart.domain.CartItem;

public interface CartService {
    /**
     * Add a product to the cart stored in the session.
     * @param productId ID of the product to add
     * @param quantity quantity to add (default 1)
     * @param session HttpSession where the cart is stored
     * @return total number of items in the cart after addition
     */
    int addToCart(Long productId, int quantity, HttpSession session);

    /**
     * Get all items currently in the cart.
     */
    List<CartItem> getCartItems(HttpSession session);

    /**
     * Get total item count in cart.
     */
    int getCartCount(HttpSession session);
}
