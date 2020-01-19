package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Category;

public class CategoryServices extends GeneralServices {
	private CategoryDao categoryDao;
	private BookDao bookDao;

	public CategoryServices(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		categoryDao=new CategoryDao();
		bookDao=new BookDao();

	}
	
	public void ListCategories() throws ServletException, IOException {
		ListCategories(null);
	}
	
	
	
	
	public void ListCategories(String message) throws ServletException, IOException {
		List<Category> list= categoryDao.listall();
		request.setAttribute("listofcategories",list);
		request.setAttribute("message",message);
		
		String path="/admin/categorylist.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(path);
		
		
		requestDispatcher.forward(request,response);
	}
	
	public void CreateCategories() throws ServletException, IOException {
		
		String categoryname=request.getParameter("categoryname");
		Category category=new Category(categoryname);
		categoryDao.create(category);
		this.ListCategories();
		
	}
	public void Direct_Category_Update_Page() throws ServletException, IOException {
		String categoryidString=request.getParameter("id");
		int category_id=Integer.parseInt(categoryidString);
		Category category=categoryDao.get(category_id);
		
		request.setAttribute("categoryobj",category);
		String path="categoryform.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(path);
		requestDispatcher.forward(request,response);
	}
	public void UpdateinDatabase() throws ServletException, IOException {
		String categoryidString=request.getParameter("categoryid");
		int categoryid=Integer.parseInt(categoryidString);
		String categorynameString=request.getParameter("categoryname");
		
		
		Category category=new Category(categorynameString);
		category.setCategory_id(categoryid);
		categoryDao.update(category);
		this.ListCategories();
	}
	
	public void deletecategory() throws ServletException, IOException {
		String idString= request.getParameter("categoryid");
		int id=Integer.parseInt(idString);
		
		long count=bookDao.countByCategory(id);
		if(count>0) {
			this.ListCategories("This Category can not be deleted there are books contained by that");
		}else {
			categoryDao.delete(id);
			this.ListCategories();
		}
		
	}
	
	
	

}
