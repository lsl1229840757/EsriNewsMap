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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})

public class UserDaoImplTest {

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
	@Test
	public void testfind2() {
		
		List<News> list = news.findRecentNews();
		System.out.println(list.size());
		for(News s:list) {
			System.out.println(s);
		}
	}
	
}
