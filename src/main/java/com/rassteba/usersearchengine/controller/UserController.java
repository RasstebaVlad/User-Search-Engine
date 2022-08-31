package com.rassteba.usersearchengine.controller;

import com.rassteba.usersearchengine.dto.UserDto;
import com.rassteba.usersearchengine.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

	UserService service;

	@GetMapping("/{id}")
	public UserDto findById(@PathVariable Long id) {
		return service.findUserById(id);
	}

}