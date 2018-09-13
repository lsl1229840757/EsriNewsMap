package com.esri.dao;

import java.util.Date;
import java.util.List;

import com.esri.entity.HistoryNews;
import com.esri.entity.News;

public interface NewsDao {

	//ͨ�������ѯ
	public List<News> findNewsByTitle(String title);
	
	//ͨ������ѯ
	public List<News> findNewsByCategory(String category);
	
	//��ǰ����
	public List<News> findRecentNews();
	
	public List<HistoryNews> findNewsByTime(Date now);
	
	
}
