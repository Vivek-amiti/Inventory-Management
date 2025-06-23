package com.project.inventory_management.service;

import com.project.inventory_management.entity.PriceTier;
import com.project.inventory_management.repository.PriceTierRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class PriceTierService {
    @Autowired
    private final PriceTierRepository repo;

    public PriceTierService(PriceTierRepository repo) {
        this.repo = repo;
    }

    public List<PriceTier> findAll() {
        return repo.findAll();
    }

    public Optional<PriceTier> findById(Long id) {
        return repo.findById(id);
    }

    public List<PriceTier> findByProductId(Long productId) {
        return repo.findByProductId(productId);
    }

    public PriceTier save(PriceTier tier) {
        return repo.save(tier);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}

