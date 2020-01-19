package com.bookstore.test.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.controller.admin.cart.Cart;
import com.bookstore.dao.BookDao;
import com.bookstore.dao.OrderDetailsDao;
import com.bookstore.entity.Book;

public class CartTest {

	private static Cart cart=new Cart();
	private static BookDao bookdao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		bookdao=new BookDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void AddBook() {
		Book book=new Book();
		book.setPrice(12);
		cart.addBook(book);
		cart.addBook(book);

		assertTrue(cart.getValue(book)==2);
	}
	
	@Test
	public void countTotalElement() {
		Book book=new Book();
		book.setPrice(12);
		Book book2=new Book();
		book.setPrice(15);
		cart.addBook(book);
		cart.addBook(book);
		cart.addBook(book);
		cart.addBook(book2);

		assertTrue(cart.totalNumberofElements()==2);
	}
	
	@Test
	public void addTestFromDataBase() {
		Book book=bookdao.get(140);
		cart.addBook(book);
		Book book2=bookdao.get(140);
		cart.addBook(book2);
		Book book3=bookdao.get(140);
		cart.addBook(book3);
		
		assertTrue(cart.totalNumberofElements()==3); //3 elements assert is true
		
	}
	
	@Test
	public void addNormalTest() {
		Book book=bookdao.get(140);
		cart.addBook(book);
		Book book2=book;
		cart.addBook(book2);
		Book book3=book;
		cart.addBook(book3);
		
		assertTrue(cart.totalNumberofElements()==1); // 1 element assert is true
	}
	
	@Test
	public void addTest3() {
		Book book=new Book();
		book.setTitle("a");
		
		Book book2=new Book();
		book2.setTitle("a");
		
		Book book3=new Book();
		book3.setTitle("a");
		
		cart.addBook(book);
		cart.addBook(book2);
		cart.addBook(book3);
		assertTrue(cart.totalNumberofElements()==3); // 3 element assert is true
	}
	
	@Test
	public void addTest()
	{
		Book book=new Book();
		book.setBook_id(1);
		
		Book book2=new Book();
		book2.setBook_id(1);
		
		cart.addBook(book);
		cart.addBook(book2);
		
		assertTrue(cart.totalNumberofElements()==1); // 3 element assert is true
		
	}
	
	@Test
	public void bookCounterTest()
	{
		Book book=new Book();
		book.setBook_id(1);
		
		Book book2=new Book();
		book2.setBook_id(1);
		
		cart.addBook(book);
		cart.addBook(book2);
		
		assertTrue(cart.totalNumberofBooks()==2); // 3 element assert is true
		
	}
	
	
	
	
	
	
}
