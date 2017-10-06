<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div class="nav-page">
	<nav>
		<ul class="pagination">
   			<c:if test="${maxPages <= 5 }">
   				<spring:url value="" var="prev">
   					<spring:param name="page" value="${page-1 }"></spring:param>
   					<c:if test="${location != null }">
   						<spring:param name="location" value="${location }"></spring:param>
   					</c:if>
   				</spring:url>
    			<c:if test="${page > 1}">
        			<li><a href="<c:out value="${prev}" />" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
    			</c:if>
 				<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
		        	<c:choose>
		        		<c:when test="${page == i.index}">
		        			<li class="active"><a>${i.index} <span class="sr-only">(current)</span></a></li>
		        		</c:when>
		        		<c:otherwise>
			                <spring:url value="" var="url">
			                	<spring:param name="page" value="${i.index }"></spring:param>
			                	<c:if test="${location != null }">
			   						<spring:param name="location" value="${location }"></spring:param>
			   					</c:if>
			                </spring:url>
			                <li><a href='<c:out value="${url}" />'>${i.index}</a></li>
			            </c:otherwise>
		        	</c:choose>
	        	</c:forEach>
			    <spring:url value="" var="next">
                	<spring:param name="page" value="${page + 1}"></spring:param>
                	<c:if test="${location != null }">
   						<spring:param name="location" value="${location }"></spring:param>
   					</c:if>
                </spring:url>
			    <c:if test="${page + 1 <= maxPages}">
			        <li><a href='<c:out value="${next}" />' aria-label="Next"><span aria-hidden="true">»</span></a></li>
			    </c:if>
  			</c:if>
    		<c:if test="${maxPages > 5 }">
    			<c:choose>
 					<c:when test="${page > maxPages }">
 						<!-- forward to the maxPages -->
 					</c:when>
    				<c:when test="${page == maxPages || page == maxPages - 1 || page == maxPages - 2  }">
						<spring:url value="" var="prev">
		                	<spring:param name="page" value="${page-1 }"></spring:param>
		                	<c:if test="${location != null }">
		   						<spring:param name="location" value="${location }"></spring:param>
		   					</c:if>
		                </spring:url>
						<c:if test="${page > 1}">
							<li><a href="<c:out value="${prev}" />" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						</c:if>
						<li><a href="?page=1">1</a></li>
						<li><a>...<span class="sr-only">...</span></a></li>
						<c:forEach begin="${page-2 }" end="${maxPages}" step="1" varStatus="i">
							<c:choose>
								<c:when test="${page == i.index}">
									<li class="active"><a>${i.index} <span class="sr-only">(current)</span></a></li>
								</c:when>
								<c:otherwise>
						            <spring:url value="" var="url">
		                				<spring:param name="page" value="${i.index }"></spring:param>
		                				<c:if test="${location != null }">
					   						<spring:param name="location" value="${location }"></spring:param>
					   					</c:if>
		                			</spring:url>
						            <li><a href='<c:out value="${url}" />'>${i.index }</a></li>
						        </c:otherwise>
							</c:choose>
						</c:forEach>
						<spring:url value="" var="next">
               				<spring:param name="page" value="${page + 1 }"></spring:param>
               				<c:if test="${location != null }">
		   						<spring:param name="location" value="${location }"></spring:param>
		   					</c:if>
               			</spring:url>
						<c:if test="${page + 1 <= maxPages}">
						    <li><a href='<c:out value="${next}" />' aria-label="Next"><span aria-hidden="true">»</span></a></li>
						</c:if>
  					</c:when>
  					<c:when test="${page == null || page == 1 || page ==2 }">
						<spring:url value="" var="prev">
               				<spring:param name="page" value="${page -1 }"></spring:param>
               				<c:if test="${location != null }">
		   						<spring:param name="location" value="${location }"></spring:param>
		   					</c:if>
               			</spring:url>
						<c:if test="${page > 1}">
							<li><a href="<c:out value="${prev}" />" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						</c:if>
   						<c:forEach begin="1" end="${page+2}" step="1" varStatus="i">
   							<c:choose>
								<c:when test="${page == i.index}">
									<li class="active"><a>${i.index} <span class="sr-only">(current)</span></a></li>
								</c:when>
								<c:otherwise>
						            <spring:url value="" var="url">
               							<spring:param name="page" value="${i.index }"></spring:param>
               							<c:if test="${location != null }">
					   						<spring:param name="location" value="${location }"></spring:param>
					   					</c:if>
               						</spring:url>
						            <li><a href='<c:out value="${url}" />'>${i.index}</a></li>
						        </c:otherwise>
							</c:choose>
   						</c:forEach>
  						<li><a>...<span class="sr-only">...</span></a></li>
  						<li><a href="?page=${maxPages }">${maxPages }</a></li>
						<spring:url value="" var="next">
               				<spring:param name="page" value="${page + 1 }"></spring:param>
               				<c:if test="${location != null }">
		   						<spring:param name="location" value="${location }"></spring:param>
		   					</c:if>
               			</spring:url>
						<c:if test="${page + 1 <= maxPages}">
							<li><a href='<c:out value="${next}" />' aria-label="Next"><span aria-hidden="true">»</span></a></li>
						</c:if>
    				</c:when>
    				<c:otherwise>
						<spring:url value="" var="prev">
               				<spring:param name="page" value="${page - 1 }"></spring:param>
               				<c:if test="${location != null }">
		   						<spring:param name="location" value="${location }"></spring:param>
		   					</c:if>
               			</spring:url>
						<c:if test="${page > 1}">
							<li><a href="<c:out value="${prev}" />" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						</c:if>
  						<li><a href="?page=1">1</a></li>
						<li><a>...<span class="sr-only">...</span></a></li>
						<c:forEach begin="${page-1 }" end="${page+2}" step="1" varStatus="i">
							<c:choose>
								<c:when test="${page == i.index}">
									<li class="active"><a>${i.index} <span class="sr-only">(current)</span></a></li>
								</c:when>
								<c:otherwise>
						            <spring:url value="" var="url">
               							<spring:param name="page" value="${i.index }"></spring:param>
               							<c:if test="${location != null }">
					   						<spring:param name="location" value="${location }"></spring:param>
					   					</c:if>
               						</spring:url>
						            <li><a href='<c:out value="${url}" />'>${i.index}</a></li>
							        </c:otherwise>
								</c:choose>
							</c:forEach>
							<li><a>...<span class="sr-only">...</span></a></li>
							<li><a href="?page=${maxPages }">${maxPages }</a></li>
							<spring:url value="" var="next">
               					<spring:param name="page" value="${page + 1 }"></spring:param>
               					<c:if test="${location != null }">
			   						<spring:param name="location" value="${location }"></spring:param>
			   					</c:if>
               				</spring:url>
							<c:if test="${page + 1 <= maxPages}">
							    <li><a href='<c:out value="${next}" />' aria-label="Next"><span aria-hidden="true">»</span></a></li>
							</c:if>
   						</c:otherwise>
   					</c:choose>
   				</c:if>
     	</ul>
	</nav>
</div>