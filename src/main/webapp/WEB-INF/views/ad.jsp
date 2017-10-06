<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Real Home A Real Estate Category Flat Bootstarp Resposive Website Template | Single :: w3layouts</title>
<jsp:include page="inc/head.jsp"></jsp:include>
<style type="text/css">
	#map{height: 100%}
</style>
</head>
<body>
<!-- include header -->
<jsp:include page="inc/header.jsp"></jsp:include>
<!-- end include -->	
<div class=" banner-buying">
	<div class=" container">
	<h3>${ad.titre }</h3> 
	<!---->
	<div class="clearfix"> </div>
		
      		
	</div>
</div>
<!--//header-->

<!-- container-->
<div class="container">
	<div class="buy-single-single">
		<div class="col-md-9 single-box">
       		<div class=" buying-top">	
				<div class="flexslider">
				  <ul class="slides">
				  	<c:forEach items="${ad.photos}" var="photo">
				  		<li data-thumb='<spring:url value="${request.pageContext }/upload/${photo.url }"></spring:url>'>
				      		<img src='<spring:url value="${request.pageContext }/upload/${photo.url }"></spring:url>'  />
				   		 </li>
				  	</c:forEach>
				  </ul>
				</div>
				
<!-- FlexSlider -->
<script defer src='<spring:url value="${request.getContextPath()}/js/jquery.flexslider.js"></spring:url>'></script>
<link rel="stylesheet" href='<spring:url value="${request.getContextPath()}/css/flexslider.css"></spring:url>' type="text/css" media="screen" />
<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>
			</div>
			<div class="buy-sin-single">
				<div class="col-sm-5 middle-side immediate">
				     <h4>Ad details :</h4>
				     <p><span class="bath">Category </span>  :<span class="two">${ad.categ.libelle }</span></p>
				     <p><span class="bath">Reason </span>  :<span class="two">${ad.reason}</span></p>
					 <br>
					 <h4>Property details :</h4>
				     <p><span class="bath">Location </span>  :<span class="two" id="location">${ad.property.ville }</span></p>
				     <p><span class="bath1">Adress </span>: <span class="two">${ad.property.adress }</span></p>
				     <p><span class="bath">Surface </span>: <span class="two">${ad.property.surface } m²</span></p>
				     <p><span class="bath1">Price </span>: <span class="two">${ad.property.price } DH</span></p>		
					<div class="   right-side">
						 <!-- <a href="contact.html" class="hvr-sweep-to-right more" >Contact Builder</a> -->
				 	</div>
				 </div>
				 <div class="col-sm-7 buy-sin">
				 	<h4>Description</h4>
				 	<p>${ad.description }</p>
				 </div>
				 <div class="clearfix"> </div>
				<br>
			</div>
		</div>
		
		<div class="col-md-3 middle-side">
			<h4>Publisher info :</h4>
		 	<div class="panel">
				<div class="panel-heading panel-heading-small">
					<i class="glyphicon glyphicon-user"></i> <strong><b> ${ad.publisher.fullName } </b></strong>
				</div>
				<div class="panel-main">
					<div class="panel-body list-big list-big-icons panel-body-smallpadding">
						<ul>
							<li>
								<strong><b class="font-normal fs13 lh30 no-margin"><i class="glyphicon glyphicon-map-marker"></i> ${ad.publisher.ville }</b></strong>
							</li><br>
							<li>
								<i class="glyphicon glyphicon-time"></i>
								<abbr class="date dtstart value" title="${ad.date_pub }">
								<fmt:formatDate value="${ad.date_pub }" type="date"/> 
								</abbr>
							</li>
						</ul>
					</div>
					<div class="panel-footer text-center">
						<a class="btn btn-block btn-yellow track-click store"><i class="glyphicon glyphicon-earphone"></i> ${ad.publisher.tel}</a>
						<div data-keyboard="true" class="btn-block text-center hide lh36"><i class="fonticon-phone"></i> <img id="AdPhonenum" class="AdPhonenum" alt="#" src="/pg/0wjiX1Wmi9HTSAIWaaeVoy6JLhKPgsu4NDDI=.gif"></div>
					</div>
				</div>
			</div>
			<h4>Where exactly :</h4>
			<div class="panel">
				<div id="map" style="width: 220px;height: 400px;position: relative;"> </div>
			</div>
	    </div>
		
	  <div class="clearfix"> </div>
	</div>
</div>
<!-- end container-->

<!--footer-->
<jsp:include page="inc/footer.jsp"></jsp:include>
<!-- end footer-->
<script>
    var map;
    var infowindow;
    function initMap() {
        var loc = $('#location').text();
        var geocoder = new google.maps.Geocoder();
        geocoder.geocode({
            'address': loc
        }, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                x = results[0].geometry.location.lat();
                y = results[0].geometry.location.lng();
                var pyrmont = new google.maps.LatLng(x,y);
                map = new google.maps.Map(document.getElementById('map'), {
                    center: pyrmont,
                    zoom: 8
                });
                
                var marker = new google.maps.Marker({
                    position: pyrmont,
                    map: map,
                    title: 'Hello World!'
                  });
            } else {
                alert("Not an addres " + status);
            }
        });
      }
    </script>
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?v=3&key=AIzaSyAwAAG_IJ9GVirsxg3XMyUXRHHQlElUJDM&sensor=false&callback=initMap&libraries=places"></script>
</body>
</html>