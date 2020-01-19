package com.bookstore.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.dao.CustomerDao;
import com.bookstore.entity.Book_Order;
import com.bookstore.entity.Customer_class;


public class CustomerTest {
	
	private static CustomerDao customerdao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerdao=new CustomerDao();
	}

	@Test
	public void createTest() {
		Customer_class customer=new Customer_class();
		customer.setAddressString("Guzelyali mah.");
		customer.setCityString("Istanbul");
		customer.setCountryString("Turkiye");
		customer.setEmailString("customer@gmail.com");
		customer.setFullnameString("Sinan");
		customer.setPasswordString("sinan23");
		customer.setPhoneString("5359266963");
		customer.setZipcodeString("34903");
		
		customerdao.create(customer);
		assertTrue(customer.getIdString()>0);
	}
	
	@Test
	public void updateTest() {
		Customer_class customer_class=customerdao.get(22);
		customer_class.setFullnameString("Ertugrul");
		Customer_class customer_class2=customerdao.update(customer_class);
		assertTrue(customer_class2!=null && customer_class2.getFullnameString().equals("Ertugrul"));
	}
	
	@Test
	public void findTest() {
		Customer_class customer_class=customerdao.get(22);
		assertTrue(customer_class!=null);
		
	}
	
	@Test
	public void countAllTest() {
		long counter=customerdao.count();
		assertTrue(counter==4);
	}
	
	@Test
	public void listAllTest() {
		List<Customer_class> listofcustomers=customerdao.listall();
		
		assertTrue(listofcustomers.size()==4);
	}
	
	@Test
	public void findByEmailTest() {
		Customer_class customer_class=customerdao.findByEmail("customer@gmail.com");
		assertTrue(customer_class!=null && customer_class.getFullnameString().equals("Ertugrul"));
	}
	
	@Test
	public void LoginTest() {
		Customer_class customer_class=customerdao.login_condition("ertugrulsmz55@gmail.com","ertuqrul138");
		assertTrue(customer_class!=null);
	}
	
	@Test
	public void  reachCustomer() {
		Customer_class customer_class=customerdao.get(11);
			
		for(Book_Order book_Order : customer_class.getBookorders())
		{
			System.out.println(book_Order.getRecipient_name());
		}
		assertTrue(true);
	}
	
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
