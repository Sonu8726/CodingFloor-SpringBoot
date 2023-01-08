package com.codingfloor.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingfloor.api.Entities.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

}
