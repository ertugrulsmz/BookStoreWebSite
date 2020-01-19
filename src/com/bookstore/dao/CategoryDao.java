package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Category;

public class CategoryDao extends JpaDao<Category> implements GenericDao<Category> {

	public CategoryDao() {
		
	}

	@Override
	public Category get(Object id) {
		return super.find(Category.class,id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Category.class,id);
		
	}

	@Override
	public List<Category> listall() {
		return super.findAll("Category.findall");
	}

	@Override
	public long count() {
		
		return super.count("Category.countall");
	}

}
