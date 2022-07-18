package com.blaze.spring.example.controller;

import com.blaze.spring.example.service.UserService;
import com.blaze.spring.example.service.views.UserView;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@QueryMapping
	public List<UserView> getAllUsers(DataFetchingEnvironment dataFetchingEnvironment) {
		return userService.getAllUsers(dataFetchingEnvironment);
	}
}
