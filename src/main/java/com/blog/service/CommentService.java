package com.blog.service;

import com.blog.model.Blog;
import com.blog.model.Comment;
import org.hibernate.service.Service;

import java.util.List;

public interface CommentService extends Service {
    List<Comment> getByBlog(Blog blog);
}
