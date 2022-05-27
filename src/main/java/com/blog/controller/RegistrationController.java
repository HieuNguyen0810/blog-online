package com.blog.controller;

import com.blog.model.User;
import com.blog.service.UserService;
import com.blog.service.implement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public RegistrationController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        System.out.println("App cccc!");

        model.addAttribute("user", new User());
        return "/registration";
    }

    @PostMapping ("/registration")
    public String createNewUser(@Valid User user,
                                BindingResult bindingResult,
                                Model model) {

        if (userServiceImpl.findByEmail(user.getEmail()).isPresent()) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
            System.out.println('1');
        }
        if (userServiceImpl.findByUsername(user.getUsername()).isPresent()) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
            System.out.println("2");
        }

        if (!bindingResult.hasErrors()) {
            System.out.println("3");
            // Registration successful, save user
            // Set user role to USER and set it as active
            userServiceImpl.save(user);
            System.out.println(user);

            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", new User());
        }
        else
            System.out.println(bindingResult.getAllErrors());

        return "/home";
    }
}
