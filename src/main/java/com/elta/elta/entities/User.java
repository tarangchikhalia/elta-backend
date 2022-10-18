package com.elta.elta.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users", schema = "prime")
public class User {

    @Id
    @SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @Column(name="user_id", updatable = false)
    Long userId;
    
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
    
    @Column(name="created_on", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date createdOn;
    
    @Column(name="last_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    Date lastModifiedOn;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="mgr_id")
    User manager;
    
    public User() {}
    
	public User(Long userId, String username, String fname, String lname, String email, String title, User manager) {
		this.userId = userId;
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.title = title;
		this.manager = manager;
		this.lastModifiedOn = new Date(System.currentTimeMillis());
	}

	public User(Long userId, String username, String fname, String lname, String email, String title, Date createdOn,
			Date lastModifiedOn, User manager) {
		this.userId = userId;
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.title = title;
		this.createdOn = createdOn;
		this.lastModifiedOn = lastModifiedOn;
		this.manager = manager;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

}
