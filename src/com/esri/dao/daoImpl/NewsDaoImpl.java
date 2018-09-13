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
import com.esri.util.GetTime;

/**
 * 
 *去掉了所有的事务提交和session关闭，这些全部交给spring来管理
 *
 */
@Component
public class NewsDaoImpl implements NewsDao {


	/**
	 * 这里用4的版本,这是spring封装的一个类，里面提供了很多快捷的方法
	*/
	@Resource
	HibernateTemplate ht;
	//这里只能用getcurrentsession，不然spring就不能够管理
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

	@Override
	public List<HistoryNews> findNewsByTime(Date now) {
		Session currentSession = sessionfactory.getCurrentSession();
		String hql = "from News news where news.pubDate between '"+GetTime.getStatetime(now,-7)+"'  and '"+GetTime.getStatetime(now, 0)+"' ";
		Query query = currentSession.createQuery(hql);
		List<HistoryNews> list = query.list();
		return list;
	}

}
