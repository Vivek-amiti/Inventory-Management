package com.project.inventory_management.service;

import com.project.inventory_management.entity.Vendor;
import com.project.inventory_management.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    
    @Autowired
    private final VendorRepository repo;

    public VendorService(VendorRepository repo) {
        this.repo = repo;
    }

    public List<Vendor> findAll() {
        return repo.findAll();
    }

    public Optional<Vendor> findById(Long id) {
        return repo.findById(id);
    }

    public Vendor save(Vendor vendor) {
        return repo.save(vendor);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Vendor approveVendor(Long vendorId) {
        Vendor vendor = repo.findById(vendorId)
            .orElseThrow(() -> new RuntimeException("Vendor not found"));
        vendor.setApproved(true);
        return repo.save(vendor);
    }

    public List<Vendor> getPendingVendors() {
        return repo.findByApprovedFalse();
    }

}

