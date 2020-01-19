package com.bookstore.controller.admin.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.ReviewServices;

/**
 * Servlet implementation class SaveComment
 */
@WebServlet("/savecomment")
public class SaveComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewServices reviewServices=new ReviewServices(request,response);
		reviewServices.saveComment();
		}

}
