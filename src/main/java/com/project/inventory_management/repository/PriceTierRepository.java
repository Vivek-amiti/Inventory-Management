package com.project.inventory_management.repository;

import com.project.inventory_management.entity.PriceTier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceTierRepository extends JpaRepository<PriceTier, Long> {
    List<PriceTier> findByProductId(Long productId);
}
