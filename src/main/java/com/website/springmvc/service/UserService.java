package com.website.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.springmvc.DAO.DAO;
import com.website.springmvc.DAO.UserDAO;
import com.website.springmvc.entities.Product;
import com.website.springmvc.entities.User;

@Transactional
@Service
public class UserService {

	@Autowired
	UserDAO userDAO;

	public List<User> getAll(Integer offset) {
		return userDAO.getAll(offset);
	}

	public User getById(Long id) {
		return userDAO.getById(id);
	}

	public User getByName(String name) {
		return userDAO.getByName(name);
	}

	public User add(User user) {
		return userDAO.add(user);
	}

	public Boolean update(User user) {
		return userDAO.update(user);
	}

	public Boolean delete(User user) {
		return userDAO.delete(user);
	}

	public Boolean deleteById(Long id) {
		return userDAO.deleteById(id);
	}

	public Boolean login(String userName, String passWord) {
		return userDAO.login(userName, passWord);
	}

	public Boolean validateEmail(String userEmail) {
		return userDAO.validateEmail(userEmail);
	}
	
	public Boolean validateUser(String userName) {
		return userDAO.validateUser(userName);
	}

	public User getUserByUserName(String userName) {
		return userDAO.getUserByUserName(userName);
	}

	public Long count() {
		return userDAO.count();
	}
	
	public User getUserByProduct(Product product) {
		return userDAO.getUserByProduct(product);
	}

	public List<User> getAllUser(Integer offset, Integer limit) {
		return userDAO.getAllUser(offset, limit);
	}
}
