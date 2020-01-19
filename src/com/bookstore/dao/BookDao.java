package com.bookstore.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.sql.Update;

import com.bookstore.entity.Book;
import com.bookstore.entity.Book_Order;

public class BookDao extends JpaDao<Book> implements GenericDao<Book> {

	public BookDao() {
		
		
	}
	
	public Book create(Book book)
	{
		book.setLast_update_time(new Date());
		return super.create(book);
	}
	public Book update(Book book) {
		book.setLast_update_time(new Date());
		return super.update(book);
	}
	
	public Book findByTitle(String title) {
		
		List<Book> booklist=super.findbyNamedQuery("Book.findByTitle","title",title);
		if(booklist!=null && booklist.size()>0) {
			return booklist.get(0);
		}
		return null;
		
	}
	
	public List<Book> ListByCategory(Object categoryid){
		return super.findbyNamedQuery("Book.findByCategory","categoryid",categoryid);
	}
	
	public long countByCategory(Integer id) {
		return super.count("Book.countByCategory","categoryid",id);
		
	}
	
	public  List<Book> listNewBooks(){
		return super.listNewObject("Book.listLastUpdated",0,4);
	}
	
	public List<Book> searchBooks(String keyword){
		return super.findbyNamedQuery("Book.search","keyword",keyword);
	}
	
	@Override
	public Book get(Object id) {
		return super.find(Book.class,id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Book.class,id);
		
	}
	
	public List<Object[]> mostFavouredBooks()
	{
		return super.listNewObjectGroupList("Review.mostLikedBooks",0,4);
	}
	
	public List<Book> mostFavouredBooksExtract()
	{
		List<Object[]> list=mostFavouredBooks();
		
		ArrayList<Book> booklistArrayList=new ArrayList<Book>();
		for(Object[] objects:list) {
			booklistArrayList.add((Book) objects[0]);
		}
		
		return booklistArrayList;
		
	}
	
	
	public List<Book> mostSelledBooks()
	{
		return super.listNewObject("Details.findMostSellingBook",0,4);
	}
	

	@Override
	public List<Book> listall() {
		return super.findAll("Book.findAll");
	}

	@Override
	public long count() {
		return super.count("Book.count");
	}
	
	
	
	
	

}
