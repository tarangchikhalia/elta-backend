package com.elta.elta.services;

import java.util.List;

import com.elta.elta.representations.UserRepresentation;

public interface UserService {
	
	List<UserRepresentation> getUsers();

	void createUser(UserRepresentation user) throws Exception;

	void updateUser(UserRepresentation user);

	void deleteUser(Integer id);

}
