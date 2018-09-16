package com.esri.service;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;

import com.esri.entity.HistoryNews;
import com.esri.entity.News;

public interface NewsService {

	public List<News> findNewsByTitle(String title);
	
	public List<News> findNewsByCategory(String category);
	
	public List<News> findRecentNews();
	
	public List<HistoryNews> findHistoryNewsByTime(Date now);

	public int findHistoryNewsCountByTime(Date now);
	
	public int findRecentNewsCount(Date now);

	public JSONArray statistics();

}
