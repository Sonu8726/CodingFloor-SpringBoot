package com.codingfloor.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingfloor.api.Entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
