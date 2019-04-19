package com.website.springmvc.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.website.springmvc.entities.OrderDetail;

@Repository
public class OrderDetailDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public OrderDetail add(OrderDetail orderDetail) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(orderDetail);
		return orderDetail;
	}
}
