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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "book_order")

@NamedQueries({
	@NamedQuery(name = "Bookorder.findall",query = "select b from Book_Order b"),
	@NamedQuery(name = "Bookorder.countall",query = "select count(*)  from Book_Order b"),
	@NamedQuery(name = "Bookorder.findallByDate",query = "select b from Book_Order b order by b.order_date desc"),
	@NamedQuery(name = "Bookorder.findByCustomer",query = "select b from Book_Order b where b.customer.idString = "
			+ ":id"),
	@NamedQuery(name = "Bookorder.findByIdAndCustomer",query = "select b from Book_Order b where "
			+ "b.order_id = :orderid and b.customer.idString = :customerid")
})

public class Book_Order {
	private Integer order_id;
	private Customer_class customer;
	private Date order_date;
	private String shipping_address;
	private String recipient_name;
	private String recipient_phone;
	private String payment_method;
	private float total;
	private String status;
	private Set<Order_Details> order_details=new HashSet<Order_Details>();
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	public Customer_class getCustomer() {
		return customer;
	}
	public void setCustomer(Customer_class customer) {
		this.customer = customer;
	}
	
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	
	public String getRecipient_name() {
		return recipient_name;
	}
	public void setRecipient_name(String recipient_name) {
		this.recipient_name = recipient_name;
	}
	
	public String getRecipient_phone() {
		return recipient_phone;
	}
	public void setRecipient_phone(String recipient_phone) {
		this.recipient_phone = recipient_phone;
	}
	
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book_Order other = (Book_Order) obj;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		return true;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book_Order", targetEntity = Order_Details.class, cascade = CascadeType.ALL)
	public Set<Order_Details> getOrder_details() {
		return order_details;
	}
	public void setOrder_details(Set<Order_Details> order_details) {
		this.order_details = order_details;
	}
	
	

}
