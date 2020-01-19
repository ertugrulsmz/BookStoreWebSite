<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Form</title>
	<link rel="stylesheet" href="../css/admin_index.css">
	<link rel="stylesheet" href="../js/jquery-ui.min.css">	
	
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="../css/richtext.min.css">
	<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="../js/jquery.richtext.min.js"></script>
	
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<div align="center">
		<br/>
		<c:if test="${review!=null}">
			
			<form action="update_review" method="post" id="reviewform" >	
				<input type="hidden" name="id" value="${review.review_id}"/>
				
				<table class="tableforform">
			
					<tr> 
						<td>Book : </td>
						<td><h4>${review.book.title}</h4></td>
					</tr>
					
					<tr> 
						<td>Rating : </td>
						<td><h4>${review.rating}</h4></td>
					</tr>
					
					<tr> 
						<td>Customer : </td>
						<td><h4>${review.customer_class.fullnameString}</h4></td>
					</tr>
					
					<tr> 
						<td>Headline :  </td>
						<td><input type="text" value="${review.headline}" size="30" name="headline" id="headline"/>  </td>
					</tr>
					
					<tr> 
						<td>Comment :  </td>
						<td> <textarea rows="5" cols="30" name="comment" id="comment">${review.comment}</textarea>  </td>
					</tr>
					
					<tr>&nbsp;</tr>
					<tr align="center">
						<td>&nbsp;</td>
						<td colspan="2"> <button type="submit" size="20">Save</button> 
				
						<button size="20" id="cancelbutton">Cancel</button>   </td>
					</tr>
				
				</table>
			</form>	
			
			
			
		</c:if>
		
		
		
			
			
			
		
		
	
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
		
		$("#reviewform").validate({
			rules:{
				
				headline:"required",
				comment:"required"	
			},
			messages:{
				
				headline:"headline required",
				comment:"comment required"	
			}
		});
		
		$("#cancelbutton").click(function(){
			history.go(-1);
		});
		
	});
	


</script>


</html>