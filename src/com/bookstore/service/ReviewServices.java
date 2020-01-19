package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CustomerDao;
import com.bookstore.dao.ReviewDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.Customer_class;
import com.bookstore.entity.Review;

public class ReviewServices  extends GeneralServices{
	
	private ReviewDao reviewDao;
	
	public ReviewServices(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		reviewDao=new ReviewDao();
	}

	public void listReviews() throws ServletException, IOException {
		List<Review> listReviews=reviewDao.listall();
		request.setAttribute("listofreviews",listReviews);
		request.getRequestDispatcher("review_list.jsp").forward(request,response);
		
	}

	public void deleteReview() throws ServletException, IOException {
		String reviewidString=request.getParameter("reviewid");
		reviewDao.delete(Integer.parseInt(reviewidString));
		this.listReviews();
		
	}

	public void prepareEditPage() throws ServletException, IOException {
		String reviewidString=request.getParameter("id");
		Review review=reviewDao.get(Integer.parseInt(reviewidString));
		
		request.setAttribute("review",review);
		request.getRequestDispatcher("review_form.jsp").forward(request,response);
		
	}

	public void updateReview() throws ServletException, IOException {
		String idString=request.getParameter("id");
		String comment=request.getParameter("comment");
		String headline=request.getParameter("headline");
		
		Review review=reviewDao.get(Integer.parseInt(idString));
		review.setHeadline(headline);
		review.setComment(comment);
		reviewDao.update(review);
		
		this.listReviews();
		
	}

	
	public void addReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookidString=request.getParameter("bookid");
		BookDao bookDao=new BookDao();
		Book book=bookDao.get(Integer.parseInt(bookidString));
		
		request.setAttribute("book",book);
		request.getRequestDispatcher("/frontend/addcomment.jsp").forward(request,response);
	}

	public void saveComment() throws IOException {
		String bookidBook=request.getParameter("bookid");
		Book book=new BookDao().get(Integer.parseInt(bookidBook));
		Customer_class customer_class=(Customer_class) request.getSession().getAttribute("customer");
		String rateString=request.getParameter("rating");
		
		
		
		Review review=new Review();
		review.setBook(book);
		review.setCustomer_class(customer_class);
		review.setComment(request.getParameter("comment"));
		review.setHeadline(request.getParameter("headline"));
		review.setRating(Integer.parseInt(rateString));
		
		reviewDao.create(review);
		response.sendRedirect("viewbook?id="+bookidBook);
	}

	
}
