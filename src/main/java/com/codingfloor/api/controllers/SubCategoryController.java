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
import com.codingfloor.api.payloads.SubCategoryDto;
import com.codingfloor.api.services.SubCategoryService;
import com.codingfloor.api.utils.ApiResponse;

@RestController
public class SubCategoryController {

	@Autowired
	private SubCategoryService subCategoryService;

	@PostMapping("/subcategory")
	private ResponseEntity<SubCategoryDto> createSubCategory(@RequestBody SubCategoryDto categoryDto) {
		SubCategoryDto createSubCategory = this.subCategoryService.createSubCategory(categoryDto);
		return new ResponseEntity<>(createSubCategory, HttpStatus.CREATED);
	}

	@GetMapping("/subcategory")
	private ResponseEntity<Object> getAllSubCategorys() {
		List<SubCategoryDto> createSubCategory = this.subCategoryService.getAllSubCategory();
		return new ResponseEntity<Object>(createSubCategory, HttpStatus.OK);
	}

	@GetMapping("/subcategory/{subcategoryId}")
	private ResponseEntity<Object> getSubCategoryById(@PathVariable String subCategoryId) {
		SubCategoryDto createSubCategory = this.subCategoryService.getSubCategoryById(Integer.parseInt(subCategoryId));
		return new ResponseEntity<>(createSubCategory, HttpStatus.OK);
	}

	@PutMapping("/subcategory/{subcategoryId}")
	private ResponseEntity<SubCategoryDto> updateSubCategory(@PathVariable String subCategoryId,
			@RequestBody SubCategoryDto categoryDto) {
		SubCategoryDto createSubCategory = this.subCategoryService.updateSubCategory(Integer.parseInt(subCategoryId),
				categoryDto);
		return new ResponseEntity<>(createSubCategory, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/subcategory/{subcategoryId}")
	private ResponseEntity<?> deleteSubCategory(@PathVariable String categoryId) {
		this.subCategoryService.deleteSubCategory(Integer.parseInt(categoryId));
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Categroy with ID " + categoryId + " is deleted successfully.", true), HttpStatus.OK);
	}

}
