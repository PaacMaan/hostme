<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Real Home A Real Estate Category Flat Bootstarp Resposive Website Template | Home_Loan :: w3layouts</title>
<jsp:include page="inc/head.jsp"></jsp:include>
<link href='<spring:url value="${request.getContextPath()}/css/popuo-box.css"></spring:url>' rel="stylesheet" type="text/css" media="all"/>
<script src='<spring:url value="${request.getContextPath()}/js/jquery.magnific-popup.js"></spring:url>' type="text/javascript"></script>
<script src='<spring:url value="${request.getContextPath() }/js/easyResponsiveTabs.js"></spring:url>' type="text/javascript"></script>
</head>
<body>
<!--header-->
<jsp:include page="inc/header.jsp"></jsp:include>
<!--//-->	
<div class=" banner-buying">
	<div class=" container">
	<h3>your<span> profile</span></h3> 
	<!---->
	<jsp:include page="inc/menu.jsp"></jsp:include>
	<div class="clearfix"> </div>
	</div>
</div>
<!--//header-->
<!---->
<div class="loan_single">
	<div class="container">
		<div class="loan-col">
			<h3>Profile</h3>
			<c:if test="${successMsg != null}">
				<div class="alert alert-success alert-dismissable" role="alert">
      				<strong>Done !</strong> ${successMsg }
   				</div>
  			</c:if>
			<center><img src='<spring:url value="${request.getContextPath() }/images/av.png"></spring:url>'></center>
			<h4>General Information</h4>
			<spring:url value="/user/edit_profile" var="edit_profile" htmlEscape="true"></spring:url>
			<form:form method="post" action="${edit_profile }" modelAttribute="user">
				<div class="col-loan">
					<ul class="loan-col1">
						<li><span>username </span></li><label>:</label>
						<li class="loan-list-top">
							<form:input path="username" type="text" placeholder="pacman" required="" />
						</li>
					</ul>
					<ul class="loan-col1">
						<li><span>phone number </span></li><label>:</label>
						<li class="loan-list-top">
							<form:input path="tel" type="text" placeholder="0665839475" required="" />
						</li>
					</ul>
					<ul class="loan-col1">
						<li><span>Email</span> </li><label>:</label>
						<li class="loan-list-top">
							<form:input path="email" type="text" placeholder="email@email.com" disabled="true" />
						</li>
					</ul>
					<ul class="loan-col1">
						<li><span>city</span> </li><label>:</label>
						<li class="loan-list-top">
							<form:input path="ville" type="text" placeholder="casablanca, morocco" required="" />
						</li>
					</ul>
				</div>
				<form:input path="id_user" type="hidden"/>
				<!-- submit the form -->
				<div class="sub">
					<label class="hvr-sweep-to-right"><input type="submit" value="Apply"></label>
				</div>
				<!-- end of submit -->
			</form:form>
			
			<h4 id="security_details_title">Security details</h4>
			<form method="post" action="" id="security_details" >
				<!-- start of property details -->
				<div class="col-loan">
					<ul class="loan-col1">
						<li><span>actual password</span> </li><label>:</label>
						<li class="loan-list-top">
							<input type="password" value="" placeholder="********" required>
						</li>
					</ul>
					<ul class="loan-col1">
						<li><span>new password</span> </li><label>:</label>
						<li class="loan-list-top">
							<input type="password" value="" placeholder="********" required>
						</li>
					</ul>
					<ul class="loan-col1">
						<li><span>Confirm new password</span> </li><label>:</label>
						<li class="loan-list-top">
							<input type="password" value="" placeholder="********" required>
						</li>
					</ul>
				</div>
				<!-- end of property photos -->
				<!-- submit the form -->
				<div class="sub">
					<label class="hvr-sweep-to-right"><input type="submit" value="Apply" placeholder=""></label>
				</div>
				<!-- end of submit -->
			</form>
		</div>
	</div>
</div>
<!--footer-->
<jsp:include page="inc/footer.jsp"></jsp:include>
<!--//footer-->
<script type="text/javascript">
	$(function(){
		$("#security_details").hide();
		$("#security_details_title").click(function(){
			$("#security_details").show();
		})
	})
</script>
</body>
</html>