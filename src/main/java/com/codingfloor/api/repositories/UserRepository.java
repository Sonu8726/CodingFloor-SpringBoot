package com.codingfloor.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingfloor.api.Entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
