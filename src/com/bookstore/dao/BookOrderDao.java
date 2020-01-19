package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Book;
import com.bookstore.entity.Book_Order;



public class BookOrderDao extends JpaDao<Book_Order> implements GenericDao<Book_Order>{
	
	@Override
	public Book_Order create(Book_Order book_Order) {
		book_Order.setOrder_date(new Date());
		return super.create(book_Order);
	}
	
	
	@Override
	public Book_Order get(Object id) {
		return super.find(Book_Order.class,id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Book_Order.class,id);
		
	}

	@Override
	public List<Book_Order> listall() {
		return super.findAll( "Bookorder.findall");
	}
	
	public List<Book_Order> findByCustomer(Object id) {
		List<Book_Order> list=super.findbyNamedQuery("Bookorder.findByCustomer","id",id);
		return list;
	}

	public Book_Order findByCustomerandId(Object orderid,Object customerid)
	{
		Map<String,Object> parameterMap=new HashMap<String,Object>();
		parameterMap.put("orderid",orderid);
		parameterMap.put("customerid",customerid);
		
		return super.findsinglebyNamedQuery("Bookorder.findByIdAndCustomer",parameterMap);
	}
	
	public List<Book_Order> lastSales()
	{
		return super.listNewObject("Bookorder.findallByDate",0,3);
	}
	
	
	
	@Override
	public long count() {
		return super.count("Bookorder.countall");
	}
	
	
	
	

}
