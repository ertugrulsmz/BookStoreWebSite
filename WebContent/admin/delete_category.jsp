<%@page import="com.bookstore.service.CategoryServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% 
    	String idString=request.getParameter("categoryid");
    	CategoryServices categoryServices=new CategoryServices(request,response);
    	categoryServices.deletecategory();
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>