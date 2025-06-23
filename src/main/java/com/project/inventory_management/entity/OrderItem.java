package com.project.inventory_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @NotNull
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;

    @Min(1)
    private int quantity;

    @DecimalMin("0.0")
    private double price;

    

    public OrderItem() {
    }

    

    public OrderItem(@NotNull Order order, @NotNull Product product, @Min(1) int quantity,
            @DecimalMin("0.0") double price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    


}

