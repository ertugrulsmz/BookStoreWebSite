package com.bookstore.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.admin.cart.Cart;
import com.bookstore.dao.BookOrderDao;
import com.bookstore.dao.OrderDetailsDao;
import com.bookstore.entity.Customer_class;
import com.bookstore.entity.Order_Details;
import com.bookstore.entity.Book;
import com.bookstore.entity.Book_Order;

public class BookOrderServices extends GeneralServices {

	private BookOrderDao bookOrderDao;
	private OrderDetailsDao orderDetailsDao;
	
	public BookOrderServices(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		bookOrderDao=new BookOrderDao();
		orderDetailsDao=new OrderDetailsDao();
	}
	
	
	public void recordOrder() throws IOException
	{
		
		String nameString=request.getParameter("name");
		String country=request.getParameter("country");
		String city=request.getParameter("city");
		String zipcode=request.getParameter("zipcode");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String pay=request.getParameter("pay");
		
		
		Customer_class customer_class=(Customer_class) request.getSession().getAttribute("customer");
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		
		Float totalprice=cart.totalPriceofBooks();
		
		Book_Order book_Order=new Book_Order();
		book_Order.setCustomer(customer_class);
		book_Order.setPayment_method(pay);
		book_Order.setRecipient_name(nameString);
		book_Order.setRecipient_phone(phone);
		book_Order.setShipping_address(address+" | "+city+"/"+country+"/"+zipcode);
		book_Order.setTotal(totalprice);
		book_Order.setStatus("ok");
		
		
		Map<Book,Integer> map=cart.getItems();
		Set<Order_Details> orderdetailsset=new HashSet<Order_Details>();
		
		for(Book book:map.keySet()) {
			Order_Details order_Details=new Order_Details();
			order_Details.setBook(book);
			order_Details.setBook_Order(book_Order);
			order_Details.setQuantity(map.get(book));
			order_Details.setSubtotal(book.getPrice()*map.get(book));
			orderdetailsset.add(order_Details);
			
		}
		
		book_Order.setOrder_details(orderdetailsset);
		response.sendRedirect(request.getContextPath());
		
		bookOrderDao.create(book_Order);
		
	}


	public void listProfileOrders() throws ServletException, IOException {
		Customer_class customer_class=(Customer_class)request.getSession().getAttribute("customer");
		List<Book_Order> orderlist=bookOrderDao.findByCustomer(customer_class.getIdString());
		request.setAttribute("orderlist",orderlist);
		request.getRequestDispatcher("/frontend/yourprofile.jsp").forward(request,response);
	}


	public void detailOrder() {
		String idString=request.getParameter("id");
		Book_Order order=bookOrderDao.get(Integer.parseInt(idString));
	}
	

}
