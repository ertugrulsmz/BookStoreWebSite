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
	
	<c:if test="${a!=null}">
		
			<h1>a not null</h1>
		
		</c:if>
		
		<c:if test="${a==null}">
		
			<h1>a  null</h1>
		
		</c:if>
	
	
	<div align="center">
	
		<h2>User Management</h2>
		<a href="book_form">Create New Book</a>
		
		<c:if test="${message!=null}">
			<h3>${message}</h3>
		</c:if>
	
	</div>
	
	
	
	
	
	<div align="center">
		<br/>	
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>Id</th>
				<th>Image</th>
				<th>Title</th>
				<th>Author</th>
				<th>Description</th>
				<th>Price</th>
				<th>Publish Date</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="variable" items="${booklist}" varStatus="status">
				
				<tr>				
					<td>${status.index}</td>
					<td>${variable.book_id}</td>
					
					<td>
					
						<img src="data:image/jpg;base64,${variable.base64Image}"
						width="84" height="110"/>
					
					</td>
					
					<td>${variable.title}</td>
					<td>${variable.author}</td>
					<td>${variable.description}</td>
					<td>${variable.price}</td>
					<td>${variable.last_update_time}</td>
					
					
					<td>
						<a href="edit_book?id=${variable.book_id}">Edit</a>
						<a href="javascript:void(0);" class="deleteLink" id="${variable.book_id}">
							Delete</a>
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
				bookid=$(this).attr("id");
				if(confirm("are you sure deleting id : "+bookid)){
					window.location="delete_book?bookid="+bookid;
				}
			});
		});
	});
	
	

</script>


</html>