package com.techmart.service.impl;

import com.techmart.domain.Cart;
import com.techmart.domain.CartItem;
import com.techmart.domain.Product;
import com.techmart.domain.User;
import com.techmart.repository.ProductRepository;
import com.techmart.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    private static final String SESSION_CART_KEY = "SESSION_CART";

    private final ProductRepository productRepository;

    public CartServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private Cart getOrCreateCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute(SESSION_CART_KEY);
        if (cart == null) {
            cart = new Cart(); // anonymous cart, no user
            session.setAttribute(SESSION_CART_KEY, cart);
        }
        return cart;
    }

    @Override
    public int addToCart(Long productId, int quantity, HttpSession session) {
        if (quantity <= 0) quantity = 1;
        Cart cart = getOrCreateCart(session);
        Optional<Product> optProduct = productRepository.findById(productId);
        if (optProduct.isEmpty()) {
            throw new IllegalArgumentException("Product not found: " + productId);
        }
        Product product = optProduct.get();
        // check stock
        if (product.getStock() < quantity) {
            throw new IllegalArgumentException("Insufficient stock for product " + productId);
        }
        // find existing CartItem
        CartItem existing = null;
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getId().equals(productId)) {
                existing = item;
                break;
            }
        }
        if (existing != null) {
            int newQty = existing.getQuantity() + quantity;
            if (product.getStock() < newQty) {
                throw new IllegalArgumentException("Insufficient stock for product " + productId);
            }
            existing.setQuantity(newQty);
        } else {
            CartItem newItem = new CartItem(product, quantity);
            cart.addItem(newItem);
        }
        // update session attribute (cart is mutable, but ensure stored)
        session.setAttribute(SESSION_CART_KEY, cart);
        return getCartCount(session);
    }

    @Override
    public List<CartItem> getCartItems(HttpSession session) {
        Cart cart = getOrCreateCart(session);
        return cart.getItems();
    }

    @Override
    public int getCartCount(HttpSession session) {
        Cart cart = getOrCreateCart(session);
        return cart.getItems().stream().mapToInt(CartItem::getQuantity).sum();
    }
}
