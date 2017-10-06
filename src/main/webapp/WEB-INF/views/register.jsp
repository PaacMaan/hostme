<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Real Home A Real Estate Flat Bootstarp Resposive Website Template | Register :: w3layouts</title>
<jsp:include page="inc/head.jsp"></jsp:include>
</head>
<body>
	<!-- start header  -->
	<jsp:include page="inc/header.jsp"></jsp:include>
	<!-- end header -->
<!--//-->	
<div class=" banner-buying">
	<div class=" container">
	<h3><span>Regis</span>ter</h3> 
	<div class="clearfix"> </div>
	</div>
</div>
<!--//header-->
<!--contact-->
<div class="login-right">
	<div class="container">
		<h3>Register</h3>
		<div class="login-top">
				<ul class="login-icons">
					<li><a href="#" ><i class="facebook"> </i><span>Facebook</span></a></li>
					<li><a href="#" class="twit"><i class="twitter"></i><span>Twitter</span></a></li>
					<li><a href="#" class="go"><i class="google"></i><span>Google +</span></a></li>
					<li><a href="#" class="in"><i class="linkedin"></i><span>Linkedin</span></a></li>
					<div class="clearfix"> </div>
				</ul>
				<div class="form-info">
				<spring:url value="/user/register" var="registerUrl" htmlEscape="true"></spring:url>
					<form:form action="${registerUrl }" method="post" modelAttribute="user">
						<form:errors path="fullName" cssClass="text-danger"></form:errors>
						<form:input type="text" path="fullName" placeholder="Full Name" required="required" />
						<form:errors path="username" cssClass="text-danger"></form:errors>
						<form:input type="text" path="username" placeholder="User Name" required="required" />
						<form:errors path="email" cssClass="text-danger"></form:errors>
						<form:input type="text" path="email" placeholder="Email Adress" required="required" />
						<form:errors path="password" cssClass="text-danger"></form:errors>
						<form:input type="password" path="password" placeholder="Password " required="required" />
						<form:input type="text" path="tel" placeholder="Phone Number" required="required" />
						<form:input type="text" path="ville" id="autocomplete" placeholder="location" required="required" />
						 <label class="hvr-sweep-to-right">
				           	<input type="submit" value="Sign Up" >
				           </label>
					</form:form>
					<p>Already have a Real Home account? <a href='<spring:url value="/login"></spring:url>'>Login</a></p>
				</div>
			
	</div>
</div>
</div>
<!--//contact-->
	<!-- start footer -->
	<jsp:include page="inc/footer.jsp"></jsp:include>
	<!-- end footer -->
	<script>
      var autocomplete;
      function initAutocomplete() {
        autocomplete = new google.maps.places.Autocomplete(
            /** @type {!HTMLInputElement} */(document.getElementById('autocomplete')),
            {types: ['geocode']});

      }
    </script>
	<script src="https://maps.googleapis.com/maps/api/js?key= AIzaSyAwAAG_IJ9GVirsxg3XMyUXRHHQlElUJDM&libraries=places&callback=initAutocomplete"
        async defer></script>
	
</body>
</html>