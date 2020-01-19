package com.bookstore.controller.admin.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Customer_class;
import com.bookstore.service.BookOrderServices;

/**
 * Servlet implementation class EndOfShopping
 */
@WebServlet("/endofshopping")
public class EndOfShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			BookOrderServices bookOrderServices=new BookOrderServices(request,response);
			bookOrderServices.recordOrder();
		}
}
