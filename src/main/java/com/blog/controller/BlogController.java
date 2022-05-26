package com.blog.controller;


import com.blog.model.Blog;
import com.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }



    @GetMapping("/home")
    public String home(Model model) {
        Iterable<Blog> blogs = BlogService.findAllBlogs();
        model.addAllAttributes("blogs", blogs);
        return "home";
    }

    @PostMapping("/add-blog")
    public void addBlog(Model model) {

    }
}
