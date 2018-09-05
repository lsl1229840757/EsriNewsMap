package com.esri.dao;

import java.util.List;

import com.esri.entity.User;

public interface UserDao {

	//ͨ���û�����ѯ
	public User findUserByUserName(String username);
	
	//��ѯ�������û�
	public List<User> findAll();
	
	//�����û�������ע��
	public boolean add(User user);
	
	//�ж����޴��û�
	public boolean findLogin(User user);
	
	//�ж��޸���Ϣ�Ƿ�ɹ�
	public boolean update(User user);
}
