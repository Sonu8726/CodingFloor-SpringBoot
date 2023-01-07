package com.codingfloor.api.services;

import java.util.List;
import com.codingfloor.api.payloads.CourseDto;

public interface CourseService {

	CourseDto createCourse(CourseDto course);

	CourseDto updateCourse(Integer courseId, CourseDto course);

	CourseDto getCourseById(Integer courseId);

	List<CourseDto> getAllCourse();

	String deleteCourse(Integer courseId);

}
