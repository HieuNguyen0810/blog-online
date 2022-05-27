package com.blog.service.implement;

import com.blog.model.Blog;
import com.blog.model.User;
import com.blog.repository.BlogRepository;
import com.blog.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


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

    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    public List<Blog> getByUser(User user) {
        return blogRepository.findByUser(user);
    }

    public Optional<Blog> getById(Integer blogId) {
        return blogRepository.findById(blogId);
    }

    public Date getDateTime() {
        return new java.util.Date();
    }

    public void deleteByBlogId(int blogId) {
        blogRepository.deleteById(blogId);
    }
}
