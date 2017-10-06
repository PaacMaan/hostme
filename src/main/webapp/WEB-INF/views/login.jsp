<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Real Home A Real Estate Category Flat Bootstarp Resposive Website Template | Login :: w3layouts</title>
<jsp:include page="inc/head.jsp"></jsp:include>
</head>
<body>
	<!-- start header  -->
	<jsp:include page="inc/header.jsp"></jsp:include>
	<!-- end header -->
<div class=" banner-buying">
	<div class=" container">
	<h3><span>Log</span>in</h3> 
	<jsp:include page="inc/menu.jsp"></jsp:include>
	<div class="clearfix"> </div>
	</div>
</div>
<!--//header-->
<!--contact-->
<div class="login-right">
	<div class="container">
		<h3>Login</h3>
		<div class="login-top">
				<ul class="login-icons">
					<li><a href="#" ><i class="facebook"> </i><span>Facebook</span></a></li>
					<li><a href="#" class="twit"><i class="twitter"></i><span>Twitter</span></a></li>
					<li><a href="#" class="go"><i class="google"></i><span>Google +</span></a></li>
					<li><a href="#" class="in"><i class="linkedin"></i><span>Linkedin</span></a></li>
					<div class="clearfix"> </div>
				</ul>
				<div class="form-info">
					<c:if test="${param.error != null}">
						<div class="alert alert-danger" role="alert">
	        				<strong>Oh snap!</strong> Email and password are incorrect or your account is not activated yet, please try again.
	      				</div>
      				</c:if>
					<spring:url value="/login.do" var="loginUrl" htmlEscape="true"></spring:url>
					<form:form action="${loginUrl}" method="post" modelAttribute="user">
						<form:input path="username" type="text" class="text" placeholder="Email Adress" required="required" />
						<form:input path="password" type="password"  placeholder="Password" required="required" />
						 <label class="hvr-sweep-to-right">
				           	<input type="submit" value="Submit">
				         </label>
					</form:form>
				</div>
			<div class="create">
				<h4>New To Real Home?</h4>
				<a class="hvr-sweep-to-right" href='<spring:url value="/register"></spring:url>'>Create an Account</a>
				<div class="clearfix"> </div>
			</div>
	</div>
</div>
</div>
<!--//contact-->
	<!-- start footer -->
	<jsp:include page="inc/footer.jsp"></jsp:include>
	<!-- end footer -->
</body>
</html>