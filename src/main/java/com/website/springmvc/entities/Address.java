package com.website.springmvc.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "address", catalog = "petshop")
public class Address implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer number;
	private String street;
	private String district;
	private String city;
	private String province;
	
	public Address() {}

	public Address(Integer number, String street, String district, String city, String province) {
		this.number = number;
		this.street = street;
		this.district = district;
		this.city = city;
		this.province = province;
	}
	
	@Id
	@GeneratedValue (strategy = IDENTITY)
	@Column (name = "ADDRESS_ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column (name = "NUMBER", length = 10)
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	@Column (name = "STREET", length = 20)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column (name = "DISTRICT", length = 10)
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
	@Column (name = "CITY", length = 20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Column (name = "PROVINCE", length = 20)
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	
}
