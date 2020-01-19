  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div align="center" style="width: 80%;margin: 0 auto 0 auto;">
		
	<table>
	
		<tr>
		
			<th>Book Title</th>
			<th>Customer Name</th>
			<th>Rating</th>
			<th>Headline</th>
			<th>Comment</th>
			<th>Review Time</th>
		</tr>
		
		<c:if test="${recentreviews==null}">
		
			<h1>null</h1>
		
		</c:if>
		
		
		
		
		<c:forEach var="variable" items="${recentreviews}"> 
		
			<tr>
				<td>${variable.book.title}</td>
				<td>${variable.customer_class.fullnameString}</td>
				<td>${variable.rating}</td>
				<td>${variable.headline}</td>	
				<td>${variable.comment}</td>
				<td>${variable.review_time}</td>
			</tr>
		
		</c:forEach>
	
	
	
	</table>			
		
		
	

</div>