
package com.example.user.model;


public class User {
  private String userId;
	private String password;
	private String userName;
	private String role;

	public User() {
	}

	public String getUserId() {
		return this.userId;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getRole() {
		return this.role;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public void setRole(final String role) {
		this.role = role;
	}
}
