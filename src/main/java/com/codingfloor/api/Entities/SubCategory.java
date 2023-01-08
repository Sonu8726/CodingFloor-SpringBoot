package com.codingfloor.api.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subcategory")
@NoArgsConstructor
@Getter
@Setter
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subCategoryId;
	private String subCategory;
	private String subCategoryDescription;
	private String categoryId;
}
