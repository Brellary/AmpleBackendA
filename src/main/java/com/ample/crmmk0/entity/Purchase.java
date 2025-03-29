package com.ample.crmmk0.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private double amount;
    private String purchaseDate;
    private String productType;
    private String location;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore  // 阻止序列化 customer

    private Customer customer;

    public Purchase(Long id, String productName, double amount, String purchaseDate, String productType, String location, Customer customer) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.productType = productType;
        this.location = location;
        this.customer = customer;
    }

    // 默认构造函数
    public Purchase() {}


    // Getters 和 Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}