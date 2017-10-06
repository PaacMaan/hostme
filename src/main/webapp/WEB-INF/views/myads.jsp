<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<title>Real Home A Real Estate Category Flat Bootstarp Resposive Website Template | My ads </title>
<jsp:include page="inc/head.jsp"></jsp:include>
</head>
<body>
<!-- start header -->
<jsp:include page="inc/header.jsp"></jsp:include>
<!-- end header -->
<!--//-->	
<div class=" banner-buying">
	<div class=" container">
	<h3>My <span>Ads</span></h3> 
	<jsp:include page="inc/menu.jsp"></jsp:include>
	<div class="clearfix"> </div>
	</div>
</div>
<!--//header-->
<!--Dealers-->
<div class="dealers">
<div class="container">
	<c:choose>
		<c:when test="${not empty messageDelete}">
			<div class="alert ${alert } alert-dismissable" role="alert">
  				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
     		 ${messageDelete }
     		</div>
		</c:when>
		<c:when test="${not empty addingMessage}">
			<div class="alert alert-success alert-dismissable" role="alert">
	  			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	     		 ${addingMessage }
	     	</div>
		</c:when>
		<c:when test="${empty ads_list }">
			<div class="alert alert-info alert-dismissable" role="alert">
	  			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	     		 your ads list is empty, share with us your needs
	     	</div>
		</c:when>
	</c:choose>
	<h3>My Ads</h3>
	<div class="dealer-top">
		<h4>Recent Ads</h4>
		<div class="deal-top-top">
			<c:forEach items="${ads_list }" var="ad">
				<div class="col-md-3 top-deal-top">
					<div class=" top-deal">
						<a href='<spring:url value="user/ad/${ad.id_ad }"></spring:url>' class="mask"><img src='<spring:url value="${request.pageContext }/upload/${ad.photos[0].url }"></spring:url>' class="img-responsive zoom-img" alt=""></a>
						<div class="deal-bottom">
							<div class="top-deal1">
								<c:choose>
									<c:when test = "${fn:length(ad.titre) > 19}">
            							<c:set var = "title" value = "${fn:substring(ad.titre, 0, 13)} ..."/>
         							</c:when>
         							<c:otherwise>
							            <c:set var="title" value="${ad.titre }"></c:set>
							         </c:otherwise>
								</c:choose>
								<h5><a href='<spring:url value="ad/${ad.id_ad }"></spring:url>' title="${ad.titre }">${title }</a></h5>
								<p>Plot Area : ${ad.property.surface } m²</p>
								<p>Price: ${ad.property.price } DH</p>
							</div>
							<div class="top-deal2">
								<div class="btn-group btn-group-sm">
	                                <a href="javascript:void(0)" class="btn btn-sm btn-primary dropdown-toggle enable-tooltip" data-toggle="dropdown" title="" data-original-title="Options" aria-expanded="false"><span class="caret"></span></a>
	                                <ul class="dropdown-menu dropdown-custom dropdown-menu-right">
	                                    <li>
	                                        <a href="edit_ad/${ad.id_ad }"><i class="gi gi-cloud pull-right"></i>update</a>
	                                        <a href="#modal-regular-${ad.id_ad }" data-toggle="modal"><i class="gi gi-airplane pull-right"></i>delete</a>
	                                    </li>
	                                </ul>
	                            </div>
							</div>
						<div class="clearfix"> </div>
						</div>
						<div id="modal-regular-${ad.id_ad }" class="modal fade in" tabindex="-1" role="dialog" aria-hidden="true">
						    <div class="modal-dialog">
						        <div class="modal-content">
						            <div class="modal-header dealer-top">
						                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						                <h4>Delete Ad</h4>
						            </div>
						            <div class="modal-body">
						                Do you really want to delete this ad !!
						            </div>
						            <div class="modal-footer">
						                <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">Dismiss</button>
					                	<a href="delete_ad/${ad.id_ad }" class="btn btn-sm btn-danger" >delete</a>
						            </div>
						        </div>
						    </div>
						</div>
					</div><br/>
				</div>
			</c:forEach>
			<div class="clearfix"> </div>
			<!-- start pagination test  -->
			<jsp:include page="inc/pagination.jsp"></jsp:include>
			<!-- end pagination -->
		</div>	
	</div>
</div>
</div>
<!--footer-->
<jsp:include page="inc/footer.jsp"></jsp:include>
</body>
</html>