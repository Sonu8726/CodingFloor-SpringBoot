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
import com.codingfloor.api.utils.ApiResponse;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	private ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createUser = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}

	@GetMapping("/users")
	private ResponseEntity<Object> getAllUsers() {
		List<UserDto> createUser = this.userService.getAllUser();
		return new ResponseEntity<Object>(createUser, HttpStatus.OK);
	}

	@GetMapping("/users/{userId}")
	private ResponseEntity<Object> getUserById(@PathVariable String userId) {
		UserDto createUser = this.userService.getUserById(Integer.parseInt(userId));
		return new ResponseEntity<>(createUser, HttpStatus.OK);
	}

	@PutMapping("/users/{userId}")
	private ResponseEntity<UserDto> updateUser(@PathVariable String userId, @RequestBody UserDto userDto) {
		UserDto createUser = this.userService.updateUser(Integer.parseInt(userId), userDto);
		return new ResponseEntity<>(createUser, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/users/{userId}")
	private ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId) {
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("User with ID " + userId + " is deleted successfully.", true), HttpStatus.OK);
	}

}
