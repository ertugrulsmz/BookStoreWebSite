package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CustomerDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.Customer_class;

public class CustomerServices extends GeneralServices{
	
	private CustomerDao customerDao;
	public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		customerDao=new CustomerDao();
	}
	
	public void listAllCustomers() throws ServletException, IOException {
		listAllCustomers(null);
	}

	public void listAllCustomers(String message) throws ServletException, IOException {
		
		List<Customer_class> customer_list=customerDao.listall();
		request.setAttribute("customerlist",customer_list);
		request.setAttribute("message",message);
		request.getRequestDispatcher("customerlist.jsp").forward(request,response);
	}
	

	

	public void createCustomer() throws ServletException, IOException {
		String emailString=request.getParameter("email");
		
		Customer_class customer_class=customerDao.findByEmail(emailString);
		if(customer_class==null) {

			Customer_class customer1=new Customer_class();
			readNonUniqueMembersFromForm(customer1,emailString);
			customerDao.create(customer1);
			this.listAllCustomers();
		}else {
			String messageString="Can not create customer because of duplicated email address";
			this.listAllCustomers(messageString);
		}
	}

	public void registerCustomer() throws IOException, ServletException {
		String emailString=request.getParameter("email");
		Customer_class customer_class=customerDao.findByEmail(emailString);
		
		if(customer_class==null) {
			Customer_class customer1=new Customer_class();
			readNonUniqueMembersFromForm(customer1,emailString);
			customerDao.create(customer1);
			System.out.println("getrequest url : "+request.getRequestURI());
			System.out.println("get request path : "+request.getServletPath());
			response.sendRedirect("/BookStoreWebSite");
		}else {
			request.getRequestDispatcher("/frontend/customer_form.jsp").forward(request,response);
		}
		
	}
	
	public void deleteCustomer() throws ServletException, IOException {
		String idString=request.getParameter("customerid");  
		customerDao.delete(Integer.parseInt(idString));
		this.listAllCustomers("Customer is Deleted");
		
	}
	
	
	
	private void readNonUniqueMembersFromForm(Customer_class customer1,String emailString) {
		String fullname=request.getParameter("fullname");
		String password=request.getParameter("password");
		String phonenumber=request.getParameter("phonenumber");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		String zipcodeString=request.getParameter("zipcode");
		
		customer1.setAddressString(address);
		customer1.setCityString(city);
		customer1.setCountryString(country);
		customer1.setEmailString(emailString);
		customer1.setFullnameString(fullname);
		customer1.setPasswordString(password);
		customer1.setPhoneString(phonenumber);
		customer1.setZipcodeString(zipcodeString);
		
		
	}

	public void doLogin() throws ServletException, IOException {
		Customer_class customer_class=customerDao.login_condition(request.getParameter("email"),request.getParameter("password"));
		if(customer_class!=null) {
			request.getSession().setAttribute("customer",customer_class);
			
			if(request.getSession().getAttribute("requestedUrl")!=null) {
				System.out.println("requestedUrl is not nullll : : : "+request.getSession().getAttribute("requestedUrl"));
				String urlString=(String) request.getSession().getAttribute("requestedUrl");
				request.getSession().removeAttribute("requestedUrl");
				response.sendRedirect(urlString);
				return;
			}
			
			String profilepageString="/frontend/index.jsp";
			
			BookDao bookDao=new BookDao();
			List<Book> newBookList=bookDao.listNewBooks();
			request.setAttribute("newbooklist",newBookList);
			request.getRequestDispatcher(profilepageString).forward(request,response);
			
			
			
		}else {
			request.setAttribute("message","There is no account with that email and password");
			request.getRequestDispatcher("frontend/login.jsp").forward(request,response);
		}
	}

}
