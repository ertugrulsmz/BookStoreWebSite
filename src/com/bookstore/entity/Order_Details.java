package com.bookstore.entity;



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

@Entity
@Table(name = "order_detail")
@NamedQueries({
	@NamedQuery(name = "Details.findByOrder",query = "select details from Order_Details details where details.book_Order.order_id = "
			+ ":id"),
	@NamedQuery(name = "Details.findMostSellingBook",query = "select detail.book from Order_Details detail group by detail."
			+ ""
			+ "book.book_id order by sum(detail.quantity) desc")
})


public class Order_Details {
	
	
	private Book_Order book_Order;
	private Book book;
	private Integer quantity;
	private Float subtotal;
	private Integer id;
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	public Book_Order getBook_Order() {
		return book_Order;
	}
	public void setBook_Order(Book_Order book_Order) {
		this.book_Order = book_Order;
	}
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((book_Order == null) ? 0 : book_Order.hashCode());
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
		Order_Details other = (Order_Details) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (book_Order == null) {
			if (other.book_Order != null)
				return false;
		} else if (!book_Order.equals(other.book_Order))
			return false;
		return true;
	}
	
	

}
