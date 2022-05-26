package com.blog.controller;


import com.blog.model.Blog;
import com.blog.service.BlogService;
import com.blog.service.implement.BlogServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {

    private final BlogServiceImpl blogServiceImpl;

    public BlogController(BlogServiceImpl blogServiceImpl) {
        this.blogServiceImpl = blogServiceImpl;
    }


    @GetMapping("/home")
    public String home(Model model) {
        Iterable<Blog> blogs = blogServiceImpl.getBlogs();;
        model.addAttribute("blogs", blogs);
        return "home";
    }

    @PostMapping("/add-blog")
    public void addBlog(Model model) {

    }
}
