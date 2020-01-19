<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<link rel="stylesheet" href="js/jquery-ui.min.css">	
	
	
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<div align="center">
	
		<form action="savecomment" method="post" id="commentform">	
	
			<table>
			
				<tr>
					<td>
						<input type="hidden" name="rating" id="rating"/>
						<input type="hidden" name="bookid" value="${book.book_id}">
					</td>
				
				</tr>
			
				<tr>
				
					<td colspan="2"><h1>Add Comment</h1></td>
					<td align="right">${customer.fullnameString}</td>
				</tr>
				
				<tr>
					<td colspan="3"><hr/></td>
				</tr>
				
				<tr>
					<td align="right"><h3>Rating : </h3></td>
					<td colspan="2" align="left"> <div id="rateYo"></div></td>
				
				</tr>
				
				<tr>
				
					<td rowspan="2"><img src="data:image/jpg;base64,${book.base64Image}"
							width="175" height="225"/></td>
						
					<td style="padding-left: 20px;"><h4>Headline : </h4></td>		
					<td style="padding: 10px;"><input type="text" name="headline" size="30"></td>
				
				</tr>
				
				<tr>
					<td style="padding-left: 20px;"><b>Comment :</b></td>
					<td style="padding: 10px;"><textarea rows="5" cols="50" name="comment"></textarea></td>			
				
				</tr>
				
				<tr><td>&nbsp;</td></tr>
				<tr align="center">
					<td>&nbsp;</td>
					<td colspan="2"> <button type="submit">Save</button> 
					
					<button id="cancelbutton">Cancel</button>   </td>
				</tr>
			
			
			</table>
			
		
		</form>
	
	</div>
	
	
						
	<jsp:include page="footer.jsp"></jsp:include>
</body>

<script type="text/javascript">

	$(document).ready(function(){
		
		
		
		
		
		$("#commentform").validate({
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
		
		$("#rateYo").rateYo({
		    starWidth:"40px",
		    fullStar : true,
		    onSet: function (rating,rateYoInstance){
		    	$("#rating").val(rating);
		    }
		 });
	});
	
	
	 
	
	






</script>








</html>