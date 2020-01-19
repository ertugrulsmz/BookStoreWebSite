package com.bookstore.test.dao;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Category;


public class CategoryTest  {
	
	private static CategoryDao categorydao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categorydao=new CategoryDao();		
	}
	
	@Test
	public void create_test()
	{
		Category category=categorydao.create(new Category("Biology"));
		assertTrue(category!=null && category.getCategory_id()>0);
	}
	
	@Test
	public void update_test() {
		Category category=new Category();
		category.setCategory_id(1);
		category.setName("Chemistry");
		Category category2=categorydao.update(category);
		assertTrue(category2.getCategory_id()==1);
	}
	
	@Test
	public void delete_test() {
		Category category=new Category();
		category.setCategory_id(1);
		category.setName("Chemistry");
		categorydao.delete(1);
		assertNull(categorydao.get(1));
	}
	
	@Test 
	public void listall() {
		List<Category> list=categorydao.listall();
		assertTrue(list!=null && list.size()>=1);
	}
	
	@Test
	public void find_test() {
		Category category=categorydao.get(2);
		assertNotNull(category);
	}
	
	@Test
	public void count() {
		long count=categorydao.count();
		assertEquals(count,2);
	}
	
	

	

}
