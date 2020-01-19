package com.bookstore.controller.admin.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Category;


/**
 * Servlet Filter implementation class CategoryListFilter
 */
@WebFilter("/*")
public class CategoryListFilter implements Filter {

    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		String pathString=httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
		
		
		if(!pathString.startsWith("/admin")) {
			
			CategoryDao categoryDao=new CategoryDao();
			List<Category> categories=categoryDao.listall();
			request.setAttribute("categorylist",categories);
	
		}
		
		chain.doFilter(request, response);
	}

	

}
