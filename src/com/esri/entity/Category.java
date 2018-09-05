package com.esri.entity;

import java.util.HashSet;
import java.util.Set;

public class Category {

	//新闻类别
	private String category;
	//新闻
	private Set<News> news = new HashSet<News>();
	//用户
	//private User user = new User();
	private Set<User> users = new HashSet<User>();
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Set<News> getNews() {
		return news;
	}
	public void setNews(Set<News> news) {
		this.news = news;
	}
	public Category(String category) {
		super();
		this.category = category;
	}
	public Category() {
		
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Category [category=" + category  + "]";
	}
}
