package com.esri.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esri.entity.News;
import com.esri.service.NewsService;
/**
 * 锟斤拷锟斤拷Junit锟斤拷spring锟斤拷锟皆伙拷锟斤拷
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})

public class UserDaoImplTest {

	//锟斤拷锟斤拷只锟斤拷写为锟接口碉拷锟斤拷式锟斤拷UserService锟斤拷spring锟皆讹拷注锟斤拷
	@Resource
	private NewsService news;

	
	@Test
	public void testfind() {
	
		List<News> list = news.findNewsByTitle("特朗普");
		
		long mills = (long)list.get(0).getPubDate();
		System.out.println(mills);
		Date date = new Date(mills*1000);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
		System.out.println(list);
	}
	

}
