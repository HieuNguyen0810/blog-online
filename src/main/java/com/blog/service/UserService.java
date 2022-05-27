package com.blog.service;

import com.blog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService extends Service {
    List<User> getAllUsers();

    Optional<User> getByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    void save(User user);

    Optional<User> findById(Integer userId);
}
