// src/main/java/com/ample/crmmk0/repository/CustomerRepository.java
package com.ample.crmmk0.repository;

import com.ample.crmmk0.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}