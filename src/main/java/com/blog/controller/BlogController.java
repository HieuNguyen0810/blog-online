package com.blog.controller;


import com.blog.model.Blog;
import com.blog.model.Comment;
import com.blog.model.User;
import com.blog.service.implement.BlogServiceImpl;
import com.blog.service.implement.CommentServiceImpl;
import com.blog.service.implement.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
public class BlogController {

    private final BlogServiceImpl blogServiceImpl;
    private final UserServiceImpl userServiceImpl;
    private final CommentServiceImpl commentServiceImpl;
//    private final UserServiceImpl userServiceImpl;

    public BlogController(BlogServiceImpl blogServiceImpl, UserServiceImpl userServiceImpl, CommentServiceImpl commentServiceImpl) {
        this.blogServiceImpl = blogServiceImpl;
        this.userServiceImpl = userServiceImpl;
        this.commentServiceImpl = commentServiceImpl;
    }


    @GetMapping("/home")
    public String home(Model model) {
        Iterable<Blog> blogs = blogServiceImpl.getBlogs();;
        model.addAttribute("blogs", blogs);
        return "home";
    }

    @GetMapping("/view-blog/{blogId}")
    public String viewBlogWithId(@PathVariable Integer blogId, Model model, Principal principal) {
        Optional<Blog> optionalBlog = blogServiceImpl.getById(blogId);
        if (optionalBlog.isPresent()) {

            Blog blog = optionalBlog.get();

            // sua khi co sercurity
            Optional<User> optionalUser = userServiceImpl.getByUsername(principal.getName());
            if (optionalUser.isPresent()) {

                User user = optionalUser.get();

                List<Comment> comments = commentServiceImpl.getByBlog(blog);

                Comment comment = new Comment();
                comment.setBlog(blog);
                comment.setUser(user);
                model.addAttribute("comment", comment);

                model.addAttribute("blog", blog);
                model.addAttribute("comments", comments);

                return "view-blog";
            }
            else
                return "error";
        }
        else {
            return "error";
        }
    }

    @PostMapping("/view-blog/{blogId}")
    public String saveComment(@PathVariable int blogId, Comment comment) {
        commentServiceImpl.save(comment);
        return "redirect:/view-blog/{blogId}";
    }


    @GetMapping("/create-blog")
    public String showCreateBlogForm(@PathVariable Integer userId, Model model, Principal principal) {
        Optional<User> optionalUser = userServiceImpl.getByUsername(principal.getName());
//        User user = new User(1, "FN", "ln", "username", "12345", 1, "hieu@gmail.com", "0916764424", true, null, null, null, null);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Date createdTime = blogServiceImpl.getDateTime();
            model.addAttribute("blog", new Blog(null, null, null, null, null, null, createdTime, user, null, null, null));


            return "create_blog";
        }
        else
            return "error";
    }

//    @GetMapping("/create-blog")
//    public String showCreateBlogForm(Model model) {
////        Optional<User> user = userServiceImpl.getByUserId(userId);
//        User user = new User(1, "FN", "ln", "username", "12345", 1, "hieu@gmail.com", "0916764424", 1, null, null, null, null);
//        model.addAttribute("blog", new Blog(1, null, null, null, null, null, null, 1, null, null, null));
////        model.addAttribute("blog", new Blog());
////        if (user.isPresent())
////            model.addAttribute("user", user);
//
//        return "create_blog";
//    }

    @PostMapping("/create-blog")
    public String addBlog(Blog blog, Model model) {
        blog.setId(1);

        blogServiceImpl.save(blog);
        return "redirect:/blog/{username}";
    }

    @GetMapping("/edit-blog/{blogId}")
    public String editBlog(@PathVariable int blogId, Model model, Principal principal) {
        Optional<User> optionalUser = userServiceImpl.getByUsername(principal.getName());
//        User user = new User(1, "FN", "ln", "username", "12345", 1, "hieu@gmail.com", "0916764424", true, null, null, null, null);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Optional<Blog> optionalBlog = blogServiceImpl.getById(blogId);
            if (optionalBlog.isPresent()) {
                Blog blog = optionalBlog.get();
                model.addAttribute("blog", blog);

                return "create_blog";
            }
            else
                return "error";
        }
        else
            return "error";
    }

    @PostMapping("/edit-blog/{blogId}")
    public String updatedBlog(Blog blog) {
        blogServiceImpl.save(blog);
        return "redirect:/home";
    }

    
}
