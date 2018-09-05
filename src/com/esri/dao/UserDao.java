package com.esri.dao;

import java.util.List;

import com.esri.entity.User;

public interface UserDao {

	//通过用户名查询
	public User findUserByUserName(String username);
	
	//查询到所有用户
	public List<User> findAll();
	
	//增加用户，用于注册
	public boolean add(User user);
	
	//判断有无此用户
	public boolean findLogin(User user);
	
	//判断修改信息是否成功
	public boolean update(User user);
}
