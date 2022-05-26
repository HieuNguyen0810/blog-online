package com.blog.service;

import com.blog.model.Blog;
import com.blog.repository.BlogRepository;
import org.hibernate.service.Service;
import org.springframework.web.bind.annotation.RequestParam;


public interface BlogService extends Service {
    Iterable<Blog> getBlogs();

    Iterable<Blog> getBlogByUsername(String username);
}
