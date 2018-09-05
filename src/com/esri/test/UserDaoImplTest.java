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
 * 配置Junit的spring测试环境
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})

public class UserDaoImplTest {

	//这里只能写为接口的形式，UserService由spring自动注入
	@Resource
	private UserService us;
	
	
	@Test
	public void testfind() {
		User user = us.findUserByUserName("admin111");
		System.out.println(user);
	}

}
