<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<c:set var="customer" value="${sessionScope['customer']}"/>
	<c:set var="cart" value="${sessionScope['cart']}"/>
	
	<br/>
	<div align="center">
		
		
		
		<p>Total element : ${cart.totalNumberofElements()}</p>
		
			<table>
				<tr>
				
					<th>No</th>
					<th>Book</th>
					<th>Book</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Subtotal</th>				
				</tr>
				
				
				
				<c:forEach var="variable" varStatus="status" items="${cart.getItems()}">
					<tr>
					
						<td>${status.index}</td>
						<td>
				
								<img src="data:image/jpg;base64,${variable.key.base64Image}"
								width="63" height="73"/>
				
						</td>
						<td>${variable.key.title}</td>
						<td>${variable.value}</td>					
						<td>${variable.key.price}</td>
						<td>${variable.value * variable.key.price}</td>
						
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
					
					
				</tr>
				
				
			</table>
		
		
		<br/>
	
		<form action="endofshopping" method="post" id="endofshopping">
			
			
			
			<table>
			
				<tr>
					<td>Recipient Name : </td>
					<td><input value="${customer.fullnameString}" name="name"></td>
				</tr>		
				
				<tr>
					<td>Country : </td>
					<td><input value="${customer.countryString}" name="country"></td>
				</tr>
				
				<tr>
					<td>City : </td>
					<td><input value="${customer.cityString}" name="city"></td>
				</tr>
				
				<tr>
					<td> Zipcode : </td>
					<td><input value="${customer.zipcodeString}" name="zipcode"></td>
				</tr>
				
				<tr>
					<td>Shipping Adress : </td>
					<td><textarea rows="4" cols="50" name="address">${customer.addressString}</textarea></td>
				</tr>
				
				<tr>
					<td>Recipient Phone : </td>
					<td><input value="${customer.phoneString}" name="phone"></td>
				</tr>
				
				<tr>
					<td>Payment Method : </td>
					<td>
						<select name="pay" id="pay">
							<option  value="Pay at the Door">Pay at the Door</option>
						</select>
					</td>
				</tr>
				
				<tr>
					
					<td colspan="2" align="center"><input type="submit" value="Submit"></td>
				
				</tr>
				
			</table>
		
		
	
		
		</form>	
		
		<br/>
		
		
	</div>	
		
		
	<jsp:include page="footer.jsp"></jsp:include>

</body>


<script type="text/javascript">

$(document).ready(function(){
	
	$("#endofshopping").validate({
		rules:{
			name:"required",
			country:"required",
			city:"required",
			zipcode:"required",
			address:"required",
			phone:"required",
			pay:"required"
		},
		messages:{
			name:"name required",
			country:"country required",
			city:"city required",
			zipcode:"zipcode required",
			address:"address required",
			phone:"phone required",
			pay:"pay required"
		}
	});
	
	
	
});







</script>






</html>