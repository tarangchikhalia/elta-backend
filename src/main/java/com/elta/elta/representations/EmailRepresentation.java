package com.elta.elta.representations;

import com.elta.elta.entities.Email;

public class EmailRepresentation {

	private Integer id;
	private String email;
//	private UserRepresentation user;
	
	public EmailRepresentation() {
		
	}
	
	public EmailRepresentation(Email email) {
		if (email != null) {
			this.id = email.getId();
			this.email = email.getEmail();
		}
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public UserRepresentation getUser() {
//		return user;
//	}
//	public void setUser(UserRepresentation user) {
//		this.user = user;
//	}
	
	
}
