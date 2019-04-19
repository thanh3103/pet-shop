package com.website.springmvc.DAO;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.website.springmvc.entities.User;
import com.website.springmvc.entities.UserRole;

@Repository
@Transactional
public class UserRoleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<UserRole> getUserRoles(Long id) {
		Session session = this.sessionFactory.getCurrentSession();

		SQLQuery query = session.createSQLQuery("SELECT * FROM role WHERE user_USER_ID = :id");
		query.addEntity(UserRole.class);
		query.setParameter("id", id);
		List<UserRole> roles = query.list();

		System.out.println(roles);
		return roles;
	}
	
	public UserRole add(UserRole userRole) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(userRole);
		return userRole;
	}
}
