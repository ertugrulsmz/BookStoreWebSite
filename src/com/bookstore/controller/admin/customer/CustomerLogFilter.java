package com.bookstore.controller.admin.customer;



import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;



/**
 * Servlet Filter implementation class CustomerLogFilter
 */
@WebFilter("/*")
public class CustomerLogFilter implements Filter {
	
	private final String[] loginRequiredUrls={
		"/addcomment",
		"/finishshopping"
		
	};
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		String pathString=httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
		String requestedUrl=httpServletRequest.getRequestURL().toString();
		
		if(pathString.startsWith("/admin")) {
			chain.doFilter(request,response);
			return;
		}
		
		
		boolean loggedin=httpServletRequest.getSession(false)!=null 
				&& httpServletRequest.getSession(false).getAttribute("customer")!=null;
		
		
		if(!loggedin &&  isLoginRequiredUrl(pathString) ) {
			String queryString=httpServletRequest.getQueryString();
			if(queryString!=null) {
				System.out.println("query is not null --------------------------------"+queryString);
				requestedUrl+="?"+queryString;
				System.out.println("requested url : : : "+requestedUrl);
			}
			System.out.println("--------------------------------------------------");
			
			httpServletRequest.getSession().setAttribute("requestedUrl",requestedUrl);
			request.getRequestDispatcher("login").forward(request,response);
			return;
		}
		
		
		if(loggedin && pathString.startsWith("/frontend/login")) {
			System.out.println("loginfilter");
			request.getRequestDispatcher("/frontend/index.jsp").forward(request,response);
			return;
		}
		chain.doFilter(request,response);
		
	}

	
	private boolean isLoginRequiredUrl(String path) {
		for(String string : loginRequiredUrls) {
			if(path.contains(string)) {
				return true;
			}
		}
		return false;
	}

}
