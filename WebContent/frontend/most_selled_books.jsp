  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div align="center" style="width: 80%;margin: 0 auto 0 auto;">
		
			
		
			<c:forEach items="${mostselledbooks}" var="variable"> 
			
				<div align="center" style="display: inline-block;margin: 10px;">
				
					<div>
						<a href="viewbook?id=${variable.book_id}">
							<img src="data:image/jpg;base64,${variable.base64Image}"
							width="110" height="140"/>
						</a>
					</div>
					
					<div>
						<a href="viewbook?id=${variable.book_id}">
							<div>${variable.title}</div>
						</a>
			
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
				
					
				
				
				</div>
			</c:forEach>
		
		</div>