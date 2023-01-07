package com.codingfloor.api.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CourseDto {

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
