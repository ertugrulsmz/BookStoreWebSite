package com.bookstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.bookstore.entity.Users;

public class UserDao extends JpaDao<Users> implements GenericDao<Users> {
	
	public UserDao() {
		
		
	}
	
	public Users create(Users user) {
		
		return super.create(user);
	}

	@Override
	public Users update(Users user) {
		// TODO Auto-generated method stub
		return super.update(user);
	}

	@Override
	public Users get(Object id) {
		return super.find(Users.class,id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Users.class,id);
		
	}

	@Override
	public List<Users> listall() {
		return super.findAll("Users.findall");
	}

	@Override
	public long count() {
		return super.count("Users.countall");
	}
	
	public Users findByEmail(String email) {
	
		List<Users> listofUsers=super.findbyNamedQuery("Users.findbyemail","email",email);
		if(listofUsers!=null && listofUsers.size()>0) {
			return listofUsers.get(0);
		}
		
		return null;
	}
	public boolean checklogin(String email,String password) {
		Map<String,Object> parametermap=new HashMap();
		parametermap.put("email",email);
		parametermap.put("password",password);
		
		List<Users> users=super.findbyNamedQuery("Users.checklogin",parametermap);
		if(users.size()==1) {
			return true;
		}
		return false;
	}


	
	

}
