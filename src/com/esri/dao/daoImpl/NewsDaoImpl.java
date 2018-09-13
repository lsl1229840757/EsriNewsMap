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
	public List<News> findNewsByPubDate(Date pubDate) {
		Session session = sessionfactory.getCurrentSession();
		long time = pubDate.getTime();
		// 获取1天的毫秒数
		long dayTime = 24 * 60 * 60 * 1000;
		// 当前时间毫秒数-7天的毫秒数=7天之间那天的毫秒数
		long times = time - dayTime;
		// 将毫秒数转日期
		Date beginPubDate = new Date(times);
		String hql = "from News news where news.pubDate between '"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(beginPubDate)+"'  and '"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pubDate)+"' ";
		Query query = session.createQuery(hql);
		List<News> newsList = query.list();
		return newsList;
	}

	/*@Override
	public List<News> findNewsByRegion(String region) {
		String hql = "from News where region = :region";
		Session session = SingleSession.getSession();
		Query query = session.createQuery(hql);
		query.setString("region", region);
		List<News> newsList = query.list();
		session.close();
		return newsList;
	}*/

	@Override
	public List<News> findNewsByPubWeek(Date endPubDate) {
		Session session = sessionfactory.getCurrentSession();
		System.out.println(GetTime.getStatetime(endPubDate,-7));
		String hql = "from News news where news.pubDate between '"+GetTime.getStatetime(endPubDate,-7)+"'  and '"+GetTime.getStatetime(endPubDate, 0)+"' ";
		Query query = session.createQuery(hql);
		List<News> newsList = query.list();
		return newsList;
	}

	@Override
	public List<News> findAll() {
		Session session = sessionfactory.getCurrentSession();
		String hql = "from News";
		Query query = session.createQuery(hql);
		List<News> newsList = query.list();
		return newsList;
	}

}
