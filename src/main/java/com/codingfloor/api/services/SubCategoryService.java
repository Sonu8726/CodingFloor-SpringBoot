package com.codingfloor.api.services;

import java.util.List;

import com.codingfloor.api.payloads.SubCategoryDto;

public interface SubCategoryService {

	SubCategoryDto createSubCategory(SubCategoryDto subCategory);

	SubCategoryDto updateSubCategory(Integer subCategoryId, SubCategoryDto subCategory);

	SubCategoryDto getSubCategoryById(Integer subCategoryId);

	String deleteSubCategory(Integer subCategoryId);

	List<SubCategoryDto> getAllSubCategoryFromACourse(Integer courseId);

	List<SubCategoryDto> getAllSubCategory();

}
