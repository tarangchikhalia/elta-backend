package com.elta.elta.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elta.elta.entities.Users;
import com.elta.elta.services.UserService;

@RestController
@RequestMapping(path="api/v1/users")
public class UserController {

	private UserService userService;
		
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public List<Users> getUsers() {
		System.out.println(userService.getUsers());
		return userService.getUsers();
	}
}
