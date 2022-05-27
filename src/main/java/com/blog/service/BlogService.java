package com.blog.service;

import com.blog.model.Blog;
import com.blog.model.User;
import com.blog.repository.BlogRepository;
import org.hibernate.service.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface BlogService extends Service {
    Iterable<Blog> getBlogs();

    Iterable<Blog> getBlogsByUserID(Integer id);

    void save(Blog blog);

    List<Blog> getByUser(User user);

    void deleteByBlogId(int blogId);
}
