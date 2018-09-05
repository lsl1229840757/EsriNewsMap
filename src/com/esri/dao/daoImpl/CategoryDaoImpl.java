package com.esri.dao.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.esri.dao.CategoryDao;
import com.esri.entity.Category;

/**
 * 
 *ȥ�������е������ύ��session�رգ���Щȫ������spring������
 *
 */
@Component
public class CategoryDaoImpl implements CategoryDao {

	/**
	 * ������4�İ汾,����spring��װ��һ���࣬�����ṩ�˺ܶ��ݵķ���
	*/
	@Resource
	HibernateTemplate ht;
	//����ֻ����getcurrentsession����Ȼspring�Ͳ��ܹ�����
	@Resource
	SessionFactory sessionfactory;
	
	/**
	 * ��ѯȫ���������
	 */
	@Override
	public List<Category> findAll() {
		
		String hql = "from Category";
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<Category> list = query.list();
		return list;
	}

}
