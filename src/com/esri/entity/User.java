package com.esri.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * �û���ģ��
 * 
 * @author ��ɭ
 *
 */
public class User {

	// �û���
	private String username;
	// ����
	private String password;
	// �ǳ�
	private String name;
	// ����
	private Integer age;
	// �Ա�
	private String gender;
	// �û�ϲ��(һ�Զ�)
	private Set<Category> interestCategory = new HashSet<Category>();

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

	public Set<Category> getInterestCategory() {
		return interestCategory;
	}

	public void setInterestCategory(Set<Category> interestCategory) {
		this.interestCategory = interestCategory;
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
