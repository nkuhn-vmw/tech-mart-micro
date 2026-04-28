package com.techmart.service;

import com.techmart.domain.CartItem;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private static final String CART_SESSION_KEY = "cart";

    private final HttpSession session;

    public CartService(HttpSession session) {
        this.session = session;
    }

    @SuppressWarnings("unchecked")
    private List<CartItem> getCart() {
        List<CartItem> cart = (List<CartItem>) session.getAttribute(CART_SESSION_KEY);
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute(CART_SESSION_KEY, cart);
        }
        return cart;
    }

    public void addToCart(Long productId, int quantity) {
        List<CartItem> cart = getCart();
        // Check if item already exists, increase quantity
        for (CartItem item : cart) {
            if (item.getProductId().equals(productId)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cart.add(new CartItem(productId, quantity));
    }

    public int getItemCount() {
        return getCart().size();
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(getCart());
    }
}
