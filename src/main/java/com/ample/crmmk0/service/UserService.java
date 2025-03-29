// src/main/java/com/ample/crmmk0/service/UserService.java
package com.ample.crmmk0.service;

import com.ample.crmmk0.entity.User;
import com.ample.crmmk0.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 增：创建用户
    public User createUser(String username, String password, String role) {
        User user = new User(username, password, role);
        return userRepository.save(user);
    }

    // 删：根据 ID 删除用户
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // 查：根据 ID 查询用户
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    // 查：查询所有用户
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 改：更新用户信息
    public User updateUser(Long id, String username, String password, String role) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(role);
            return userRepository.save(user);
        }
        return null;
    }
}