package com.blog.service;

import com.blog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService extends Service {
    List<User> getAllUsers();

    Optional<User> getByUsername(String username);
}
