package com.bookstore.controller.admin.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Book;

public class CartServices {
	private BookDao bookDao;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Cart cart;
	
	
	public CartServices(HttpServletRequest request,HttpServletResponse response) {
		this.request=request;
		cart=(Cart)request.getSession().getAttribute("cart");
		
		this.response=response;
		bookDao=new BookDao();
	}
	
	public void removeElement() throws ServletException, IOException
	{
		String bookidString=request.getParameter("id");
		int id=Integer.parseInt(bookidString);
		Book book=bookDao.get(id);
		cart.removeBook(book);
		request.getRequestDispatcher("/frontend/shopping_cart.jsp").forward(request,response);
	}

	public void clearAll() throws IOException {
		cart.ClearAll();
		response.sendRedirect("viewcart");
		
	}

}
