package com.elta.elta.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elta.elta.entities.User;
import com.elta.elta.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public void createUser(User user) {
		Optional<User> existingUser = userRepository.findByUserId(user.getUserId());
		if (existingUser.isPresent()) {
			throw new IllegalStateException();
		}
		if (user.getUserId() == 0) {
			user.setUserId(null);	
		}
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		Optional<User> existingUser = userRepository.findByUserId(user.getUserId());
		if (!existingUser.isPresent()) {
			throw new EntityNotFoundException();
		}
		user.setLastModifiedOn(new Date(System.currentTimeMillis()));
		userRepository.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		Optional<User> existingUser = userRepository.findByUserId(userId);
		if (!existingUser.isPresent()) {
			throw new EntityNotFoundException();
		}
		userRepository.deleteById(userId);
	}

}
