package com.esri.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.esri.dao.NewsDao;
import com.esri.entity.HistoryNews;
import com.esri.entity.News;
import com.esri.service.NewsService;
@Service
public class NewsServiceImpl implements NewsService {

	@Resource
	NewsDao nd;
	
	
	@Override
	public List<News> findNewsByTitle(String title) {
		return nd.findNewsByTitle(title);
	}

	@Override
	public List<News> findNewsByCategory(String category) {
		return nd.findNewsByCategory(category);
	}

	@Override
	public List<News> findRecentNews() {
		return nd.findRecentNews();
	}

	@Override
	public List<HistoryNews> findNewsByTime(Date now) {
		return nd.findNewsByTime(now);
	}

}
