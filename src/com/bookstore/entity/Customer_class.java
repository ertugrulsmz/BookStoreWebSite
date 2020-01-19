package com.bookstore.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")

@NamedQueries({
	@NamedQuery(name="Customer.listall",query = "select c from Customer_class c order by c.registerdateString desc"),
	@NamedQuery(name="Customer.countall",query = "select count (c)  from Customer_class c "),
	@NamedQuery(name="Customer.findByEmail",query = "select c from Customer_class c where c.emailString = :email "),
	@NamedQuery(name="Customer.findByLogin",query = "select c from Customer_class c where c.emailString = :email "
			+ " and c.passwordString = :password")
})


public class Customer_class {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Integer idString;
	
	@Column(name="email")
	private String emailString;
	
	@Column(name="fullname")
	private String fullnameString;
	
	@Column(name="address")
	private String addressString;
	
	@Column(name="city")
	private String cityString;
	
	@Column(name="country")
	private String countryString;
	
	@Column(name="phone")
	private String phoneString;
	
	@Column(name="zipcode")
	private String zipcodeString;
	
	@Column(name="password")
	private String passwordString;
	
	@Column(name="register_date")
	private Date registerdateString;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "customer",cascade = CascadeType.ALL,targetEntity = Book_Order.class)
	private Set<Book_Order> bookorders=new HashSet<Book_Order>();
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "customer_class",cascade = CascadeType.ALL,targetEntity = Review.class)
	private Set<Review> review=new HashSet<Review>();
	
	
	
	public Set<Review> getReview() {
		return review;
	}

	public void setReview(Set<Review> review) {
		this.review = review;
	}

	public Set<Book_Order> getBookorders() {
		return bookorders;
	}

	public void setBookorders(Set<Book_Order> bookorders) {
		this.bookorders = bookorders;
	}

	public Customer_class() {}

	public Integer getIdString() {
		return idString;
	}

	public void setIdString(Integer idString) {
		this.idString = idString;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public String getFullnameString() {
		return fullnameString;
	}

	public void setFullnameString(String fullnameString) {
		this.fullnameString = fullnameString;
	}

	public String getAddressString() {
		return addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}

	public String getCityString() {
		return cityString;
	}

	public void setCityString(String cityString) {
		this.cityString = cityString;
	}

	public String getCountryString() {
		return countryString;
	}

	public void setCountryString(String countryString) {
		this.countryString = countryString;
	}

	public String getPhoneString() {
		return phoneString;
	}

	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}

	public String getZipcodeString() {
		return zipcodeString;
	}

	public void setZipcodeString(String zipcodeString) {
		this.zipcodeString = zipcodeString;
	}

	public String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}

	public Date getRegisterdateString() {
		return registerdateString;
	}

	public void setRegisterdateString(Date registerdateString) {
		this.registerdateString = registerdateString;
	}
	
	

}
