package com.elta.elta.services;

import java.util.List;

import com.elta.elta.entities.User;

public interface UserService {
	
	List<User> getUsers();

	void createUser(User user);

	void updateUser(User user);

	void deleteUser(Long userId);

}
