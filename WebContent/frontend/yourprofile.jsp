<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Profile</title>
<link rel="stylesheet" href="css/admin_index.css">
</head>
<body>

	<jsp:include page="header.jsp"/>

	<div align="center">
	
		<h2>Your Orders</h2>
		
		
		<table border="1">
			<tr>
				<th>Index</th>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>total price</th>
				<th>Status</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach var="variable" items="${orderlist}" varStatus="status">
				
				<tr>				
					<td>${status.index}</td>
					<td>${variable.order_id}</td>
					<td>${variable.recipient_name}</td>	
					<td>${variable.shipping_address}</td>	
					<td>${variable.total}</td>
					<td>${variable.status}</td>	
								
									
					<td>
						<a href="order_detail?id=${variable.order_id}">Details</a>
						<a href="javascript:void(0);" class="deleteLink" id="${variable.order_id}">
							Delete</a>
					</td>
				
				</tr>
				
			</c:forEach>
			
		</table>
		
	
	</div>
	
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	
</body>
</html>