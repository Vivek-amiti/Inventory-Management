package com.project.inventory_management.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    private int stock;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
    

    public Product(String name, BigDecimal price, int stock, Vendor vendor) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.vendor = vendor;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

}

