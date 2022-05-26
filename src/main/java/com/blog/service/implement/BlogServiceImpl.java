package com.blog.service.implement;

import com.blog.model.Blog;
import com.blog.repository.BlogRepository;
import com.blog.service.BlogService;
import org.springframework.stereotype.Service;


@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    public Iterable<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    public Iterable<Blog> getBlogsByUsername(String username) {
        return blogRepository.findByUsername(username);
    }


}
