package com.rassteba.usersearchengine.service;

import com.rassteba.usersearchengine.dto.UserDto;

public interface UserService {

	UserDto findUserById(Long id);
}
