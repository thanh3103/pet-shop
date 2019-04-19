package com.website.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.springmvc.DAO.CategoryDAO;
import com.website.springmvc.entities.Category;

@Transactional
@Service
public class CategoryService {

	@Autowired
	CategoryDAO categoryDAO;
	
	public List<Category> getAll() {
		return categoryDAO.getAll();
	}

	public List<Category> getAll(Integer offset) {
		return categoryDAO.getAll(offset);
	}

	public Category getById(Long id) {
		return categoryDAO.getById(id);
	}

	public Category getByName(String name) {
		return categoryDAO.getByName(name);
	}

	public Category add(Category category) {
		return categoryDAO.add(category);
	}

	public Boolean update(Category category) {
		return categoryDAO.update(category);
	}

	public Boolean delete(Category category) {
		return categoryDAO.delete(category);
	}

	public Boolean deleteById(Long id) {
		return categoryDAO.deleteById(id);
	}

	public Long count() {
		return categoryDAO.count();
	}
}
