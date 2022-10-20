package com.elta.elta.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.elta.elta.representations.UserRepresentation;

@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    @SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @Column(name="id", updatable = false)
    private Integer id;
    
    @Column(name="first_name", nullable = false)
    private String firstName;
    
    @Column(name="last_name", nullable = false)
    private String lastName;
    
    @Column(name="username", nullable = false, unique = true)
    private String username;
    
    @Column(name="user_id", nullable = false, unique = true)
    private String userId;
    
    @Column(name="title", nullable = false)
    private String title;
    
    @Column(name="created_on", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    
    @Column(name="last_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedOn;
    
    @ManyToOne
    @JoinColumn(name="reports_to")
    private User reportTo;
    
    @OneToMany(mappedBy="reportTo")
    private Set<User> reportee = new HashSet<>();
    
    public User() {}

	public User(Integer id, String firstName, String lastName, String username, String userId, String email,
			String title, Date createdOn, Date lastModifiedOn) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.userId = userId;
		this.title = title;
		this.createdOn = createdOn;
		this.lastModifiedOn = lastModifiedOn;
	}
	
	public User(UserRepresentation userRepresentation) {
		if (userRepresentation.getId() != null) {
			this.id = userRepresentation.getId();
		}
		this.firstName = userRepresentation.getFirstName();
		this.lastName = userRepresentation.getLastName();
		this.username = userRepresentation.getUsername();
		this.userId = userRepresentation.getUserId();
		this.title = userRepresentation.getTitle();
		if (userRepresentation.getCreatedOn() != null) {
			this.createdOn = userRepresentation.getCreatedOn();	
		}
		if (userRepresentation.getLastModifiedOn() != null) {
			this.createdOn = userRepresentation.getLastModifiedOn();	
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public User getReportTo() {
		return reportTo;
	}

	public void setReportTo(User reportTo) {
		this.reportTo = reportTo;
	}

	public Set<User> getReportee() {
		return reportee;
	}

	public void setReportee(Set<User> reportee) {
		this.reportee = reportee;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + ": " + userId;
	}
	
}
