package com.rassteba.usersearchengine.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rassteba.usersearchengine.UserSearchEngineApplication;
import com.rassteba.usersearchengine.dto.UserDto;
import com.rassteba.usersearchengine.entity.UserEntity;
import com.rassteba.usersearchengine.mapper.UserMapper;
import com.rassteba.usersearchengine.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =
				SpringBootTest.WebEnvironment.MOCK,
				classes = UserSearchEngineApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
				locations = "classpath:application-integrationtest.properties")
public class UserControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserMapper userMapper;

	@Test
	public void test_findById_success() throws Exception {
		long userId = 1L;
		Optional<UserEntity> optUser = userRepository.findById(userId);
		UserDto expected = userMapper.toDto(optUser.get());

		mockMvc.perform(get("/users/{id}", userId)
										.contentType(MediaType.APPLICATION_JSON))
										.andExpect(status().isOk())
										.andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expected)));
	}
}

