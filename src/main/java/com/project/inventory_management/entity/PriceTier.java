package com.project.inventory_management.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class PriceTier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int minQuantity;

    private BigDecimal price;

    @ManyToOne
    private Product product;

    
    public PriceTier(int minQuantity, BigDecimal price, Product product) {
        this.minQuantity = minQuantity;
        this.price = price;
        this.product = product;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
}

