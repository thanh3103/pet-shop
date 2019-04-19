package com.website.springmvc.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "petshop")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ROLE_USER = "ROLE_USER";

	private Long id;
	private String userName;
	private String passWord;
	private String email;
	private Integer phoneNo;
	private String firstName;
	private String lastName;
	private Integer age;
	private String userRole;
	private boolean active;
	private Address address;
	private List<Order> orders;
	private Set<UserRole> roles;
	private List<Product> products;

	public User() {

	}

	public User(Long id, String userName, String passWord, String email, Integer phoneNo, String firstName,
			String lastName, Integer age, String userRole, boolean active) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.phoneNo = phoneNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.userRole = userRole;
		this.active = active;
	}

	public User(Long id, String userName, String passWord, String email, Integer phoneNo, String firstName,
			String lastName, Integer age, String userRole, boolean active, Address address, List<Order> orders,
			Set<UserRole> roles, List<Product> products) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.phoneNo = phoneNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.userRole = userRole;
		this.active = active;
		this.address = address;
		this.orders = orders;
		this.roles = roles;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USERNAME", length = 50)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD", length = 50)
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name = "EMAIL", length = 30)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PHONE_NO", length = 20)
	public Integer getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "FIRST_NAME", length = 20)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", length = 20)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "AGE", length = 5)
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "USER_ROLE", length = 20, nullable = true)
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Column(name = "ACTIVE", length = 1, nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
