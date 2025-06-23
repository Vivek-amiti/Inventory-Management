package com.project.inventory_management.service;

import com.project.inventory_management.entity.Product;
import com.project.inventory_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Optional<Product> findById(Long id) {
        return repo.findById(id);
    }

    public List<Product> findByVendorId(Long vendorId) {
        return repo.findByVendorId(vendorId);
    }

    public Product save(Product product) {
        return repo.save(product);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}

