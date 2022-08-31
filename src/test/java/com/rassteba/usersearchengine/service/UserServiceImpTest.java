package com.rassteba.usersearchengine.service;

import com.rassteba.usersearchengine.builder.UserDtoBuilder;
import com.rassteba.usersearchengine.builder.UserEntityBuilder;
import com.rassteba.usersearchengine.dto.UserDto;
import com.rassteba.usersearchengine.entity.UserEntity;
import com.rassteba.usersearchengine.exception.UserNotFoundException;
import com.rassteba.usersearchengine.mapper.UserMapper;
import com.rassteba.usersearchengine.repository.UserRepository;
import com.rassteba.usersearchengine.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceImpTest {

	@Mock
	UserMapper userMapper;
	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userService;

	@Test
	void test_findUserById_success() {
		UserDto expected = new UserDtoBuilder().withBasicData().build();

		UserEntity userEntity = new UserEntityBuilder().withBasicData().build();
		Mockito.when(userRepository.findById(Mockito.any())).thenReturn(Optional.of(userEntity));
		Mockito.when(userMapper.toDto(Mockito.any())).thenReturn(expected);
		UserDto actual = userService.findUserById(1L);

		Assertions.assertEquals(expected, actual);
	}

	@Test
	void test_findUserById_shouldThrowUserNotFoundException() {
		Mockito.when(userRepository.findById(Mockito.any())).thenReturn(Optional.empty());
		Assertions.assertThrows(UserNotFoundException.class,() -> userService.findUserById(1L));
	}
}
