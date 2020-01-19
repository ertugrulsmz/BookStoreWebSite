<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Admin Login</title>
	<link rel="stylesheet" href="../css/admin_index.css"/>
	<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>

	<div align="center">
	
		<h1>Book Store Admin Administration</h1>
		<h3>Admin Login</h3>
		
		<form id="adminloginform" action="/BookStoreWebSite/admin/login" method="post">
		
			<table>
			
				<tr>
					<td>Email : </td>
					<td><input type="text" name="email" id="email"/></td>
				
				</tr>
				
				<tr>
					<td>Password </td>
					<td><input type="password" name="password" id="password"/></td>
				
				</tr>
				
				<tr>
					<td colspan="2" align="center"><button type="submit">Login</button></td>
				
				</tr>
				
				<c:if test="${loginfail!=null}">
					<tr>
						<td colspan="2" align="center">${loginfail}</td>
				
					</tr>	
				</c:if>
			
			</table>
	
		</form>
	
	</div>

</body>






<script type="text/javascript">

	$(document).ready(function(){
		$("#adminloginform").validate({
			rules:{
				email:{
					required:true,
					email:true
				},
				password:"required",
			},
			messages:{
				email:"email is required",
				password:"password is required"
			}
		});
		
		$("#cancelbutton").click(function(){
			history.go(-1);
		});
		
	});
	
	




</script>


</html>