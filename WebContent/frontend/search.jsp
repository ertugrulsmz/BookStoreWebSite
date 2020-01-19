<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp"/>
	<br/>
	
	
	
	<c:forEach items="${booklist}" var="book">
		<table style="margin:2px auto;width: 70%;" border="3" rules="none">
			<tr>
				<td rowspan="2" style="padding-right: 20px;width: 150px"><a  href="viewbook?id=${book.book_id}">
					<img src="data:image/jpg;base64,${book.base64Image}"
							width="110" height="160"/></a>
				</td>
				
				<td valign="top" align="left">
				
					<b><a href="viewbook?id=${book.book_id}">${book.title}</a></b>
					
				</td>	
				
				<td style="padding-left: 30px;">
				<h3>${book.price}$</h3>
				</td>
			
			</tr>
			
			<tr>
				<td valign="top">
				<p>Rating*** <br/>
				by ${book.author}</p>
				<p>${fn:substring(book.description,0,100)}...</p>
				
				</td>
				
				<td valign="top" style="padding-left: 30px;">
				<button>Add to Cart</button>
				</td>
			</tr>
			
	</table>
	</c:forEach>
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>