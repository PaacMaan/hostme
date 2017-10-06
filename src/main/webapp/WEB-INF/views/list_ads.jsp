<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<title>Real Home A Real Estate Category Flat Bootstarp Resposive Website Template | Buy_Single :: w3layouts</title>
<jsp:include page="inc/head.jsp"></jsp:include>
</head>
<body>
<!--header-->
	<jsp:include page="inc/header.jsp"></jsp:include>
<!--//-->	
<div class=" banner-buying">
	<div class=" container">
	<h3>Find the right <span>deal</span> </h3> 
	<!---->
	<jsp:include page="inc/menu.jsp"></jsp:include>
	<div class="clearfix"> </div>
	</div>
</div>
<!--//header-->
<!---->
<div class="single">
<!---->
<div class="container">
	
	<div class="buy-single">
		<h3>Residential Flats, Apartments</h3>
		<div class="box-sin">
			<div class="col-md-9 single-box">
			<c:forEach items="${ads_list }" var="ad">
				<div class="box-col">
				     <div class=" col-sm-7 left-side ">
						<a href='<spring:url value="${request.pageContext()}/ad/${ad.id_ad } "></spring:url>'> <img class="img-responsive" src="${pageContext.request.contextPath}/upload/${ad.photos[0].url }" alt=""></a>
					</div>				
					<div class="col-sm-5 middle-side">
					     <h4><a href='<spring:url value="${request.pageContext()}/ad/${ad.id_ad } "></spring:url>'>${ad.titre }</a></h4>
					     <p><span class="bath">Area </span>: <span class="two">${ad.property.surface } m²</span></p>
					     <p><span class="bath1">City </span>: <span class="two">${ad.property.ville }</span></p>
					     <p><span class="bath3">Photos </span>:<span class="two"> ${fn:length(ad.photos)}</span></p>
						 <p><span class="bath5">Price </span>:<span class="two"> ${ad.property.price } DH</span></p>				 
						<div class="   right-side">
							 <a href='<spring:url value="${request.pageContext()}/ad/${ad.id_ad } "></spring:url>' target="_blank" class="hvr-sweep-to-right more" >More details</a>     
						 </div>
					 </div>
				 <div class="clearfix"> </div>
				</div>
			</c:forEach>
			</div>
		</div>
		<div class="col-md-3 map-single-bottom">
			<div class="map-single">
						<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d37494223.23909492!2d103!3d55!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x453c569a896724fb%3A0x1409fdf86611f613!2sRussia!5e0!3m2!1sen!2sin!4v1415776049771"></iframe>
			</div>
			<div class="single-box-right">
		     	<h4>Featured Communities</h4>
				<div class="single-box-img">
					<div class="box-img">
						<a href="single.html"><img class="img-responsive" src="images/sl.jpg" alt=""></a>
					</div>
					<div class="box-text">
						<p><a href="single.html">Lorem ipsum dolor sit amet</a></p>
						<a href="single.html" class="in-box">More Info</a>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="single-box-img">
					<div class="box-img">
						<a href="single.html"><img class="img-responsive" src="images/sl1.jpg" alt=""></a>
					</div>
					<div class="box-text">
						<p><a href="single.html">Lorem ipsum dolor sit amet</a></p>
						<a href="single.html" class="in-box">More Info</a>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="single-box-img">
					<div class="box-img">
						<a href="single.html"><img class="img-responsive" src="images/sl2.jpg" alt=""></a>
					</div>
					<div class="box-text">
						<p><a href="single.html">Lorem ipsum dolor sit amet</a></p>
						<a href="single.html" class="in-box">More Info</a>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="single-box-img">
					<div class="box-img">
						<a href="single.html"><img class="img-responsive" src="images/sl3.jpg" alt=""></a>
					</div>
					<div class="box-text">
						<p><a href="single.html">Lorem ipsum dolor sit amet</a></p>
						<a href="single.html" class="in-box">More Info</a>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="single-box-img">
					<div class="box-img">
						<a href="single.html"><img class="img-responsive" src="images/sl4.jpg" alt=""></a>
					</div>
					<div class="box-text">
						<p><a href="single.html">Lorem ipsum dolor sit amet</a></p>
						<a href="single.html" class="in-box">More Info</a>
					</div>
					<div class="clearfix"> </div>
				</div>
		 </div>
	  </div>
		<div class="clearfix"> </div>
		<!-- start pagination test  -->
			<jsp:include page="inc/pagination.jsp"></jsp:include>
		<!-- end pagination -->
		</div>
		
	</div>
	
</div>
<!---->
<!--footer-->
<jsp:include page="inc/footer.jsp"></jsp:include>
<!--//footer-->
</body>
</html>