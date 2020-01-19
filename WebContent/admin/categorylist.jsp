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
	
		<h2>Category Management</h2>
		<a href="categoryform.jsp">Create Category</a>
		
		<c:if test="${message!=null}">
			<h4>${message}</h4>
		</c:if>	
	
	</div>
	
	
	
	
	
	<div align="center">
		<br/>	
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>Id</th>
				<th>Name</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach var="variable" items="${listofcategories}" varStatus="status">
				
				<tr>				
					<td>${status.index}</td>
					<td>${variable.category_id}</td>
					<td>${variable.name}</td>
										
					<td>
						<a href="editcategory?id=${variable.category_id}">Edit</a>
						<a href="javascript:void(0);" class="deleteLink" id="${variable.category_id}">
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
				categoryid=$(this).attr("id");
				if(confirm("are you sure deleting id : "+categoryid)){
					window.location="delete_category.jsp?categoryid="+categoryid;
				}
			});
		});
	});
	
	

</script>



</html>