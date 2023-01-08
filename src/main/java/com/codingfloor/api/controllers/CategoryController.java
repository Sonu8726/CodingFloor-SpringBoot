package com.codingfloor.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.codingfloor.api.payloads.CategoryDto;
import com.codingfloor.api.services.CategoryService;
import com.codingfloor.api.utils.ApiResponse;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/category")
	private ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
		CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
	}

	@GetMapping("/category")
	private ResponseEntity<Object> getAllCategory() {
		List<CategoryDto> createCategory = this.categoryService.getAllCategory();
		return new ResponseEntity<Object>(createCategory, HttpStatus.OK);
	}

	@GetMapping("/category/{categoryId}")
	private ResponseEntity<Object> getCategoryById(@PathVariable String categoryId) {
		CategoryDto createCategory = this.categoryService.getCategoryById(Integer.parseInt(categoryId));
		return new ResponseEntity<>(createCategory, HttpStatus.OK);
	}

	@PutMapping("/category/{categoryId}")
	private ResponseEntity<CategoryDto> updateCategory(@PathVariable String categoryId,
			@RequestBody CategoryDto categoryDto) {
		CategoryDto createCategory = this.categoryService.updateCategory(Integer.parseInt(categoryId), categoryDto);
		return new ResponseEntity<>(createCategory, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/category/{categoryId}")
	private ResponseEntity<?> deleteCategory(@PathVariable String categoryId) {
		this.categoryService.deleteCategory(Integer.parseInt(categoryId));
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Categroy with ID " + categoryId + " is deleted successfully.", true), HttpStatus.OK);
	}

}
