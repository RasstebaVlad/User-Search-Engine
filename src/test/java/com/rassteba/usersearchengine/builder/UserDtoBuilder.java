package com.rassteba.usersearchengine.builder;

import com.rassteba.usersearchengine.dto.UserDto;

public class UserDtoBuilder {
	private final UserDto userDto = new UserDto();

	public UserDtoBuilder withBasicData() {
		userDto.setFirstName("Vlad");
		userDto.setLastName("Petrov");
		userDto.setAge(10);
		return this;
	}

	public UserDto build() {
		return userDto;
	}
}
