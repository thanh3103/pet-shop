package com.website.springmvc.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.springmvc.entities.Category;
import com.website.springmvc.entities.Order;
import com.website.springmvc.entities.Product;
import com.website.springmvc.entities.User;

@Repository
public class OrderDAO extends DAO<Order> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Order> getAll(Integer offset) {
		Session session = this.sessionFactory.getCurrentSession();

		List<Order> orders = session.createQuery("from Order").list();

		return orders;
	}

	@Override
	public Order getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("select O from Order as O where id = :id");
		query.setParameter("id", id);
		Order order = (Order) query.uniqueResult();

		return order;
	}

	@Override
	public Order getByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		UserDAO userDAO = new UserDAO();

		Query query = session.createQuery("select O from Order as O where user = :name");
		query.setParameter("name", userDAO.getByName(name));
		Order order = (Order) query.uniqueResult();

		return order;
	}

	@Override
	public Order add(Order order) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(order);
		return order;
	}

	@Override
	public Boolean update(Order order) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(order);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean delete(Order order) {
		Session session = this.sessionFactory.getCurrentSession();

		try {
			session.delete(order);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean deleteById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("select O from Order as O where id = :id");
		query.setParameter("id", id);
		Order order = (Order) query.uniqueResult();

		try {
			session.delete(order);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	public List<Order> getByUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("select O from Order as O where user = :user");
		query.setParameter("user", user);
		List<Order> orders = query.list();
		return orders;
	}
	
	public Integer countProductInCart(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		Integer count = 0;
		
		
		return count;
	}
}
