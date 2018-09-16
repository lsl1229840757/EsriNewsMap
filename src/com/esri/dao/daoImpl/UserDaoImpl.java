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

@Component
public class UserDaoImpl implements UserDao{

	@Resource
	HibernateTemplate ht;
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

	
	@Override
	public boolean add(User user) {
		
		String hql = "select count(*) from User as user where user.username=?";
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, user.getUsername());
		Object obj = query.uniqueResult();
		Integer res = ((Long)obj).intValue();
		if(res == 0) {
			session.persist(user);
			return true;
		}else {
			return false;
		}
	}


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
