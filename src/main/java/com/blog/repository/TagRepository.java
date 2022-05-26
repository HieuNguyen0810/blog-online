package com.blog.repository;

import com.blog.model.Tag;
import com.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
