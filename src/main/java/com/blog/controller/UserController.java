package com.blog.controller;

import com.blog.model.User;
import com.blog.service.implement.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/get-all-user")
    public String viewUsers(Model model) {
        List<User> users = userServiceImpl.getAllUsers();
        return "view_users";
    }

//    @PutMapping("/edit-user")
//    public

//    @GetMapping("/get-user-{id}")
//    public String
}
