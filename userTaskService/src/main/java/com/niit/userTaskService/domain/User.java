package com.niit.userTaskService.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	private String email;
	private String username;
	private String password;
	private List<Tasks> tasklist;

	public User() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Tasks> getTasklist() {
		return tasklist;
	}

	public void setTasklist(List<Tasks> tasklist) {
		this.tasklist = tasklist;
	}

	@Override
	public String toString() {
		return "User{" +
				"email='" + email + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", tasklist=" + tasklist +
				'}';
	}
}
