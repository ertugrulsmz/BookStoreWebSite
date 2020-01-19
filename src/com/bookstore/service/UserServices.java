package com.bookstore.service;

import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bookstore.dao.UserDao;
import com.bookstore.entity.Users;

public class UserServices extends GeneralServices {
	
	private UserDao userDao;
	
	public UserServices(HttpServletRequest request,HttpServletResponse response) {
		super(request,response);
		userDao=new UserDao();
	}
	
	public void ListUsers() throws ServletException, IOException 
	{
		ListUsers(null);
	}
	
	
	//Direct to admin user list page by forwarding userlist.jsp 
	public void ListUsers(String previous) throws ServletException, IOException 
	{
		List<Users> listofusers=userDao.listall();
		
		request.setAttribute("listusers",listofusers);
		request.setAttribute("previousservlet",previous); //test if came from create servlet
		
		String path="/admin/userlist.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(path);
		requestDispatcher.forward(request,response);
	}
	
	//create user in mysql
	public void CreateUser() throws ServletException, IOException
	{
		String fullnameString=request.getParameter("fullname");
		String emailString=request.getParameter("email");
		String passwordString=request.getParameter("password");
		
		if(userDao.findByEmail(emailString)==null) {
			Users users=new Users(fullnameString,emailString,passwordString);
			userDao.create(users);
			this.ListUsers("User Created Succesfully !");
		}else {
			String messageString="Couldn't create account, duplicate email";
			request.setAttribute("emailerror",messageString);
			System.out.println("------------------------------ error duplicate");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("user_form.jsp");
			requestDispatcher.forward(request,response);
			
		}
	}
	
	public void direct_update_user_page() throws ServletException, IOException {
		String id=request.getParameter("id");
		int id_int=Integer.parseInt(id);
		Users users=userDao.get(id_int);
		
			
		request.setAttribute("userat",users);
		String path="user_form.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(path);
		requestDispatcher.forward(request,response);
	}
	public void update_in_database() throws ServletException, IOException {
		
		String fullnameString=request.getParameter("fullname");
		String emailString=request.getParameter("email");
		String passwordString=request.getParameter("password");
		String idString=request.getParameter("id");
		
		int id_int=Integer.parseInt(idString);
		
		Users users=new Users(fullnameString,id_int,emailString,passwordString);
		
		Users users2=userDao.findByEmail(emailString);
		
		if(users2!=null &&  users2.getUserId()!=users.getUserId()) {
			Users users3=userDao.get(id_int); //old version - unchanged
			
			request.setAttribute("emailrepititonerror","duplicate email");
			request.setAttribute("userat",users3);
			
			
			String path="user_form.jsp";
			RequestDispatcher requestDispatcher=request.getRequestDispatcher(path);
			requestDispatcher.forward(request,response);
		}
	
		
		userDao.update(users);
		this.ListUsers();		
		
	}
	
	public void deleteuser() throws ServletException, IOException {
		String idString= request.getParameter("userid");
		int id=Integer.parseInt(idString);
		userDao.delete(id);
		String messageString="User Deleted Succesfully";
		this.ListUsers(messageString);
	}

	public void loginadmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailString=request.getParameter("email");
		String passwordString=request.getParameter("password");
		boolean loginvalue=userDao.checklogin(emailString,passwordString);
		if(loginvalue) {
			System.out.println("login has realized");
			request.getSession().setAttribute("adminemail",emailString);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/admin/");
			requestDispatcher.forward(request,response);
		}else {
			System.out.println("login has failed");
			request.setAttribute("loginfail","login has failed");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/admin/login.jsp");
			requestDispatcher.forward(request,response);
			
		}
	}
	
	
}
