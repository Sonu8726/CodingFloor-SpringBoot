package com.codingfloor.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingfloor.api.Entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
