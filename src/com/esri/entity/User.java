package com.esri.entity;

import java.util.HashSet;
import java.util.Set;

public class User {

	private String username;
	private String password;
	private String name;
	private Integer age;
	private String gender;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public User(String username, String password, String name, Integer age, String gender) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", age=" + age + ", gender="
				+ gender + ""+"]";
	}

}
