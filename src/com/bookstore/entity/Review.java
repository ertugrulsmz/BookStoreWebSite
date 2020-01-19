package com.bookstore.entity;

import java.util.Date;

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
import javax.persistence.Table;
import javax.persistence.Transient;

@NamedQueries({
	@NamedQuery(name = "Review.findAll",query = "select r from Review r order by r.review_time desc "),
	@NamedQuery(name = "Review.countAll",query = "select count (*) from Review r"),
	
	@NamedQuery(name = "Review.mostLikedBooks",query = "SELECT r.book, COUNT(r.book.book_id) as Reviewcounter ,"
			+ " AVG(r.rating) as Avgrating  from Review r GROUP BY r.book.book_id HAVING AVG(r.rating) >= 4 "
			+ "ORDER BY Reviewcounter desc, Avgrating desc")
		
})

@Entity
@Table(name = "review")
public class Review {
	private Integer review_id;
	private Customer_class customer_class;
	private Book book;
	Integer rating;
	String headline;
	String comment;
	Date review_time;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
	public Integer getReview_id() {
		return review_id;
	}
	public void setReview_id(Integer review_id) {
		this.review_id = review_id;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	public Customer_class getCustomer_class() {
		return customer_class;
	}
	public void setCustomer_class(Customer_class customer_class) {
		this.customer_class = customer_class;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getReview_time() {
		return review_time;
	}
	public void setReview_time(Date review_time) {
		this.review_time = review_time;
	}
	
	@Transient
	public String getStarString()
	{
		String starString="";
		
		for(int i=0;i<rating;i++) {
			starString+="on,";
		}
		
		for(int i=rating;i<5;i++) {
			starString+="of,";
		}
		
		return starString.substring(0,starString.length()-1);
	}
	


}
