package com.esri.dao;

import java.util.Date;
import java.util.List;

import com.esri.entity.News;

public interface NewsDao {

	//ͨ�������ѯ
	public List<News> findNewsByTitle(String title);
	
	//ͨ������ѯ
	public List<News> findNewsByCategory(String category);
	
	//��ѯһ��
	public List<News> findNewsByPubDate(Date pubDate);
	
	/*//ͨ��������ѯ
	public List<News> findNewsByRegion(String region);
	*/
	//��ѯ���죬����ɾ��֮ǰ������
	public List<News> findNewsByPubWeek(Date endPubDate);
	
	//��ѯȫ��
	public List<News> findAll();
	
	
}
