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

import com.codingfloor.api.payloads.UserDto;
import com.codingfloor.api.services.UserService;

@RestController
public class CourseController {

	@Autowired
	private UserService userService;

	@PostMapping("/course")
	private ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createUser = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}

	@GetMapping("/course")
	private ResponseEntity<Object> getAllUsers() {
		List<UserDto> createUser = this.userService.getAllUser();
		return new ResponseEntity<Object>(createUser, HttpStatus.OK);
	}

	@GetMapping("/course/{courseId}")
	private ResponseEntity<Object> getUserById(@PathVariable String userId) {
		UserDto createUser = this.userService.getUserById(Integer.parseInt(userId));
		return new ResponseEntity<>(createUser, HttpStatus.OK);
	}

	@PutMapping("/course/{courseId}")
	private ResponseEntity<UserDto> updateUser(@PathVariable String userId, @RequestBody UserDto userDto) {
		UserDto createUser = this.userService.updateUser(Integer.parseInt(userId), userDto);
		return new ResponseEntity<>(createUser, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/course/{courseId}")
	private ResponseEntity<?> deleteUser(@PathVariable String userId) {
		return new ResponseEntity<>(this.userService.deleteUser(Integer.parseInt(userId)), HttpStatus.GONE);
	}

}
