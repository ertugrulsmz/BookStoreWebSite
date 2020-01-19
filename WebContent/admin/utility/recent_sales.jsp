  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div align="center" style="width: 80%;margin: 0 auto 0 auto;">
		
	<table>
	
		<tr>
		
			<th>Customer Name</th>
			<th>Recipient Name</th>
			<th>Recipient Phone</th>
			<th>Shipping Address</th>
			<th>Total Price</th>
			<th>Order Date</th>
		</tr>
		
		<c:if test="${recentsales==null}">
		
			<h1>null</h1>
		
		</c:if>
		
		
		
		
		<c:forEach var="variable" items="${recentsales}"> 
		
			<tr>
				<td>${variable.customer.fullnameString}</td>
				<td>${variable.recipient_name}</td>
				<td>${variable.recipient_phone}</td>
				<td>${variable.shipping_address}</td>	
				<td>${variable.total}</td>
				<td>${variable.order_date}</td>
			</tr>
		
		</c:forEach>
	
	
	
	</table>			
		
		
	

</div>