package com.website.springmvc.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "category", catalog = "petshop")
public class Category implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String categoryName;
	private Set<Product> products = new HashSet<Product>();
	
	public Category() {}

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Id
	@GeneratedValue (strategy = IDENTITY)
	@Column (name = "CATEGORY_ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column (name = "CATEGORY_NAME", length = 20)
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}
