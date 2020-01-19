package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Order_Details;

public class OrderDetailsDao extends JpaDao<Order_Details> implements GenericDao<Order_Details>{

	
	@Override
	public Order_Details get(Object id) {
		return super.find(Order_Details.class,id);
	}

	@Override
	public void delete(Object id) {
		super.find(Order_Details.class,id);	
	}
	
	public List<Order_Details> findByOrder(Object id)
	{
		return super.findbyNamedQuery("Details.findByOrder","id",id);
	}
	

	@Override
	public List<Order_Details> listall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
