package com.mcnc.usermanagement.message.request;

import com.mcnc.usermanagement.constant.UserRole;

public class UserQuery {

	private String username;
	private UserRole role;
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
