package com.project.inventory_management.repository;

import com.project.inventory_management.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId);

    @Query("""
    SELECT oi.product.id, oi.product.name, SUM(oi.quantity) AS totalSold
    FROM OrderItem oi
    GROUP BY oi.product.id, oi.product.name
    ORDER BY totalSold DESC
    """)
    List<Object[]> findTopSellingProducts();

}

