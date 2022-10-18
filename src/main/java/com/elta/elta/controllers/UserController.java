package com.elta.elta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elta.elta.entities.User;
import com.elta.elta.services.UserService;

@RestController
@RequestMapping(path="api/v1/users")
public class UserController {

	private UserService userService;
		
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public List<User> getUsers() {
		System.out.println(userService.getUsers());
		return userService.getUsers();
	}
	
	@PostMapping()
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}
	
	@PutMapping()
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}
}
