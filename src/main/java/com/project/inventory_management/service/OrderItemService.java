package com.project.inventory_management.service;

import com.project.inventory_management.entity.OrderItem;
import com.project.inventory_management.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private final OrderItemRepository repo;

    public OrderItemService(OrderItemRepository repo) {
        this.repo = repo;
    }

    public List<OrderItem> findAll() {
        return repo.findAll();
    }

    public Optional<OrderItem> findById(Long id) {
        return repo.findById(id);
    }

    public List<OrderItem> findByOrderId(Long orderId) {
        return repo.findByOrderId(orderId);
    }

    public OrderItem save(OrderItem orderItem) {
        return repo.save(orderItem);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}

