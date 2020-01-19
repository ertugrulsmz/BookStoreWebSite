package com.bookstore.controller.admin.user;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/admin/*")
public class LoginFilter implements Filter {

    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httprequest=(HttpServletRequest) request;
		HttpSession httpSession=httprequest.getSession(false);
		boolean exist=httpSession!=null && httpSession.getAttribute("adminemail")!=null;
		
		String destinationString=httprequest.getContextPath()+"/admin/login";
		boolean destination_login=httprequest.getRequestURI().equals(destinationString);
		
		boolean directlogin=httprequest.getRequestURI().equals(httprequest.getContextPath()+"/admin/login.jsp");
		
		
		if((exist && destination_login)||(exist && directlogin)) {
			System.out.println("1");
			((HttpServletResponse)response).sendRedirect("/BookStoreWebSite/admin");
		}
		else if(exist || destination_login) { //login result okey but not saved yet, let it be saved
			System.out.println("login has existed");
			chain.doFilter(request, response);
		}else {
			System.out.println("login has not existed");
			request.getRequestDispatcher("/admin/login.jsp").forward(request,response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
