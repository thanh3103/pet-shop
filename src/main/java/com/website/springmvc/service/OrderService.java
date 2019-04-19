package com.website.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.springmvc.DAO.DAO;
import com.website.springmvc.DAO.OrderDAO;
import com.website.springmvc.entities.Category;
import com.website.springmvc.entities.Order;
import com.website.springmvc.entities.User;

@Transactional
@Service
public class OrderService {

	@Autowired
	OrderDAO orderDAO;

	public List<Order> getAll(Integer offset) {
		return orderDAO.getAll(offset);
	}

	public Order getById(Long id) {
		return orderDAO.getById(id);
	}
	
	public Order getByName(String name) {
		return orderDAO.getByName(name);
	}
	
	public Order add(Order order) {
		return orderDAO.add(order);
	}

	public Boolean update(Order order) {
		return orderDAO.update(order);
	}
	
	public Boolean delete(Order order) {
		return orderDAO.delete(order);
	}

	public Boolean deleteById(Long id) {
		return orderDAO.deleteById(id);
	}
	
	public List<Order> getByUser(User user) {
		return orderDAO.getByUser(user);
	}
}
