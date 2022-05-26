package com.blog.repository;

import com.blog.model.Comment;
import com.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
