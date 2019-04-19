package com.website.springmvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "role", catalog = "petshop")
public class UserRole implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String roleName;
	private User user;
	
	public UserRole() {}

	public UserRole(String roleName) {
		this.roleName = roleName;
	}
	
	@Id
	@GeneratedValue (strategy = IDENTITY)
	@Column (name = "ROLE_ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column (name = "ROLE_NAME", length = 20)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@ManyToOne (fetch = FetchType.LAZY)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
