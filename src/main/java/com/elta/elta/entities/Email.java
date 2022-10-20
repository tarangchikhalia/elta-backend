package com.elta.elta.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.elta.elta.representations.EmailRepresentation;

@Entity
@Table(name = "email")
public class Email {

	@Id
	@SequenceGenerator(name = "emails_sequence", sequenceName = "emails_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emails_sequence")
	@Column(name = "id", nullable = false, updatable = false)
	private Integer id;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	
	public Email() {}
	
	public Email(EmailRepresentation emailRepresentation) {
		if (emailRepresentation.getId() != null) {
			this.id = emailRepresentation.getId();
		}
		this.email = emailRepresentation.getEmail();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
}
