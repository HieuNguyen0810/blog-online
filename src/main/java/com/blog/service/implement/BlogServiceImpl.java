package com.blog.service.implement;

import com.blog.model.Blog;
import com.blog.repository.BlogRepository;
import com.blog.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    public Iterable<Blog> getBlogs() {
        return blogRepository.findAll();
    }

//    @Override
//    public Iterable<Blog> getBlogByUsername(String username) {
//        return blogRepository.findByUsername(username);
//    }

    public List<Blog> getBlogsByUserID(Integer id) {
        return blogRepository.findByUserId(id);
    }


}
