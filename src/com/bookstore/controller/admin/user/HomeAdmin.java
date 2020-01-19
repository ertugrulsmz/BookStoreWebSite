package com.bookstore.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookOrderDao;
import com.bookstore.dao.ReviewDao;
import com.bookstore.dao.UserDao;
import com.bookstore.entity.Book_Order;
import com.bookstore.entity.Review;



@WebServlet("/admin/")
public class HomeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReviewDao reviewDao=new ReviewDao();
		List<Review> reviewlist=reviewDao.lastReviews();
		long reviewcounter=reviewDao.count();
		
		BookOrderDao bookOrderDao=new BookOrderDao();
		List<Book_Order> listorder=bookOrderDao.lastSales();
		long bookordercounter=bookOrderDao.count();
		
		long bookcounter=new BookDao().count();
		long admincounter=new UserDao().count();
		
		
		
		request.setAttribute("bookcounter",bookcounter);
		request.setAttribute("admincounter",admincounter);
		request.setAttribute("reviewcounter",reviewcounter);
		request.setAttribute("bookordercounter",bookordercounter);
		
		request.setAttribute("recentreviews",reviewlist);
		request.setAttribute("recentsales",listorder);
		
		String pathString="index22.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(pathString);
		requestDispatcher.forward(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	

}
