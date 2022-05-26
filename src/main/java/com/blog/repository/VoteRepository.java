package com.blog.repository;

import com.blog.model.User;
import com.blog.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
