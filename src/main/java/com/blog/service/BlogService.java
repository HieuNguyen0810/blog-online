package com.blog.service;

import com.blog.model.Blog;
import com.blog.repository.BlogRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface BlogService extends BlogRepository {
    static Iterable<Blog> findAllBlogs() {
        Iterable<Blog> blos = BlogRepository.findAllBlogs();
    }

    static Iterable<Blog> findAllBlogsByUsername(@RequestParam String username) {
        Iterable<Blog> blogs = BlogRepository.findAllBlogsByUsername(username);
        return blogs;
    }
}
