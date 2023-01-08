package com.codingfloor.api.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SubCategoryDto {

	private int subCategoryId;
	private String subCategory;
	private String subCategoryDescription;
	private String categoryId;
}
