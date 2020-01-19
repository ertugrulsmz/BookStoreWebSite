package com.bookstore.book.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.BookServices;


@WebServlet("/admin/update_book")
@MultipartConfig(
		fileSizeThreshold=1024*10, //10kb
		maxFileSize=1024*300, //300kb
		maxRequestSize=1024*1024 //1mb
)
public class Update_Book extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BookServices bookServices=new BookServices(req,resp);
		bookServices.updateBook();
	}

}
