<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
   
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Evergreen Bookstore Administration</title>
	<link rel="stylesheet" href="../css/admin_index.css">
</head>
<body>

	<jsp:include page="header.jsp"/>
	
	
	
	
	
	
	<div align="center">
		<h3 class="headergroup1">Administrative Dashboard</h3>
	</div>
	

	
	<div align="center">
		<br/>
		<hr width="60%" />
		<br/>
		<a href="newbook">New Book</a>
		<a href="newuser">New User</a>
		<a href="newcategory">New Category</a>
		<a href="newcustomer">New Customer</a>
		
	</div>
	
	<div align="center">
		<br/>
		<hr width="60%" />
		<br/>
		<h3 class="headergroup1">Recent sales</h3>
		
		<jsp:include page="utility/recent_sales.jsp"></jsp:include>
		
		
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	<div align="center">
		<br/>
		<hr width="60%" />
		<br/>
		
		<h3 class="headergroup1">Recent reviews</h3>
		
		<jsp:include page="utility/recent_reviews.jsp"></jsp:include>
		 
		
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<div align="center">
		<br/>
		<hr width="60%" />
		<br/>
		Statistics
		<h3>Total Admin Number : ${admincounter} </h3>
		<h3>Total Book Number : ${bookcounter} </h3>
		<h3>Total Review Number : ${reviewcounter} </h3>
		<h3>Total Order Number : ${bookordercounter} </h3>

	</div>
	
	<jsp:include page="footer.jsp"/>

</body>
</html>