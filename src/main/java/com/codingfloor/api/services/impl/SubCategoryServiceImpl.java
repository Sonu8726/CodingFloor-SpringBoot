package com.codingfloor.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingfloor.api.payloads.SubCategoryDto;
import com.codingfloor.api.repositories.SubCategoryRepository;
import com.codingfloor.api.services.SubCategoryService;
import com.codingfloor.api.Entities.SubCategory;
import com.codingfloor.api.exceptions.ResourceNotFoundException;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	private SubCategoryRepository subCategoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SubCategoryDto createSubCategory(SubCategoryDto subCategoryDto) {
		SubCategory subcategory = this.dtoToEntity(subCategoryDto);
		SubCategory savedSubCategory = this.subCategoryRepo.save(subcategory);
		return entityToDto(savedSubCategory);
	}

	@Override
	public List<SubCategoryDto> getAllSubCategory() {
		List<SubCategory> subCategories = this.subCategoryRepo.findAll();

		List<SubCategoryDto> SubCategoryDtos = subCategories.stream().map(user -> this.entityToDto(user))
				.collect(Collectors.toList());

		return SubCategoryDtos;
	}

	@Override
	public SubCategoryDto updateSubCategory(Integer subCategoryId, SubCategoryDto subCategoryDto) {
		SubCategory cs = this.subCategoryRepo.findById(subCategoryId)
				.orElseThrow(() -> new ResourceNotFoundException("SubCategory", "SubCategory ID", subCategoryId));

		cs.setSubCategory(subCategoryDto.getSubCategory());
		cs.setCategoryId(subCategoryDto.getCategoryId());
		SubCategory updatedSubCategory = this.subCategoryRepo.save(cs);
		return entityToDto(updatedSubCategory);
	}

	@Override
	public SubCategoryDto getSubCategoryById(Integer subCategoryId) {
		SubCategory subCategory = this.subCategoryRepo.findById(subCategoryId)
				.orElseThrow(() -> new ResourceNotFoundException("SubCategory", "SubCategory ID", subCategoryId));
		return this.entityToDto(subCategory);
	}

	@Override
	public String deleteSubCategory(Integer subCategoryId) {
		SubCategory subCategory = this.subCategoryRepo.findById(subCategoryId)
				.orElseThrow(() -> new ResourceNotFoundException("SubCategory", "SubCategory ID", subCategoryId));
		this.subCategoryRepo.delete(subCategory);
		return "subCategoryId: " + subCategoryId + " is deleted form the table.";
	}

	private SubCategory dtoToEntity(SubCategoryDto subCategoryDto) {
		SubCategory subCategory = this.modelMapper.map(subCategoryDto, SubCategory.class);
		return subCategory;
	}

	private SubCategoryDto entityToDto(SubCategory subCategory) {
		SubCategoryDto subCategoryDto = this.modelMapper.map(subCategory, SubCategoryDto.class);
		return subCategoryDto;
	}

	@Override
	public List<SubCategoryDto> getAllSubCategoryFromACourse(Integer subCategoryId) {
		List<SubCategory> subCategorys = this.subCategoryRepo.findAll();

		List<SubCategoryDto> subCategoryDtos = subCategorys.stream().map(subCategory -> this.entityToDto(subCategory))
				.collect(Collectors.toList());

		return subCategoryDtos;
	}

}
