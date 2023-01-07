package com.codingfloor.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingfloor.api.Entities.Course;
import com.codingfloor.api.payloads.CourseDto;
import com.codingfloor.api.repositories.CourseRepository;
import com.codingfloor.api.services.CourseService;
import com.codingfloor.api.exceptions.ResourceNotFoundException;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CourseDto createCourse(CourseDto courseDto) {
		Course course = this.dtoToEntity(courseDto);
		Course savedUser = this.courseRepo.save(course);
		return entityToDto(savedUser);
	}

	@Override
	public CourseDto updateCourse(Integer courseId, CourseDto courseDto) {
		Course cs = this.courseRepo.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course", "Course ID", courseId));

		cs.setCourseName(courseDto.getCourseName());
		cs.setCourseCategory(courseDto.getCourseCategory());
		cs.setCourseSubCategory(courseDto.getCourseSubCategory());
		cs.setCourseAuthor(courseDto.getCourseAuthor());
		cs.setCourseType(courseDto.getCourseType());
		cs.setCoursePrice(courseDto.getCoursePrice());
		cs.setCourseDiscountedPrice(courseDto.getCourseDiscountedPrice());
		cs.setCourseRatings(courseDto.getCourseRatings());

		Course updatedUser = this.courseRepo.save(cs);
		return entityToDto(updatedUser);
	}

	@Override
	public CourseDto getCourseById(Integer courseId) {
		Course course = this.courseRepo.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course", "Course ID", courseId));
		return this.entityToDto(course);
	}

	@Override
	public List<CourseDto> getAllCourse() {
		List<Course> users = this.courseRepo.findAll();

		List<CourseDto> userDtos = users.stream().map(course -> this.entityToDto(course)).collect(Collectors.toList());

		return userDtos;
	}

	@Override
	public String deleteCourse(Integer courseId) {
		Course course = this.courseRepo.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course", "Course ID", courseId));
		this.courseRepo.delete(course);
		return "courseId: " + courseId + " is deleted form the table.";
	}

	private Course dtoToEntity(CourseDto courseDto) {
		Course course = this.modelMapper.map(courseDto, Course.class);
		return course;
	}

	private CourseDto entityToDto(Course course) {
		CourseDto courseDto = this.modelMapper.map(course, CourseDto.class);
		return courseDto;
	}

}
