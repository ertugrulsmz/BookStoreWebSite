package com.bookstore.controller.admin.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Book;

/**
 * Servlet implementation class AddtoCart
 */
@WebServlet("/addcart")
public class AddtoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		
		Cart cart=null;
		if(httpSession.getAttribute("cart")==null) {
			cart=new Cart();
			httpSession.setAttribute("cart",cart);
		}
		
		String idString=request.getParameter("bookid");
		BookDao bookDao=new BookDao();
		Book book=bookDao.get(Integer.parseInt(idString));
		
		cart=(Cart) httpSession.getAttribute("cart");
		cart.addBook(book);
		
		response.sendRedirect("viewcart");
	}

	

}
