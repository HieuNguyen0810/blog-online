package com.blog.service.implement;

import com.blog.model.Blog;
import com.blog.model.Comment;
import com.blog.repository.CommentRepository;
import com.blog.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }



    public List<Comment> getByBlog(Blog blog) {
        return commentRepository.findByBlog(blog);
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
