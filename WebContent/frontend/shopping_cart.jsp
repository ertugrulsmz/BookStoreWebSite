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

	<jsp:include page="header.jsp"/>
	
	<div align="center">
	
		<h1>Your Shopping Cart</h1>
		<c:set var="cart" value="${sessionScope['cart']}"/>
		<c:if test="${cart.totalNumberofElements()==0}">
		
			<h3>There is no item in your cart.</h3>
			
		
		</c:if>
		
		<c:if test="${cart.totalNumberofElements()>0}">
			<p>Total element : ${cart.totalNumberofElements()}</p>
			<form>
			
				<table>
					<tr>
					
						<th>No</th>
						<th>Book</th>
						<th>Book</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Subtotal</th>
						<th>
							<a href=""><b>Clear Cart</b></a>
						</th>
						<th>Clear</th>					
					</tr>
					
					
					
					<c:forEach var="variable" varStatus="status" items="${cart.getItems()}">
						<tr>
						
							<td>${status.index}</td>
							<td>
					
									<img src="data:image/jpg;base64,${variable.key.base64Image}"
									width="84" height="110"/>
					
							</td>
							<td>${variable.key.title}</td>
							<td>${variable.value}</td>					
							<td>${variable.key.price}</td>
							<td>${variable.value * variable.key.price}</td>
							<td><a href="delete_cartitem?id=${variable.key.book_id}">Remove</a></td>	
						</tr>
						
					</c:forEach>
					
					<tr>
					
						<td><br/></td>
					
					</tr>
					
					<tr>
					
						<td></td>
						<td></td>
						<td><b>Total : </b></td>
						<td><b>${cart.totalNumberofBooks()}</b></td>
						<td><b>${cart. totalPriceofBooks()}</b></td>
						<td>
							<input type="button" id="clearbutton" value="Clear All">
						</td>
						
					</tr>
					
					
				</table>
			
			
			</form>
			
			<input type="button" value="Finish Shopping" id="finish" />
		
		</c:if>
		
	
	
	</div>
	
	
	
	
	
	
	
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>

<script type="text/javascript">

	$(document).ready(function(){
		
		
		
		$("#finish").click(function(){
			window.location="finishshopping";
		})
	
	});
	
	
	 
	
	






</script>




</html>