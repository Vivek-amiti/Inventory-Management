package com.project.inventory_management.controller;

import com.project.inventory_management.entity.Order;
import com.project.inventory_management.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }


    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return orderService.findById(id).orElse(null);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.findAll();
    }

    @GetMapping("/client/{clientId}")
    public List<Order> getByClient(@PathVariable Long clientId) {
        return orderService.findByClientId(clientId);
    }

    @GetMapping("/vendor/{vendorId}")
    public List<Order> getByVendor(@PathVariable Long vendorId) {
        return orderService.findByVendorId(vendorId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.deleteById(id);
    }
}

