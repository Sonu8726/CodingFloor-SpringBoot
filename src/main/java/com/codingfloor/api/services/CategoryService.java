package com.codingfloor.api.services;

import java.util.List;

import com.codingfloor.api.payloads.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto category);

	CategoryDto updateCategory(Integer categoryId, CategoryDto category);

	CategoryDto getCategoryById(Integer categoryId);

	String deleteCategory(Integer categoryId);

	List<CategoryDto> getAllCategory();

}
