package com.elta.elta.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users", schema = "prime")
public class Users {

    @Id
    @SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @Column(name="user_id", updatable = false)
    Long user_id;
    
    @Column(name="username", nullable = false, unique = true)
    String username;
    
    @Column(name="fname", nullable = false)
    String fname;
    
    @Column(name="lname", nullable = false)
    String lname;
    
    @Column(name="email", nullable = false, unique = true)
    String email;
    
    @Column(name="title", nullable = false)
    String title;
    
    @Column(name="created_on", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date createdOn;
    
    @Column(name="last_modified_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date LastModifiedOn;
    
    public Users() {}

	public Users(Long user_id, String username, String fname, String lname, String email, String title, Date createdOn,
			Date lastModifiedOn) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.title = title;
		this.createdOn = createdOn;
		LastModifiedOn = lastModifiedOn;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastModifiedOn() {
		return LastModifiedOn;
	}

	public void setLastModifiedOn(Date lastModifiedOn) {
		LastModifiedOn = lastModifiedOn;
	}

	
}
