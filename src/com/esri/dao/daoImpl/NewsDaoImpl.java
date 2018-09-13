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
 *ȥ�������е������ύ��session�رգ���Щȫ������spring������
 *
 */
@Component
public class NewsDaoImpl implements NewsDao {


	/**
	 * ������4�İ汾,����spring��װ��һ���࣬�����ṩ�˺ܶ��ݵķ���
	*/
	@Resource
	HibernateTemplate ht;
	//����ֻ����getcurrentsession����Ȼspring�Ͳ��ܹ�����
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
		// ��ȡ1��ĺ�����
		long dayTime = 24 * 60 * 60 * 1000;
		// ��ǰʱ�������-7��ĺ�����=7��֮������ĺ�����
		long times = time - dayTime;
		// ��������ת����
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
