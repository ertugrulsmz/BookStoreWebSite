package com.bookstore.entity;

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
@Table(name = "category")
@NamedQueries({
	@NamedQuery(name="Category.findall",query = "select u from Category u ORDER BY u.name"),
	@NamedQuery(name="Category.countall",query = "select count (*) from Category u"),
	
})

public class Category {
	private String name;
	private Integer category_id;
	private Set<Book> books = new HashSet<Book>();
	
	public Category() {
		
	}
	
	public Category(String name) {
		this.name=name;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", targetEntity = Book.class, cascade = CascadeType.ALL)
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
	
	

}





