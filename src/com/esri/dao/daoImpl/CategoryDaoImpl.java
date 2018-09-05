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
 *去掉了所有的事务提交和session关闭，这些全部交给spring来管理
 *
 */
@Component
public class CategoryDaoImpl implements CategoryDao {

	/**
	 * 这里用4的版本,这是spring封装的一个类，里面提供了很多快捷的方法
	*/
	@Resource
	HibernateTemplate ht;
	//这里只能用getcurrentsession，不然spring就不能够管理
	@Resource
	SessionFactory sessionfactory;
	
	/**
	 * 查询全部类别数据
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
