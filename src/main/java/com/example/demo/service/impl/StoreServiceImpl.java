package com.example.demo.service.impl;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    
    @Autowired
    private StoreRepository storeRepository;
    
    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
    
    @Override
    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }
}