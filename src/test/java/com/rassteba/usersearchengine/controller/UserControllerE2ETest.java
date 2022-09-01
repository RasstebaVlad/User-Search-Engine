package com.rassteba.usersearchengine.controller;

import com.rassteba.usersearchengine.dto.UserDto;
import com.rassteba.usersearchengine.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerE2ETest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserServiceImpl service;

	@Test
	public void givenUser_whenGetUser_thenReturnJson() throws Exception {

		UserDto alex = new UserDto("Vlad","Petrov", 32);

		given(service.findUserById(1L)).willReturn(alex);

		mockMvc.perform(get("/users/{id}", 1L)
										.contentType(MediaType.APPLICATION_JSON))
										.andExpect(status().isOk())
										.andExpect(jsonPath("$.length()", is(3)));
	}
}

