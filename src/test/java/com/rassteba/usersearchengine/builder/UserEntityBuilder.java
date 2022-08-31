package com.rassteba.usersearchengine.builder;

import com.rassteba.usersearchengine.entity.UserEntity;

import java.time.LocalDate;

public class UserEntityBuilder {
	private final UserEntity userEntity = new UserEntity();

	public UserEntityBuilder withBasicData() {
		userEntity.setFirstName("Vlad");
		userEntity.setLastName("Petrov");
		userEntity.setBirthday(LocalDate.parse("2004-05-17"));
		return this;
	}

	public UserEntity build() {
		return userEntity;
	}
}
