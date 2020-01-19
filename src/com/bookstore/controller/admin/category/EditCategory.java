package com.bookstore.controller.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.CategoryServices;

/**
 * Servlet implementation class EditCategory
 */
@WebServlet("/admin/editcategory")
public class EditCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoryServices categoryServices=new CategoryServices(request,response);
		categoryServices.Direct_Category_Update_Page();
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryServices categoryServices=new CategoryServices(req,resp);
		categoryServices.UpdateinDatabase();
	}

	

}
