package com.esri.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esri.entity.User;
import com.esri.service.UserService;
/**
 * ����Junit��spring���Ի���
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})

public class UserDaoImplTest {

	//����ֻ��дΪ�ӿڵ���ʽ��UserService��spring�Զ�ע��
	@Resource
	private UserService us;
	
	
	@Test
	public void testfind() {
		User user = us.findUserByUserName("admin111");
		System.out.println(user);
	}

}
