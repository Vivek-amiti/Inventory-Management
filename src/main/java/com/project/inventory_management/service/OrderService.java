package com.project.inventory_management.service;

import com.project.inventory_management.entity.Order;
import com.project.inventory_management.entity.OrderItem;
import com.project.inventory_management.entity.OrderStatus;
import com.project.inventory_management.entity.Product;
import com.project.inventory_management.repository.OrderRepository;
import com.project.inventory_management.repository.ProductRepository;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


        @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Order placeOrder(Order order) {
        for (OrderItem item : order.getItems()) {
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found: " + item.getProduct().getId()));

            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }

            // Reduce stock
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);

            // Link OrderItem to Order and Product
            item.setOrder(order);
            item.setProduct(product);

            // Set item price (optional: based on price tiers)
            item.setPrice(0.0); // You can calculate this later from tiers
        }

        order.setStatus(OrderStatus.PENDING);
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> findByVendorId(Long vendorId) {
        return orderRepository.findByVendorId(vendorId);
    }

    public List<Order> findByClientId(Long clientId) {
        return orderRepository.findByClientId(clientId);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}

