package com.example.demo.repository;

import com.example.demo.entity.StoreInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreInventoryRepository extends JpaRepository<StoreInventory, Long> {
    
    @Query("SELECT si FROM StoreInventory si WHERE si.product.id = :productId AND si.store.id = :storeId")
    StoreInventory findByProductIdAndStoreId(@Param("productId") Long productId, @Param("storeId") Long storeId);
}