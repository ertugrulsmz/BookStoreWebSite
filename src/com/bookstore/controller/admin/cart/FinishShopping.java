package com.bookstore.controller.admin.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.entity.Customer_class;

/**
 * Servlet implementation class FinishShopping
 */
@WebServlet("/finishshopping")
public class FinishShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession=request.getSession();
		Cart cart=(Cart) httpSession.getAttribute("cart");
		
		if(cart==null || cart.totalNumberofElements()==0) {
			response.sendRedirect("viewcart");
			return;
		}
		
		request.getRequestDispatcher("frontend/finishshopping.jsp").forward(request,response);
		
		
	}

}
