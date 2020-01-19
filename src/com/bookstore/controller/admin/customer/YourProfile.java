package com.bookstore.controller.admin.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.BookOrderServices;

/**
 * Servlet implementation class YourProfile
 */
@WebServlet("/yourprofile")
public class YourProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookOrderServices bookOrderServices=new BookOrderServices(request,response);
		bookOrderServices.listProfileOrders();
		
		
		
	}

}
