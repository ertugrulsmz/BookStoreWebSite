package com.bookstore.dao;

import java.util.List;

public interface GenericDao<T> {
	
	public T create(T entity);
	
	public T update(T entity);
	
	public T get(Object id);
	
	public void delete(Object id);
	
	public List<T> listall();
	
	public long count();
	


}
