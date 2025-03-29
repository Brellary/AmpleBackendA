// src/main/java/com/ample/crmmk0/repository/UserRepository.java
package com.ample.crmmk0.repository;

import com.ample.crmmk0.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}