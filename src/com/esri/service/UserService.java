package com.esri.service;

import java.util.List;

import com.esri.entity.User;

public interface UserService {
		public User findUserByUserName(String username);
		
		public List<User> findAll();
		
		public boolean add(User user);
		
		public boolean findLogin(User user);
		
		public boolean update(User user);
}
