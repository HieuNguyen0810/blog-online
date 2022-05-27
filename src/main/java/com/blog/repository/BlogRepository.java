package com.blog.repository;

import com.blog.model.Blog;
import com.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Override
    List<Blog> findAll();
//    Iterable<Blog> findByUsername(String username);

    List<Blog> findByUserId(Integer id);

    Blog save(Blog blog);

    List<Blog> findByUser(User user);
}
