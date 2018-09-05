package com.esri.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.esri.dao.UserDao;
import com.esri.entity.User;
import com.esri.service.UserService;
/*
 * 交给spring管理
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao ud;
	
	
	@Override
	public User findUserByUserName(String username) {
		return ud.findUserByUserName(username);
	}

	@Override
	public List<User> findAll() {
		return ud.findAll();
	}

	@Override
	public boolean add(User user) {
		return ud.add(user);
	}

	@Override
	public boolean findLogin(User user) {
		return ud.findLogin(user);
	}

	@Override
	public boolean update(User user) {
		return ud.update(user);
	}

}
