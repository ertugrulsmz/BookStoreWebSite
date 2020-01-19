<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Form</title>
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
		<br/>
		<c:if test="${book!=null}">
			
			<form action="update_book" method="post" id="customerform" >	
			<input type="hidden" name="id" value="${book.book_id}"/>
		</c:if>
		
		<c:if test="${book==null}">
			
			<form action="register" method="post" id="customerform" >	
		
		</c:if>
		
		<h2>Register Customer</h2>
		
		
		<table class="tableforform">
		
			<tr> 
				<td>E-mail : </td>
				<td><input type="text"   size="30" name="email" id="email"/></td>
			</tr>
			
			<tr> 
				<td>Fullname :  </td>
				<td><input type="text" size="30" name="fullname" id="fullname"/>  </td>
			</tr>
			
			<tr> 
				<td>Password :  </td>
				<td> <input type="password" size="30"  name="password" id="password"/>  </td>
			</tr>
			
			<tr> 
				<td>Confirm Password :  </td>
				<td> <input type="password" size="30"  name="confirmpassword" id="confirmpassword"/>
				</td>
			</tr>			
			
			<tr> 
				<td>Phone Number :  </td>
				<td> 
					<input type="text" size="30"  name="phonenumber" id="phonenumber"/>
					 
				 </td>
					 
				
			</tr>
			
			<tr> 
				<td>Address :  </td>
				<td> <input type="text" size="30"  name="address" id="address"/>  </td>
			</tr>
			
			
			<tr> 
				<td>City:  </td>
				<td> <input type="text" size="30"  name="city" id="city"/>
				</td>
				
			</tr>
			
			<tr> 
				<td>Zipcode:  </td>
				<td> <input type="text" size="30"  name="zipcode" id="zipcode"/>
				</td>
				
			</tr>
			
			<tr> 
				<td>Country:  </td>
				<td> <input type="text" size="30"  name="country" id="country"/>
				</td>
				
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
		
		
		
		
		
		$("#customerform").validate({
			rules:{
				email:{
					required:true,
					email:true
				},
				confirmpassword:{
					required:true,
					equalTo:"#password"
				},
				fullname:"required",
				password:"required",
				phonenumber:"required",
				address:"required",
				city:"required",
				zipcode:"required",
				country:"required"	
			},
			messages:{
				email:{
					required:"Please enter  email",
					email:"Please enter valid email"
				},
				confirmpassword:{
					required:"Please confirm password",
					equalTo:"Confirm password does not match"
				},
				fullname:"fullname required",
				password:"password required",
				phonenumber:"phone number required",
				address:"address required",
				city:"city required",
				zipcode:"zipcode required",
				country:"country required"	
				
				
			}
		});
		
		$("#cancelbutton").click(function(){
			history.go(-1);
		});
		
	});
	
	
	 
	
	






</script>


</html>