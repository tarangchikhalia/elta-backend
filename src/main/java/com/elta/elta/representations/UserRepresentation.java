package com.elta.elta.representations;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.elta.elta.entities.Email;
import com.elta.elta.entities.User;

public class UserRepresentation {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String username;
	private String userId;
	private String title;
	private Date createdOn;
	private Date lastModifiedOn;
	private Integer reportToId;
	private String reportToName;
	private Set<EmailRepresentation> emails = new HashSet<>();
	
	public UserRepresentation() {
		
	}
	
	public UserRepresentation(User user) {
		if (user != null) {
			this.id = user.getId();
			this.firstName = user.getFirstName();
			this.lastName = user.getLastName();
			this.username = user.getUsername();
			this.userId = user.getUserId();
			this.title = user.getTitle();
			this.createdOn = user.getCreatedOn();
			this.lastModifiedOn = user.getLastModifiedOn();
			if (user.getReportTo() != null) {
				this.reportToId = user.getReportTo().getId();
				this.reportToName = user.getReportTo().toString();
			}
			this.emails = user.getEmails().stream().map(email -> new EmailRepresentation(email)).collect(Collectors.toSet());
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

	public Integer getReportToId() {
		return reportToId;
	}

	public void setReportToId(Integer reportToId) {
		this.reportToId = reportToId;
	}

	public String getReportToName() {
		return reportToName;
	}

	public void setReportToName(String reportToName) {
		this.reportToName = reportToName;
	}

	public Set<EmailRepresentation> getEmails() {
		return emails;
	}

	public void setEmails(Set<EmailRepresentation> emails) {
		this.emails = emails;
	}

	

}
