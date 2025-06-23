package com.project.inventory_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Vendor extends User {

    @NotBlank
    private String companyName;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    private List<Order> orders;

    @Column(nullable = false)
    private boolean approved = false;


    public Vendor() {
    }

    
    public Vendor(String createdBy, @NotBlank String username, @NotBlank String password, @NotBlank String role,
            @NotBlank @Email String email, @NotBlank String companyName) {
        super(createdBy, username, password, role, email);
        this.companyName = companyName;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
 
}

