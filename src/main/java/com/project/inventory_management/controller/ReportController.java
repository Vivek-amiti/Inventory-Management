package com.project.inventory_management.controller;

import com.project.inventory_management.entity.Product;
import com.project.inventory_management.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/top-selling")
    public List<Map<String, Object>> getTopSellingProducts() {
        return reportService.getTopSellingProducts();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/low-stock")
    public List<Product> getLowStock(@RequestParam(defaultValue = "10") int threshold) {
        return reportService.getLowStockProducts(threshold);
    }
}
