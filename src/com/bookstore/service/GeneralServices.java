package com.bookstore.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public abstract class GeneralServices {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	
	
	
	public GeneralServices(HttpServletRequest request, HttpServletResponse response) {
		
		this.request = request;
		this.response = response;
		
	}
	
	

}
