package com.bookstore.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.bookstore.entity.Customer_class;

public class CustomerDao extends JpaDao<Customer_class> implements GenericDao<Customer_class> {
	
	
	public Customer_class create(Customer_class customer)
	{
		customer.setRegisterdateString(new Date());
		return super.create(customer);
	}
	
	public Customer_class update (Customer_class customer)
	{
		return super.update(customer);
	}
	
	
	@Override
	public Customer_class get(Object id) {
		return super.find(Customer_class.class,id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Customer_class.class,id);
		
	}

	@Override
	public List<Customer_class> listall() {
		return super.findAll("Customer.listall");
	}

	@Override
	public long count() {
		return super.count("Customer.countall");
	}

	public Customer_class findByEmail(String email){
		List<Customer_class> listofcustomers=findbyNamedQuery("Customer.findByEmail","email",email);
		if(listofcustomers!=null && listofcustomers.size()>0) {
			return listofcustomers.get(0);
		}
		return null;
	}
	
	public Customer_class login_condition(String email,String passwordString) {
		Map<String,Object> loginmap=new HashMap<String,Object>();
		loginmap.put("email",email);
		loginmap.put("password",passwordString);
		List<Customer_class> customerlist=super.findbyNamedQuery("Customer.findByLogin",loginmap);
		
		if(customerlist!=null && customerlist.size()>0) {
			return customerlist.get(0);
		}
		return null;
	}
	
	
	
	
	
}
