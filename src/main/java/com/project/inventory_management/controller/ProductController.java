package com.project.inventory_management.controller;

import com.project.inventory_management.entity.Product;
import com.project.inventory_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id).orElse(null);
    }

    @GetMapping("/vendor/{vendorId}")
    public List<Product> getByVendor(@PathVariable Long vendorId) {
        return productService.findByVendorId(vendorId);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteById(id);
    }
}

