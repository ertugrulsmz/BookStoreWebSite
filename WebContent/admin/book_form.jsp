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
	
	
	
	<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
	
	
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<div align="center">
		<br/>
		<c:if test="${book!=null}">
			
			<form action="update_book" method="post" id="bookform" enctype="multipart/form-data" >	
			<input type="hidden" name="id" value="${book.book_id}"/>
		</c:if>
		
		<c:if test="${book==null}">
			
			<form action="createbook" method="post" id="bookform" enctype="multipart/form-data">	
		
		</c:if>
		
		
		
		
		<table class="tableforform">
		
			<tr>
			
				<td>Category : </td>
				
				<td>		
					<select name="category" id="category">
				
						<c:forEach var="variable" items="${categoryList}">
							
							
							<c:if test="${selected_category != variable}">
								<p>not ok : ${variable.name}</p>
								<option value="${variable.category_id}">
									${variable.name}
								</option>
							
							</c:if>
							
							<c:if test="${selected_category.name eq variable.name}">
								<p> ok : ${variable.name}</p>
								<option value="${variable.category_id}" selected="selected">
									${variable.name}
								</option>
							
							</c:if>
							
							
							
							
							
										
						
						</c:forEach>
				
				
					</select>
				</td>
			
			</tr>
		
		
			<tr> 
				<td>Title : </td>
				<td><input type="text" value="${book.title}"  size="30" name="title" id="title"/></td>
			</tr>
			
			<tr> 
				<td>Author :  </td>
				<td><input type="text" value="${book.author}" size="30" name="author" id="author"/>  </td>
			</tr>
			
			<tr> 
				<td>ISBN :  </td>
				<td> <input type="text" size="30" value="${book.isbn}" name="isbn" id="isbn"/>  </td>
			</tr>
			
			<tr> 
				<td>Publish Date :  </td>
				<td> <input type="text" size="30" value='<fmt:formatDate
				 pattern="MM/dd/yyyy"	 value="${book.publish_date}"/>'
					 name="publishdate" id="publishdate"/>  </td>
			</tr>
			
			<tr> 
				<td>Book Image :  </td>
				<td> 
					<input type="file" size="30" value="${book.image}"
					 name="bookimage" id="bookimage"/> 
					 <br/> <br/>
					<img alt="book" src="data:image/jpg;base64,${book.base64Image}" width="100" height="150"> 
					 
				 </td>
					 
				
			</tr>
			
			<tr> 
				<td>Price :  </td>
				<td> <input type="text" size="30" value="${book.price}" name="price" id="price"/>  </td>
			</tr>
			
			
			<tr> 
				<td>Description :  </td>
				<td> <textarea cols="50" rows="5" name="description" id="description">
					"${book.description}"</textarea>  </td>
			</tr>
			
			
			
			
			
			
			
			<tr>&nbsp;</tr>
			<tr align="center">
				<td>&nbsp;</td>
				<td colspan="2"> <button type="submit" size="20">Save</button> 
				
				<button  size="20" id="cancelbutton">Cancel</button>   </td>
			</tr>
		
		</table>
	
	</form>
	
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
		
		$( "#publishdate" ).datepicker();
		$('#description').richText();
		
		
		$("#bookform").validate({
			rules:{
				title:"required",
				author:"required",
				isbn:"required",
				price:"required",
				description:"required",
				publishdate:"required",
				
				
				
				
				
			},
			messages:{
				title:"title required",
				author:"title required",
				isbn:"isbn required",
				price:"price required",
				description:"description required",
				publishdate:"publishdate required",
				
				
			}
		});
		
		$("#cancelbutton").click(function(){
			history.go(-1);
		});
		
	});
	
	
	 
	
	




function validateform() {
	var fieldemail=document.getElementById("email");
	var fieldfullname=document.getElementById("fullname");
	var fieldpassword=document.getElementById("password");
	
	if(fieldfullname.value.length==0){
		alert("fullname is required");
		fieldemail.focus();
		return false;
	}
	else if(fieldemail.value.length==0){
		alert("email is required");
		fieldemail.focus();
		return false;
	}
	else if(fieldpassword.value.length==0){
		alert("password is required");
		fieldemail.focus();
		return false;
	}
	
	return true;

}


</script>


</html>