package com.bookstore.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookOrderDao;
import com.bookstore.dao.OrderDetailsDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.Book_Order;
import com.bookstore.entity.Order_Details;


public class Orderdetailstest {
	
	private static OrderDetailsDao orderDetailsDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		orderDetailsDao=new OrderDetailsDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void Createtest() {
		Order_Details order_Details=new Order_Details();
		Book_Order book_Order=new BookOrderDao().get(23);
		order_Details.setBook_Order(book_Order);
		Book book=new BookDao().get(140);
		order_Details.setBook(book);
		order_Details.setQuantity(2);
		order_Details.setSubtotal(20f);
		Order_Details saveDetails=orderDetailsDao.create(order_Details);
		assertTrue(saveDetails!=null && saveDetails.getId()>0);
	}
	
	@Test
	public void findByOrder()
	{
		List<Order_Details> list=orderDetailsDao.findByOrder(24);
		System.out.println(list.size());
		for(Order_Details o:list) {
			System.out.println(o.getSubtotal());
		}
		assertTrue(true);
	}
	
}
