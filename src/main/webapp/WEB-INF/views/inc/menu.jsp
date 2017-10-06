<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!---->
<div class="menu-right">
	 <ul class="menu">
		<li class="item1"><a href="#"> Menu<i class="glyphicon glyphicon-menu-down"> </i> </a>
		<ul class="cute">
			<li class="subitem1"><a href='<c:out value="${pageContext.request.contextPath }/add_ad"></c:out>'>Add an ad </a></li>
			<li class="subitem2"><a href='<c:out value="${pageContext.request.contextPath }/myads"></c:out>'>my ads </a></li>
			<li class="subitem3"><a href="buy.html">Hostels </a></li>
			<li class="subitem1"><a href="buy.html">Resale</a></li>
			<li class="subitem2"><a href="loan.html">Home Loan</a></li>
			<li class="subitem3"><a href="buy.html">Apartment </a></li>
			<li class="subitem3"><a href="dealers.html">Dealers</a></li>
		</ul>
	</li>
	</ul>
</div>
	
<!--initiate accordion-->
<script type="text/javascript">
	$(function() {
	    var menu_ul = $('.menu > li > ul'),
	           menu_a  = $('.menu > li > a');
	    menu_ul.hide();
	    menu_a.click(function(e) {
	        e.preventDefault();
	        if(!$(this).hasClass('active')) {
	            menu_a.removeClass('active');
	            menu_ul.filter(':visible').slideUp('normal');
	            $(this).addClass('active').next().stop(true,true).slideDown('normal');
	        } else {
	            $(this).removeClass('active');
	            $(this).next().stop(true,true).slideUp('normal');
	        }
	    });
	});
</script>