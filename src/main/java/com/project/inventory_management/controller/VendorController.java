package com.project.inventory_management.controller;

import com.project.inventory_management.entity.Vendor;
import com.project.inventory_management.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping
    public Vendor create(@RequestBody Vendor vendor) {
        return vendorService.save(vendor);
    }

    @GetMapping
    public List<Vendor> getAll() {
        return vendorService.findAll();
    }

    @GetMapping("/{id}")
    public Vendor get(@PathVariable Long id) {
        return vendorService.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vendorService.deleteById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
@PutMapping("/approve/{id}")
public Vendor approveVendor(@PathVariable Long id) {
    return vendorService.approveVendor(id);
}

@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/pending")
public List<Vendor> getPendingVendors() {
    return vendorService.getPendingVendors();
}

}

