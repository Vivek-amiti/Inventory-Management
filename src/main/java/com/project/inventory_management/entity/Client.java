package com.project.inventory_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Client extends User {

    @NotBlank
    private String organizationName;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> orders;

    
    public Client() {
        super();
    }

    

    public Client(String createdBy, String username, String password, String role, String email,
            @NotBlank String organizationName) {
        super(createdBy, username, password, role, email);
        this.organizationName = organizationName;
    }



    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    
}


