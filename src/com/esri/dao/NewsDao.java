package com.esri.dao;

import java.util.Date;
import java.util.List;

import com.esri.entity.HistoryNews;
import com.esri.entity.News;

public interface NewsDao {

	//通过标题查询
	public List<News> findNewsByTitle(String title);
	
	//通过类别查询
	public List<News> findNewsByCategory(String category);
	
	//当前新闻
	public List<News> findRecentNews();
	
	public List<HistoryNews> findNewsByTime(Date now);
	
	
}
