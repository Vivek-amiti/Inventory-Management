package com.project.inventory_management.repository;

import com.project.inventory_management.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClientId(Long clientId);
    List<Order> findByVendorId(Long vendorId);
}

