package com.bookstore.book.admin;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bookstore.service.BookServices;



@WebServlet("/admin/createbook")
@MultipartConfig(
	fileSizeThreshold=1024*10, //10kb
	maxFileSize=1024*300, //300kb
	maxRequestSize=1024*1024 //1mb
)
public class CreateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookServices bookServices=new BookServices(request,response);
		bookServices.createBook();
		
		
		
	}

}
