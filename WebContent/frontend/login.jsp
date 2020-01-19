<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/admin_index.css">
	<link rel="stylesheet" href="js/jquery-ui.min.css">	
	
	<link rel="stylesheet" href="/netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="/css/richtext.min.css">
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div align="center">
	<br/><br/>
		<form action="login" method="post" id="loginform"> 
			
			<table>
			
				<tr>
					<td>Email :</td>
					<td> <input type="text" size="15" name="email" id="email"></input></td>
			
				</tr>
				
				<tr>
					<td>Password :</td>
					<td> <input type="password" name="password" size="15" id="password"/></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><br/><input type="submit" value="Submit"/></td>
				</tr>
			
			</table>
			
		</form>	
		
		<c:if test="${message!=null}">
		
			<h4>${message}</h4>
		
		</c:if>			
	
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>


</body>

<script type="text/javascript">

$(document).ready(function(){
	
	$("#loginform").validate({
		rules:{
			email:{
				required:true,
				email:true
			},
			password:"required"
		},
		messages:{
			email:{
				required:"Please enter  email",
				email:"Please enter valid email"
			},
			password:"password required"	
		}
	});
	
	
	
});







</script>




</html>