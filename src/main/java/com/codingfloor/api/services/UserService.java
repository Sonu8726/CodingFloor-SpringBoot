package com.codingfloor.api.services;

import java.util.List;
import com.codingfloor.api.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);

	UserDto updateUser(Integer userId, UserDto user);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUser();

	String deleteUser(Integer userId);

}
