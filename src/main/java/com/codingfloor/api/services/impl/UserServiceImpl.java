package com.codingfloor.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingfloor.api.Entities.Users;
import com.codingfloor.api.payloads.UserDto;
import com.codingfloor.api.repositories.UserRepository;
import com.codingfloor.api.services.UserService;
import com.codingfloor.api.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		Users user = this.dtoToEntity(userDto);
		Users savedUser = this.userRepo.save(user);
		return entityToDto(savedUser);
	}

	@Override
	public UserDto updateUser(Integer userId, UserDto userDto) {
		Users user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User ID", userId));

		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPhone(userDto.getPhone());
		user.setPassword(userDto.getPassword());
		user.setUserType(userDto.getUserType());
		Users updatedUser = this.userRepo.save(user);
		return entityToDto(updatedUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		Users user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User ID", userId));
		return this.entityToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<Users> users = this.userRepo.findAll();

		List<UserDto> userDtos = users.stream().map(user -> this.entityToDto(user)).collect(Collectors.toList());

		return userDtos;
	}

	@Override
	public String deleteUser(Integer userId) {
		Users user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User ID", userId));
		this.userRepo.delete(user);
		return "userId: " + userId + " is deleted form the table.";
	}

	private Users dtoToEntity(UserDto userDto) {
		Users user = this.modelMapper.map(userDto, Users.class);
		return user;
	}

	private UserDto entityToDto(Users user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

}
