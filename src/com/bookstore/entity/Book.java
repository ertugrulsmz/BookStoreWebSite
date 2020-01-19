package com.bookstore.entity;


import java.util.Base64;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
import javax.persistence.Transient;







@Entity
@Table(name = "book")
@NamedQueries({
	@NamedQuery(name="Book.findAll",query = "select b from Book b"),
	@NamedQuery(name="Book.findByTitle",query = "select b from Book b where b.title= :title"),
	@NamedQuery(name="Book.count",query = "select count (*) from Book b"),
	@NamedQuery(name="Book.findByCategory",query = "select b from Book b where b.category.category_id"
			+ "= :categoryid"),
	@NamedQuery(name="Book.countByCategory",query = "select count (b)  from Book b where b.category.category_id"
			+ "=:categoryid"),
	@NamedQuery(name = "Book.listLastUpdated",query = "select b from Book b order by b.publish_date desc"),
	@NamedQuery(name = "Book.search",query = "select b from Book b where b.title like '%' || :keyword || '%'")
})

public class Book {
	
	private Integer book_id;
    private Category category;
    private String title;
    private String author;
    private String description;
    private float price;
    private byte[] image;
    private String isbn;
    private Date publish_date;
    private Date last_update_time;
    private String base64Image;
    
    private Set<Review> reviews=new HashSet<Review>();
    private Set<Order_Details> order_details=new HashSet<Order_Details>();
  
    
    @Column(name = "author", nullable = false)
    public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "image", nullable = false)
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@Column(name = "isbn", nullable = false)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	
	@Column(name = "publish_date", nullable = false)
	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	
	@Column(name = "last_update_time", nullable = false)
	public Date getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book", targetEntity = Review.class, cascade = CascadeType.ALL)
	public Set<Review> getReviews() {
		TreeSet<Review> treeSet=new TreeSet<Review>(new Comparator<Review>() {

			@Override
			public int compare(Review o1, Review o2) {
				return o2.getReview_time().compareTo(o1.getReview_time());
			}
		});
		
		treeSet.addAll(reviews);
		
		return treeSet;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	

	public Book() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	@Transient
	public String getbase64Image()
	{
		this.base64Image= Base64.getEncoder().encodeToString(this.image);
		return this.base64Image;
	}
	
	@Transient
	public void setBase64Image(String base64Image)
	{
		this.base64Image=base64Image;
	}
 
	@Transient
	public float pointAverageofReview() {
		
		if(this.getReviews()==null || this.getReviews().size()==0) {
			return 0;
		}
		
		float total=0;
		
		for(Review review:this.getReviews()) {
			total+=review.getRating();
		}
		
		return total/this.getReviews().size();
	}
	
	@Transient
	public String arrangeStars(float pointAverage)
	{
		int ipointverage=(int) pointAverage;
		String starString="";
		
		for(int i=0;i<ipointverage;i++) {
			starString+="on,";
		}
		
		int next=ipointverage;
		
		if(pointAverage>ipointverage) {
			starString+="half,";
			next++;
		}
		
		for(int i=next;i<5;i++) {
			starString+="of,";
		}
		
		return starString.substring(0,starString.length()-1);
	}
	
	@Transient
	public String getRatingstars() {
		float value=pointAverageofReview();
		return arrangeStars(value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book_id == null) ? 0 : book_id.hashCode());
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
		Book other = (Book) obj;
		if (book_id == null) {
			if (other.book_id != null)
				return false;
		} else if (!book_id.equals(other.book_id))
			return false;
		return true;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book", targetEntity = Order_Details.class, cascade = CascadeType.ALL)
	public Set<Order_Details> getOrder_details() {
		return order_details;
	}

	public void setOrder_details(Set<Order_Details> order_details) {
		this.order_details = order_details;
	}
 
	
   

}



