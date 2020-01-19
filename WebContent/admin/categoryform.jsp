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
	
		<c:if test="${categoryobj!=null}">
		
			<h3>Edit Category</h3>
			<form action="editcategory" method="post" id="categoryform">
		</c:if>	
		
		<c:if test="${categoryobj==null}">
			<form action="categories" method="post" id="categoryform">
		</c:if>	
		
		
		<table class="tableforform">
		
			<tr>
				<td><input type="hidden"  size="30" value="${categoryobj.category_id}" name="categoryid" id="id"/></td>
			
			</tr>
				
			<tr> 
				<td>Category name : </td>
				<td><input type="text"  size="30" value="${categoryobj.name}" name="categoryname" id="categoryname"/></td>
			</tr>
			
			
			
			<tr>&nbsp;</tr>
			<tr align="center">
				<td>&nbsp;</td>
				<td colspan="2"> <input type="submit" value="save" size="20"> 
				
				<input type="button" value="cancel" size="20" id="cancelbutton">   </td>
			</tr>
		
		</table>
	
	</form>
	
	</div>
	
	
	
	
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>

<script type="text/javascript">

$(document).ready(function(){
	
	

	$("#cancelbutton").click(function(){
		history.go(-1);
	});
	
	$("#categoryform").validate({
		rules:{
			categoryname:"required"
		},
		messages:{
			categoryname:"category name is required"
		}
	});
	
});



</script>


</html>