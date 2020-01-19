 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<title>Books by </title>

</head>


<body>
	
	<jsp:include page="header.jsp"/>
	
	
	<table style="margin-right:200px;margin-left: 70px;margin-top: 30px;table-layout: fixed;">
	
		<tr>	
			<th align="center">${book.title}</th>
		</tr>
		
		<tr>	
			<td align="center">by ${book.author}</td>
		</tr>
		
		<tr>
		
			<td rowspan="2" align="center" valign="middle">
				<img src="data:image/jpg;base64,${book.base64Image}"
						width="175" height="225"/>
			</td>
			
			<td valign="middle" style="width: 200px">
				<c:forTokens items="${book.getRatingstars()}" delims="," var="variable">
							
							<c:if test="${variable eq 'on'}">
								<img src="newimages/rating-on.png"/>
							</c:if>
							
							<c:if test="${variable eq 'half'}">
								<img src="newimages/rating-half.png"/>
							</c:if>
								
							<c:if test="${variable eq 'of'}">
								<img src="newimages/rating-off.png"/>
							</c:if>
							
				</c:forTokens>
				<b>${book.pointAverageofReview()}</b>
				<br/>
				<a href="#reviews">${fn:length(book.reviews)} Reviews</a>				
			</td>
			
		
			
			
			
			<td style="padding-left: 30px;">
				<h3>${book.price}$</h3>
			</td>
			
			
		
		</tr>
		
		<tr>
			<td colspan="1" style="width: 900px" valign="top" align="left">
				<p>${book.description}</p>
			</td>
			
			<td valign="top" style="padding-left: 30px;">
				<button id="addcart">Add to Cart</button>
			</td>
			
			
		</tr>
		
		<tr>
			<td><h2>Customer's Review</h2></td>
			<td><input type="submit" value="Add Comment" id="addcomment"></td>
		</tr>
		
		
		
		<tr>
			<td colspan="3" align="left">
			
				<table id="reviews">
				
					
					
					<c:forEach items="${book.reviews}" var="variable">
					
						<tr>
						  <td>
								<c:forTokens items="${variable.getStarString()}" delims="," var="variableinner">
									
									<c:if test="${variableinner eq 'on'}">
										<img src="newimages/rating-on.png"/>
									</c:if>
									
									<c:if test="${variableinner eq 'of'}">
										<img src="newimages/rating-off.png"/>
									</c:if>
								
								
								</c:forTokens>
							</td>
							
							<td>
								<b>${variable.headline}</b>
							</td>
							
						</tr>
						
						<tr>
							<td>by ${variable.customer_class.fullnameString}</td>
							<td> &nbsp; on ${variable.review_time}</td>
						</tr>
						
						<tr>
							<td><i>${variable.comment}</i></td>
						
						</tr>
						<tr><td><br/></td></tr>
					</c:forEach>
					
					
					
					
				
				</table>
			
			</td>
		
		
		</tr>
		
		
	
	
	
	</table>
	
				
		
		
	<jsp:include page="footer.jsp"></jsp:include>
		
		
</body>


<script type="text/javascript">

	$(document).ready(function(){
		
		$("#addcomment").click(function(){
			window.location="addcomment?bookid="+${book.book_id};
		})
		
		$("#addcart").click(function(){
			window.location="addcart?bookid="+${book.book_id};
		})
	
	});
	
	
	 
	
	






</script>










</html>