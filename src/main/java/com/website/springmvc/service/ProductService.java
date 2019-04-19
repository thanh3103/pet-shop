package com.website.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.springmvc.DAO.DAO;
import com.website.springmvc.DAO.ProductDAO;
import com.website.springmvc.entities.Category;
import com.website.springmvc.entities.Product;

@Transactional
@Service
public class ProductService {
	
//	@Autowired
//	DAO<Product> productDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	public List<Product> getAll(Integer offset){
		return productDAO.getAll(offset);
	}
	
	public Product getById(Long id) {
		return productDAO.getById(id);
	}
	
	public Product getByName(String name) {
		return productDAO.getByName(name);
	}
	
	public Product add(Product product) {
		return productDAO.add(product);
	}
	
	public Boolean update(Product product) {
		return productDAO.update(product);
	}
	
	public Boolean delete(Product product) {
		return productDAO.delete(product);
	}
	
	public Boolean deleteById(Long id) {
		return productDAO.deleteById(id);
	}
	
	public List<Product> getList(Long id){
		return productDAO.getList(id);
	}
	
	public List<Product> getProductListByLocation(String location) {
		return productDAO.getProductListByLocation(location);
	}

	public Long count() {
		return productDAO.count();
	}
	
	public List<Product> getProductSearchCriteria(String search, Long id) {
		return productDAO.getProductSearchCriteria(search, id);
	}
	
	public List<Product> getByCategory(Category category, Integer offset) {
		return productDAO.getByCategory(category, offset);
	}
}
