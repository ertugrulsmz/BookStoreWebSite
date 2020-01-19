package com.bookstore.test.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.dao.BookOrderDao;
import com.bookstore.dao.CustomerDao;
import com.bookstore.entity.Book_Order;
import com.bookstore.entity.Customer_class;



public class BookOrderTest {
	
	private static BookOrderDao bookorderdao;
	private static CustomerDao customerdao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookorderdao=new BookOrderDao();
		customerdao=new CustomerDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void Createtest() {
		Customer_class customer_class=customerdao.get(11);
		Book_Order book_Order=new Book_Order();
		book_Order.setCustomer(customer_class);
		book_Order.setPayment_method("direct");
		book_Order.setRecipient_name("ali");
		book_Order.setRecipient_phone("212");
		book_Order.setShipping_address("esenyali");
		book_Order.setStatus("ok");
		book_Order.setTotal(12);
		
		Book_Order booksaved=bookorderdao.create(book_Order);
		assertNotNull(booksaved);
	}
	
	@Test
	public void getTest()
	{
		Book_Order book_Order=bookorderdao.get(23);
		assertTrue(book_Order.getStatus().equals("ok"));
	}
	
	@Test
	public void findByCustomer()
	{
		java.util.List<Book_Order> list=bookorderdao.findByCustomer(11);
		System.out.println(list.get(0).getRecipient_name());
		assertTrue(list!=null);
		
	}
	
	@Test
	public void findByIdandCustomer()
	{
		int customer_id=11;
		int order_id=23;
		Book_Order book_Order=bookorderdao.findByCustomerandId(order_id,customer_id);
		System.out.println(book_Order.getRecipient_name());
		assertTrue(true);
	}
	
	
}
