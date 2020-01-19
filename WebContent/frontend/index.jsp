<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
    
    
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Evergreen Books</title>
<link rel="stylesheet" href="css/admin_index.css">
</head>
<body>
	
	<jsp:include page="header.jsp"/>
	
	
	
	
	
	<div align="center">
		<h3>This is main content </h3>
		
		<h2>New Books</h2>
		
	 	<jsp:include page="latest_books.jsp"></jsp:include> 
	
		
		<h2>Most Selled Books</h2>
		
		<jsp:include page="most_selled_books.jsp"></jsp:include>
		
		
		<h2>Most Favoured Books</h2>
		
		<jsp:include page="most_favoured_books.jsp"></jsp:include>
		
		
		
		
		
	
					
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	
</body>
</html>