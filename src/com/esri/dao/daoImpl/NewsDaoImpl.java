package com.esri.dao.daoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.esri.dao.NewsDao;
import com.esri.entity.HistoryNews;
import com.esri.entity.News;
import com.esri.util.CalenderTools;
import com.esri.util.GetTime;

@Component
public class NewsDaoImpl implements NewsDao {


	@Resource
	HibernateTemplate ht;
	@Resource
	SessionFactory sessionfactory;
	
	@Override
	public List<News> findNewsByTitle(String title) {
		String hql = "from News where title like :title";
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString("title", "%"+title+"%");
		List<News> newsList = query.list();
		return newsList;
	}

	@Override
	public List<News> findNewsByCategory(String category) {
		String hql = "from News where category = :category";
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString("category", category);
		List<News> newsList = query.list();
		return newsList;
	}

	@Override
	public List<News> findRecentNews() {
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery("from News where 1 = 1");
		List<News> newsList = query.list();
		return newsList;
	}
	
	public int findRecentNewsCount(Date now) {
		Session currentSession = sessionfactory.getCurrentSession();
		String hql = "select count(h.id) from News h";
		Query query = currentSession.createQuery(hql);
		return ((Number) query.uniqueResult()).intValue();
	}

	@Override
	public List<HistoryNews> findHistoryNewsByTime(Date now) {
		Session currentSession = sessionfactory.getCurrentSession();
		String hql = "from HistoryNews news where news.pubDate between "+CalenderTools.getNowDay(now)+" and "+ CalenderTools.getTomorrow(now);
		Query query = currentSession.createQuery(hql);
		List<HistoryNews> list = query.list();
		return list;
	}

	@Override
	public int findHistoryNewsCountByTime(Date now) {
		Session currentSession = sessionfactory.getCurrentSession();
		String hql = "select count(h.id) from HistoryNews h where h.pubDate between "+CalenderTools.getNowDay(now)+" and "+ CalenderTools.getTomorrow(now);
		Query query = currentSession.createQuery(hql);
		return ((Number) query.uniqueResult()).intValue();
	}

}
