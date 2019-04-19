package com.website.springmvc.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders", catalog = "petshop")
public class Order implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private User user;
	private Date createDate;
	private BigDecimal totalPrice;
	private List<OrderDetail> listOrderDetail = new ArrayList<OrderDetail>();

	public Order() {
	}

	public Order(Long id, User user, Date createDate, BigDecimal totalPrice, List<OrderDetail> listOrderDetail) {
		this.id = id;
		this.user = user;
		this.createDate = createDate;
		this.totalPrice = totalPrice;
		this.listOrderDetail = listOrderDetail;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ORDER_ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CREATE_DATE", length = 20)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "TOTAL_PRICE", length = 20)
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	public List<OrderDetail> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(List<OrderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
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