 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div align="center">
		<a href="/BookStoreWebSite"><img src="newimages/BookstoreAdminLogo.png"/></a>
</div>
	
<div align="center">

	<form action="searchresult" method="get">
		<input type="text" name="search" size="50" />
		<input type="submit" value="search" />
	</form>
	
	
	&nbsp;&nbsp;&nbsp;
	
	
	<c:if test="${customer!=null}">
		
		<a href="yourprofile">${customer.fullnameString}'s Profile</a> |
		<a href="logout">Log Out</a> |	
		
	</c:if>
	
	<c:if test="${customer==null}">
		
		<a href="login">Sign in</a> |
		<a href="register">Register</a> |
		
	</c:if>
	
	
	<a href="register">Register</a> |
	<a href="viewcart">Cart</a> 
	
	<br/><br/>
	
	<div align="center">
	
		<c:forEach var="variable" items="${categorylist}" varStatus="status">
		
			<b><a href="showbooks?id=${variable.category_id}">${variable.name}</a></b>
			
			<c:if test="${not status.last}">
			
			&nbsp; | &nbsp;
			
			</c:if>
		
		
		</c:forEach>
	
	</div>
	
</div>	