package com.example.demo.domain.model;

import java.util.Date;

public class User {
  private String userId;
	private String password;
	private String userName;
	private Date birthday;
	private int age;
	private boolean marriage;
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

	public Date getBirthday() {
		return this.birthday;
	}

	public int getAge() {
		return this.age;
	}

	public boolean isMarriage() {
		return this.marriage;
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

	public void setBirthday(final Date birthday) {
		this.birthday = birthday;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public void setMarriage(final boolean marriage) {
		this.marriage = marriage;
	}

	public void setRole(final String role) {
		this.role = role;
	}

}
