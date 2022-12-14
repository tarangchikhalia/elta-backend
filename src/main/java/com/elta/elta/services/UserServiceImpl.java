package com.elta.elta.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elta.elta.entities.Email;
import com.elta.elta.entities.User;
import com.elta.elta.repositories.EmailRepository;
import com.elta.elta.repositories.UserRepository;
import com.elta.elta.representations.EmailRepresentation;
import com.elta.elta.representations.UserRepresentation;

@Service
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private EmailRepository emailRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, EmailRepository emailRepository) {
		super();
		this.userRepository = userRepository;
		this.emailRepository = emailRepository;
	}

	@Override
	public List<UserRepresentation> getUsers() {
		return userRepository.findAll().stream().map((user) -> new UserRepresentation(user)).toList();
	}

	@Override
	public void createUser(UserRepresentation userRepresentation) throws Exception {
		Optional<User> existingUser = userRepository.findByUserId(userRepresentation.getUserId());
		if (existingUser.isPresent()) {
			throw new Exception();
		}
		User newUser = new User(userRepresentation);
		newUser.setId(null);
		Date currentDate = new Date(System.currentTimeMillis());
		newUser.setCreatedOn(currentDate);
		newUser.setLastModifiedOn(currentDate);
		newUser.setReportTo(userRepository.findById(userRepresentation.getReportToId()).orElse(null));
		
		if (!userRepresentation.getEmails().isEmpty()) {
			addEmails(userRepresentation);
		}
		userRepository.save(newUser);
	}

	@Override
	public void updateUser(UserRepresentation userRepresentation) {
		Optional<User> existingUser = userRepository.findByUserId(userRepresentation.getUserId());
		if (!existingUser.isPresent()) {
			throw new EntityNotFoundException();
		}
		User newUser = new User(userRepresentation);
		newUser.setLastModifiedOn(new Date(System.currentTimeMillis()));
		newUser.setReportTo(userRepository.findById(userRepresentation.getReportToId()).orElse(null));
		if (!userRepresentation.getEmails().isEmpty()) {
			addEmails(userRepresentation);
		}
		userRepository.save(newUser);
	}

	@Override
	public void deleteUser(Integer id) {
		Optional<User> existingUser = userRepository.findById(id);
		if (!existingUser.isPresent()) {
			throw new EntityNotFoundException();
		}
		userRepository.deleteById(id);
	}
	
	private void addEmails(UserRepresentation userRepresentation) {
		for (EmailRepresentation emailRepresentation : userRepresentation.getEmails() ) {
			Email email = new Email(emailRepresentation);
			Optional<User> existingUser = userRepository.findByUserId(userRepresentation.getUserId());
			if (existingUser.isPresent()) {
				email.setUser(existingUser.get());
				emailRepository.save(email);
			}
		}
	}

}
