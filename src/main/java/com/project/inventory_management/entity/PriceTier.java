package com.project.inventory_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class PriceTier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1)
    private int minQuantity;

    @DecimalMin("0.0")
    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;

    

    public PriceTier() {
    }

    

    public PriceTier(@Min(1) int minQuantity, @DecimalMin("0.0") double price, @NotNull Product product) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
}


