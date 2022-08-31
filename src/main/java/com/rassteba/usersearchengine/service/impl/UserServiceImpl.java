package com.rassteba.usersearchengine.service.impl;

import com.rassteba.usersearchengine.dto.UserDto;
import com.rassteba.usersearchengine.exception.UserNotFoundException;
import com.rassteba.usersearchengine.mapper.UserMapper;
import com.rassteba.usersearchengine.repository.UserRepository;
import com.rassteba.usersearchengine.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

	UserMapper userMapper;
	UserRepository userRepository;

	@Override
	public UserDto findUserById(Long id) {
		return userRepository.findById(id)
						.map(userMapper::toDto)
						.orElseThrow(() -> new UserNotFoundException("User not found by id: " + id));
	}
}
