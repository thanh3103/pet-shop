package com.website.springmvc.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.website.springmvc.entities.Product;
import com.website.springmvc.entities.User;

@Repository
@Transactional
public class UserDAO extends DAO<User> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getAll(Integer offset) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		query.setFirstResult(offset);
		query.setMaxResults(10);

		List<User> users = query.list();
		return users;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser(Integer offset, Integer limit) {
		Session session = this.sessionFactory.getCurrentSession();

		List<User> listUser = session.createCriteria(User.class).setFirstResult(offset != null ? offset : 0)
				.setMaxResults(limit != null ? limit : 10).list();

		return listUser;
	}


	@Override
	public User getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("select U from User as U where id = :id");
		query.setParameter("id", id);
		User user = (User) query.uniqueResult();

		return user;
	}

	@Override
	public User getByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("select U from User as U where userName = :name");
		query.setParameter("name", name);
		User user = (User) query.uniqueResult();

		return user;
	}

	@Override
	public User add(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}

	@Override
	public Boolean update(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(user);
			return Boolean.TRUE;
		} catch (Exception ex) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean delete(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.delete(user);
			return Boolean.TRUE;
		} catch (Exception ex) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean deleteById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("select U from User as U where id = :id");
		query.setParameter("id", id);
		User user = (User) query.uniqueResult();

		try {
			session.delete(user);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	// Check Đăng Nhập
	public Boolean login(String userName, String passWord) {
		Session session = this.sessionFactory.getCurrentSession();

		SQLQuery query = session
				.createSQLQuery("SELECT * FROM USER WHERE USERNAME = :userName AND PASSWORD = :passWord");
		query.addEntity(User.class);
		query.setParameter("userName", userName);
		query.setParameter("passWord", passWord);
		User user = (User) query.uniqueResult();

		if (user != null) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	// Check Email đã đăng ký hay chưa
	public Boolean validateEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("from User where email = :email");
		query.setParameter("email", email);
		User user = (User) query.uniqueResult();

		if (user == null) {
			return Boolean.TRUE; // email chưa được đăng ký
		} else {
			return Boolean.FALSE; // email đã được đăng ký
		}
	}
	
	// Check username đã đăng ký hay chưa
		public Boolean validateUser(String userName) {
			Session session = this.sessionFactory.getCurrentSession();

			Query query = session.createQuery("from User where userName = :userName");
			query.setParameter("userName", userName);
			User user = (User) query.uniqueResult();

			if (user == null) {
				return Boolean.TRUE; 
			} else {
				return Boolean.FALSE; 
			}
		}

	public User getUserByUserName(String userName) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("select U from User as U where userName like :userName");
		query.setParameter("userName", userName);

		User user = (User) query.uniqueResult();
		return user;
	}
	
	public Long count() {
		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(User.class);
		criteria.setProjection(Projections.rowCount());

		Long rowCount = (Long) criteria.uniqueResult();
		return rowCount;
	}
	
	public User getUserByProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select U from User as U where Product =:product");
		query.setParameter("product", product);
		
		User user = (User) query.uniqueResult();
		return user;
	}
}
