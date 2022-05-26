package com.blog.repository;

import com.blog.model.Blog;
import com.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
