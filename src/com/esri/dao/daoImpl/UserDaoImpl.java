package com.esri.dao.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.esri.dao.UserDao;
import com.esri.entity.User;

/**
 * 
 *去掉了所有的事务提交和session关闭，这些全部交给spring来管理
 *
 */
@Component
public class UserDaoImpl implements UserDao{

	
	
	
	
	/**
	 * 这里用4的版本,这是spring封装的一个类，里面提供了很多快捷的方法
	*/
	@Resource
	HibernateTemplate ht;
	//这里只能用getcurrentsession，不然spring就不能够管理
	@Resource
	SessionFactory sessionfactory;
	
	
	@Override
	public User findUserByUserName(String username) {
		String hql = "from User where username = :username";
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString("username", username);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	public List<User> findAll() {
		String hql = "from User";
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<User> userList = query.list();
		return userList;
	}

	/**
	 * false:表示该用户名已经被注册
	 * true:表示注册成功
	 */
	@Override
	public boolean add(User user) {
		
		String hql = "select count(*) from User as user where user.username=?";
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, user.getUsername());
		Object obj = query.uniqueResult();
		Integer res = ((Long)obj).intValue();
		if(res == 0) {
			//插入操作
			session.persist(user);
			System.out.println("插入成功!");
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 用于判断是否有此用户
	 */
	@Override
	public boolean findLogin(User user) {
		String hql = "select count(*) from User as user where user.username=? and user.password=?";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, user.getUsername());
		query.setParameter(1, user.getPassword());
		Object obj = query.uniqueResult();
		Integer res = ((Long)obj).intValue();
		
		if(res == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean update(User user) {
		Session session = sessionfactory.getCurrentSession();
		try {
			session.update(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
