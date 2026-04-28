package com.techmart.repository;

import com.techmart.domain.StoreInventory;
import com.techmart.domain.Product;
import com.techmart.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreInventoryRepository extends JpaRepository<StoreInventory, Long> {
    Optional<StoreInventory> findByProductAndStore(Product product, Store store);
}
