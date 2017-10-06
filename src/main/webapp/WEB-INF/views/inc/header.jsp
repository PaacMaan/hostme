<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--header-->
<div class="navigation">
	<div class="container-fluid">
		<nav class="pull">
			<ul>
				<li><a  href='<spring:url value="/home"></spring:url>'>Home</a></li>
				<li><a  href="about.html">About Us</a></li>
				<li><a  href="blog.html">Blog</a></li>
				<li><a  href="terms.html">Terms</a></li>
				<li><a  href="privacy.html">Privacy</a></li>
				<li><a  href="contact.html">Contact</a></li>
			</ul>
		</nav>	
	</div>	
</div>			

<div class="header">
	<div class="container">
		<!--logo-->
			<div class="logo">
				<h1><a href='<spring:url value="/home"></spring:url>'>REAL HOME</a></h1>
			</div>
		<!--//logo-->
		<div class="top-nav">
			<c:choose>
				<c:when test="${not empty pageContext.request.userPrincipal.name}">
    				<ul class="right-icons">
						<li><a  href='<spring:url value="/user/profile"></spring:url>'><i class="glyphicon glyphicon-user"> </i> ${pageContext.request.userPrincipal.name}</a></li>
						<li><a href='<spring:url value="/logout"></spring:url>'><i class="glyphicon glyphicons-log-out"> </i> Log out</a></li>
						<li><a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i> </a></li>
					</ul>
				</c:when>
				<c:otherwise>
    				<ul class="right-icons">
						<li><a  href='<spring:url value="/login"></spring:url>'><i class="glyphicon glyphicon-user"> </i> Login</a></li>
						<li><a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i> </a></li>
					</ul>
  				</c:otherwise>
			</c:choose>
			<div class="nav-icon">
				<div class="hero fa-navicon fa-2x nav_slide_button" id="hero">
						<a href="#"><i class="glyphicon glyphicon-menu-hamburger"></i> </a>
					</div>	
				<!---
				<a href="#" class="right_bt" id="activator"><i class="glyphicon glyphicon-menu-hamburger"></i>  </a>
			--->
			</div>
		<div class="clearfix"> </div>
			<!---pop-up-box---->
			   
				<link href='<spring:url value="${request.getContextPath()}/css/popuo-box.css"></spring:url>' rel="stylesheet" type="text/css" media="all"/>
				<script src='<spring:url value="${request.pageContext }/js/jquery.magnific-popup.js"></spring:url>' type="text/javascript"></script>
			<!---//pop-up-box---->
				<div id="small-dialog" class="mfp-hide">
					    <!----- tabs-box ---->
				<div class="sap_tabs">	
				     <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
						  <ul class="resp-tabs-list">
						  	  <li class="resp-tab-item " aria-controls="tab_item-0" role="tab"><span>All Homes</span></li>
							  <li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>For Sale</span></li>
							  <li class="resp-tab-item" aria-controls="tab_item-2" role="tab"><span>For Rent</span></li>
							  <div class="clearfix"></div>
						  </ul>				  	 
						  <div class="resp-tabs-container">
						  		<h2 class="resp-accordion resp-tab-active" role="tab" aria-controls="tab_item-0"><span class="resp-arrow"></span>All Homes</h2><div class="tab-1 resp-tab-content resp-tab-content-active" aria-labelledby="tab_item-0" style="display:block">
								 	<div class="facts">
									  	<div class="login">
									  		<spring:url value="/search/allads/" var="searchUrl" htmlEscape="true"></spring:url>
									  		<form:form method="GET" action="${searchUrl }">
									  			<input type="text" name="location" value="" >		
									 			<input type="submit" value="">
									  		</form:form>
									 	</div>        
							        </div>
						  		</div>
							     <h2 class="resp-accordion" role="tab" aria-controls="tab_item-1"><span class="resp-arrow"></span>For Sale</h2><div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
									<div class="facts">									
										<div class="login">
											<input type="text" value="Search Address, Neighborhood, City or Zip" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search Address, Neighborhood, City or Zip';}">		
									 		<input type="submit" value="">
									 	</div> 
							        </div>	
								 </div>									
							      <h2 class="resp-accordion" role="tab" aria-controls="tab_item-2"><span class="resp-arrow"></span>For Rent</h2><div class="tab-1 resp-tab-content" aria-labelledby="tab_item-2">
									 <div class="facts">
										<div class="login">
											<input type="text" value="Search Address, Neighborhood, City or Zip" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search Address, Neighborhood, City or Zip';}">		
									 		<input type="submit" value="">
									 	</div> 
							         </div>	
							    </div>
					      </div>
					 </div>
					 <script src='<spring:url value="${request.pageContext}/js/easyResponsiveTabs.js"></spring:url>' type="text/javascript"></script>
				    	<script type="text/javascript">
						    $(document).ready(function () {
						        $('#horizontalTab').easyResponsiveTabs({
						            type: 'default', //Types: default, vertical, accordion           
						            width: 'auto', //auto or any width like 600px
						            fit: true   // 100% fit in a container
						        });
						    });
			  			 </script>	
				</div>
				</div>
				 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>
					
	
		</div>
		<div class="clearfix"> </div>
		</div>	
</div>