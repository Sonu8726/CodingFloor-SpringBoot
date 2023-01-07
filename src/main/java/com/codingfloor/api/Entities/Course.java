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
@Table(name = "course")
@NoArgsConstructor
@Getter
@Setter
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String courseName;
	private String courseCategory;
	private String courseSubCategory;
	private String courseAuthor;
	private String courseType;
	private String coursePrice;
	private String courseDiscountedPrice;
	private String courseRatings;
}
