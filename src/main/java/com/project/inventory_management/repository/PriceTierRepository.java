package com.project.inventory_management.repository;

import com.project.inventory_management.entity.PriceTier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceTierRepository extends JpaRepository<PriceTier, Long> {
    List<PriceTier> findByProductId(Long productId);
}
