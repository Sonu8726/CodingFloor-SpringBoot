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
import com.codingfloor.api.payloads.CourseDto;
import com.codingfloor.api.services.CourseService;
import com.codingfloor.api.utils.ApiResponse;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping("/course")
	private ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
		CourseDto createCourse = this.courseService.createCourse(courseDto);
		return new ResponseEntity<>(createCourse, HttpStatus.CREATED);
	}

	@GetMapping("/course")
	private ResponseEntity<Object> getAllCourses() {
		List<CourseDto> createCourse = this.courseService.getAllCourse();
		return new ResponseEntity<Object>(createCourse, HttpStatus.OK);
	}

	@GetMapping("/course/{courseId}")
	private ResponseEntity<Object> getCourseById(@PathVariable String courseId) {
		CourseDto createCourse = this.courseService.getCourseById(Integer.parseInt(courseId));
		return new ResponseEntity<>(createCourse, HttpStatus.OK);
	}

	@PutMapping("/course/{courseId}")
	private ResponseEntity<CourseDto> updateCourse(@PathVariable String courseId, @RequestBody CourseDto courseDto) {
		CourseDto createCourse = this.courseService.updateCourse(Integer.parseInt(courseId), courseDto);
		return new ResponseEntity<>(createCourse, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/course/{courseId}")
	private ResponseEntity<?> deleteCourse(@PathVariable String courseId) {
		this.courseService.deleteCourse(Integer.parseInt(courseId));
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("User with ID " + courseId + " is deleted successfully.", true), HttpStatus.OK);
	}

}
