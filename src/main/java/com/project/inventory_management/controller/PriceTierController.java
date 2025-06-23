package com.project.inventory_management.controller;

import com.project.inventory_management.entity.PriceTier;
import com.project.inventory_management.service.PriceTierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/price-tiers")
public class PriceTierController {

    @Autowired
    private PriceTierService priceTierService;

    @PostMapping
    public PriceTier create(@RequestBody PriceTier priceTier) {
        return priceTierService.save(priceTier);
    }

    @GetMapping("/{id}")
    public PriceTier getById(@PathVariable Long id) {
        return priceTierService.findById(id).orElse(null);
    }

    @GetMapping
    public List<PriceTier> getAll() {
        return priceTierService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        priceTierService.deleteById(id);
    }
}
