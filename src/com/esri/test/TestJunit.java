package com.esri.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esri.entity.HistoryNews;
import com.esri.entity.News;
import com.esri.service.NewsService;
import com.esri.util.CalenderTools;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})

public class TestJunit {

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
	
	@Test
	public void test3() {
		List<HistoryNews> findNewsByTime = news.findHistoryNewsByTime(new Date());
		System.out.println(findNewsByTime.size());
		for(HistoryNews h:findNewsByTime) {
			System.out.println(h);
		}
	}
	@Test
	public void test4() {
		int a = news.findHistoryNewsCountByTime(new Date());
		System.out.println(a);
	}
	@Test
	public void test5() {
		int a = news.findRecentNewsCount(new Date());
		System.out.println(a);
	}

	@Test
	public void test6() {
		JSONArray ja = news.statistics();
		System.out.println(ja);
	}
	
	@Test
	public void test7() throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-dd-MM");
		String format = sf.format(new Date());
		System.out.println(format);
		System.out.println(new Date().getTime());
		System.out.println(sf.parse(format));
	}
}

