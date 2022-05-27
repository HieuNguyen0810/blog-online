package com.blog.repository;

import com.blog.model.Blog;
import com.blog.model.Comment;
import com.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByBlog(Blog blog);
}
