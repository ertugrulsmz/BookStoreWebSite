 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/admin_index.css">
<title>Books by </title>

</head>


<body>
	
	<jsp:include page="header.jsp"/>
	
	<div align="center" style="width: 80%;margin: 0 auto 0 auto;">
		<br/>
		<c:forEach items="${booklist}" var="variable"> 
		
			<div align="center" style="float:left; inline-block;margin: 20px;">
			
				<div>
					<a href="viewbook?id=${variable.book_id}">
						<img src="data:image/jpg;base64,${variable.base64Image}"
						width="110" height="140"/>
					</a>
				</div>
				
				<div>
					<a href="viewbook?id=${variable.book_id}">
						${variable.title}
					</a>
				</div>			
				
				
				<div><i>${variable.author}</i></div>
				<div><b>${variable.price}$</b></div>
					
				<div>
					<c:forTokens items="${variable.getRatingstars()}" delims="," var="variable">
							
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
				</div>				
			
			</div>
		</c:forEach>
		
		</div>
		
			
		
		
		
		
		
		
		
		
			
		
		
	<jsp:include page="footer.jsp"></jsp:include>
		
		
</body>
</html>