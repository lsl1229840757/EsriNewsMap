package com.esri.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.esri.dao.NewsDao;
import com.esri.entity.HistoryNews;
import com.esri.entity.News;
import com.esri.service.NewsService;
import com.esri.util.CalenderTools;
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
	public List<HistoryNews> findHistoryNewsByTime(Date now) {
		return nd.findHistoryNewsByTime(now);
	}

	@Override
	public int findHistoryNewsCountByTime(Date now) {
		return nd.findHistoryNewsCountByTime(now);
	}

	@Override
	public int findRecentNewsCount(Date now) {
		return nd.findRecentNewsCount(now);
	}

	@Override
	public JSONArray statistics() {
		/**
		 * 生成10天的日期
		 */
		Date now = new Date();
		long yesterDay = CalenderTools.getYesterDay(now);
		now = new Date(yesterDay * 1000);
		JSONArray ja = new JSONArray();
		for (int i = 0; i < 10; i++) {
			JSONObject jb = new JSONObject();
			String time = new SimpleDateFormat("yyyy-MM-dd").format(now);
			int value = nd.findHistoryNewsCountByTime(now);
			jb.put(time, value);
			ja.put(jb);
			yesterDay = CalenderTools.getYesterDay(now);
			now = new Date(yesterDay*1000);
		}
		return ja;
	}
}
