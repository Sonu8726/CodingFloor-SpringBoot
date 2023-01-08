package com.codingfloor.api.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;

	private String username;
	private String userType;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;

}
