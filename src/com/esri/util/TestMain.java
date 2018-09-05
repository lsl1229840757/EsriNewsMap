package com.esri.util;

import java.util.List;

import com.esri.dao.NewsDao;
import com.esri.dao.UserDao;
import com.esri.dao.daoImpl.NewsDaoImpl;
import com.esri.dao.daoImpl.UserDaoImpl;
import com.esri.entity.News;
import com.esri.entity.User;

public class TestMain {
	public static void main(String[] args) {
		/*CategoryDaoImpl categoryDaoIm = new CategoryDaoImpl();
		List<Category> list = categoryDaoIm.findAll();
		for(Category category:list) {
			System.out.println(category);
		}*/
		
		NewsDao newsDao = new NewsDaoImpl();
		List<News> list2 = newsDao.findAll();
		for(News news:list2) {
			System.out.println(news);
		}
		
		List<News> news = newsDao.findNewsByTitle("ºúÉ­ÕæË§");
		System.out.println(news.toString());
		
		UserDao userDao = new UserDaoImpl();
		List<User> list4 = userDao.findAll();
		System.out.println(list4.toString());
	}
}
