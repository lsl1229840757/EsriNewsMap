package com.esri.dao;

import java.util.Date;
import java.util.List;

import com.esri.entity.News;

public interface NewsDao {

	//通过标题查询
	public List<News> findNewsByTitle(String title);
	
	//通过类别查询
	public List<News> findNewsByCategory(String category);
	
	//查询一天
	public List<News> findNewsByPubDate(Date pubDate);
	
	/*//通过地区查询
	public List<News> findNewsByRegion(String region);
	*/
	//查询七天，用于删除之前的新闻
	public List<News> findNewsByPubWeek(Date endPubDate);
	
	//查询全部
	public List<News> findAll();
	
	
}
