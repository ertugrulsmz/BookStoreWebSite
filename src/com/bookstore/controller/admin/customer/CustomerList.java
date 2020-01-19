package com.bookstore.controller.admin.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CustomerDao;
import com.bookstore.entity.Category;
import com.bookstore.service.CategoryServices;
import com.bookstore.service.CustomerServices;


@WebServlet("/admin/customerlist")
public class CustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices customerServices=new CustomerServices(request,response);
		customerServices.listAllCustomers();
	}

}
