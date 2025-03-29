package com.ample.crmmk0.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String identity;
    private String address;
    private String company;
    private String contact;
    private String avatar_key;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Purchase> purchaseHistory = new ArrayList<>();

    // 默认构造函数
    public Customer() {}

    // 带参构造函数
    public Customer(String name, int age, String identity, String address, String company, String contact, String avatar_key) {
        this.name = name;
        this.age = age;
        this.identity = identity;
        this.address = address;
        this.company = company;
        this.contact = contact;
        this.avatar_key = avatar_key;
    }

    // Getters 和 Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getIdentity() { return identity; }
    public void setIdentity(String identity) { this.identity = identity; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public List<Purchase> getPurchaseHistory() { return purchaseHistory; }
    public void setPurchaseHistory(List<Purchase> purchaseHistory) { this.purchaseHistory = purchaseHistory; }

    public String getAvatar_key() {
        return avatar_key;
    }

    public void setAvatar_key(String avatar_key) {
        //这里的avatar曾经被写作 avartar 是这个原因导致返回值错误吗
        this.avatar_key = avatar_key;
    }
}