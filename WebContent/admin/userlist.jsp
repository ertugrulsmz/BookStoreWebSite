<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Manage Users - Evergreen Book Administration</title>
		<link rel="stylesheet" href="../css/admin_index.css">
		<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
		
	</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	
	<div align="center">
	
		<h2>User Management</h2>
		<a href="user_form.jsp">Create New User</a>
		
		<c:if test="${previousservlet!=null}">
		
			<h3>${previousservlet}</h3>
		
		</c:if>
	
	</div>
	
	
	
	
	
	<div align="center">
		<br/>	
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>Id</th>
				<th>Fullname</th>
				<th>Email</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach var="variable" items="${listusers}" varStatus="status">
				
				<tr>				
					<td>${status.index}</td>
					<td>${variable.userId}</td>
					<td>${variable.fullnameString}</td>
					<td>${variable.email}</td>
					
					
					<td>
						<a href="edit?id=${variable.userId}">Edit</a>
						<a href="javascript:void(0);" class="deleteLink"
						id="${variable.userId}" >Delete</a>
					</td>
				
				</tr>
				
			</c:forEach>
			
		</table>
					
	</div>
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>
<script>
	$(document).ready(function(){
		$(".deleteLink").each(function(){
			$(this).on("click",function(){
				userid=$(this).attr("id");
				if(confirm("are you sure deleting id : "+userid)){
					window.location="delete_user?userid="+userid;
				}
			});
		});
	});
	
	

</script>



</html>