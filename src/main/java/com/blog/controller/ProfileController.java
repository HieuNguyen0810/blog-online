package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.User;
import com.blog.service.implement.BlogServiceImpl;
import com.blog.service.implement.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class ProfileController {

    private final UserServiceImpl userServiceImpl;
    private final BlogServiceImpl blogServiceImpl;

    public ProfileController(UserServiceImpl userServiceImpl, BlogServiceImpl blogServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.blogServiceImpl = blogServiceImpl;
    }

    @GetMapping("/blog/{username}")
    public String blogForUsername(@PathVariable String username, Model model) {
        Optional<User> optionalUser = userServiceImpl.getByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            List<Blog> blogs = blogServiceImpl.getByUser(user);

            model.addAttribute("user", user);
            model.addAttribute("blogs", blogs);

            return "blogs";
        }
        else {
            return "home";
        }
    }
}
