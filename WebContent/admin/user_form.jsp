<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Evergreen Bookstore Administration</title>
<link rel="stylesheet" href="../css/admin_index.css">
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<div align="center">
	
		<c:if test="${userat!=null}">
			
			<form action="edit" method="post" id="userform" >	
			<input type="hidden" name="id" value="${userat.userId}">>
		</c:if>
		
		<c:if test="${userat==null}">
			
			<form action="listuserservlet" method="post" id="userform" >	
		
		</c:if>
		
		
		
		
		<table class="tableforform">
		
			<tr> 
				<td>Full name : </td>
				<td><input type="text" value="${userat.fullnameString}"  size="30" name="fullname" id="fullname"/></td>
			</tr>
			
			<tr> 
				<td>Email :  </td>
				<td><input type="text" value="${userat.email}" size="30" name="email" id="email"/>  </td>
			</tr>
			
			<tr> 
				<td>Password :  </td>
				<td> <input type="password" size="30" value="${userat.password}" name="password" id="password"/>  </td>
			</tr>
			
			<tr>&nbsp;</tr>
			<tr align="center">
				<td>&nbsp;</td>
				<td colspan="2"> <button type="submit" size="20">Save</button> 
				
				<button  size="20" id="cancelbutton">Cancel</button>   </td>
			</tr>
		
		</table>
	
	</form>
	
	</div>
	
	<c:if test="${emailerror!=null}">
	
	<div align="center">
	
		<h3>${emailerror}</h3>
	
	</div>
	
	</c:if>
	
	<c:if test="${emailrepititonerror!=null}">
	
	<div align="center">
	
		<h3>${emailrepititonerror}</h3>
	
	</div>
	
	</c:if>
	
	
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>

<script type="text/javascript">

	$(document).ready(function(){
		$("#userform").validate({
			rules:{
				email:"required",
				fullname:"required",
				password:"required",
			},
			messages:{
				email:"email is required",
				fullname:"full name is required",
				password:"password is required"
			}
		});
		
		
		
	});
	
	$("#cancelbutton").click(function(){
		history.go(-1);
	});
	
	




function validateform() {
	var fieldemail=document.getElementById("email");
	var fieldfullname=document.getElementById("fullname");
	var fieldpassword=document.getElementById("password");
	
	if(fieldfullname.value.length==0){
		alert("fullname is required");
		fieldemail.focus();
		return false;
	}
	else if(fieldemail.value.length==0){
		alert("email is required");
		fieldemail.focus();
		return false;
	}
	else if(fieldpassword.value.length==0){
		alert("password is required");
		fieldemail.focus();
		return false;
	}
	
	return true;

}


</script>


</html>