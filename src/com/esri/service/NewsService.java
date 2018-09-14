package com.esri.service;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;

import com.esri.entity.HistoryNews;
import com.esri.entity.News;

public interface NewsService {

	//通过标题查询
	public List<News> findNewsByTitle(String title);
	
	//通过类别查询
	public List<News> findNewsByCategory(String category);
	
	//当前新闻
	public List<News> findRecentNews();
	
	public List<HistoryNews> findHistoryNewsByTime(Date now);

	public int findHistoryNewsCountByTime(Date now);
	
	public int findRecentNewsCount(Date now);
	/**
	 * @return 返回一个jsonarry里面有10天的新闻数据和其对应的日期
	 */
	public JSONArray statistics();
}
