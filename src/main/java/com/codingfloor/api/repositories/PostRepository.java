package com.codingfloor.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingfloor.api.Entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
