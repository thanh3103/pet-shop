package com.website.springmvc.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products", catalog = "petshop")
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String productName;
	private BigDecimal price;
	private Integer unitInStock;
	private String description;
	private byte[] images;
	private String base64ImageFile;
	private Category category;
	private User user;

	public Product() {
	}

	public Product(Long id, String productName, BigDecimal price, Integer unitInStock, String description,
			byte[] images, String base64ImageFile, Category category, User user) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.unitInStock = unitInStock;
		this.description = description;
		this.images = images;
		this.base64ImageFile = base64ImageFile;
		this.category = category;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PRODUCT_ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "PRODUCT_NAME", length = 20)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "PRICE", length = 20)
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "UNIT_INSTOCK", length = 10)
	public Integer getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(Integer unitInStock) {
		this.unitInStock = unitInStock;
	}

	@Column(name = "DESCRIPTION", length = 20)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "IMAGES", nullable = false, length = Integer.MAX_VALUE)
	public byte[] getImages() {
		return images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "base64", nullable = false, length = Integer.MAX_VALUE)
	public String getBase64ImageFile() {
		return base64ImageFile;
	}

	public void setBase64ImageFile(String base64ImageFile) {
		this.base64ImageFile = base64ImageFile;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
