package com.project.inventory_management.service;

import com.project.inventory_management.entity.Product;
import com.project.inventory_management.repository.OrderItemRepository;
import com.project.inventory_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Map<String, Object>> getTopSellingProducts() {
        List<Object[]> raw = orderItemRepository.findTopSellingProducts();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] row : raw) {
            Map<String, Object> map = new HashMap<>();
            map.put("productId", row[0]);
            map.put("productName", row[1]);
            map.put("totalSold", row[2]);
            result.add(map);
        }

        return result;
    }

    public List<Product> getLowStockProducts(int threshold) {
        return productRepository.findLowStockProducts(threshold);
    }
}

