<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Real Home A Real Estate Category Flat Bootstarp Resposive Website Template | Home_Loan :: w3layouts</title>
<!-- Custom Theme files -->
<jsp:include page="inc/head.jsp"></jsp:include>
<link href='<spring:url value="${request.getContextPath()}/css/fine-uploader-new.css"></spring:url>' rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="inc/header.jsp"></jsp:include>
<!-- end of header -->
<!--//-->	
<div class=" banner-buying">
	<div class=" container">
	<h3>List your property for<span> free</span></h3> 
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
			<h3><c:out value="${whatToDo }"></c:out></h3>
			<h4>General Information</h4>
			<!-- deciding which url to handle -->
			<c:choose>
				<c:when test="${whatToDo == 'Add New Ad' }">
					<spring:url value="/add_ad" var="opUrl" htmlEscape="true"></spring:url>
				</c:when>
				<c:when test="${whatToDo == 'Edit your Ad' }">
					<spring:url value="/edit_ad/${ad.id_ad }" var="opUrl" htmlEscape="true"></spring:url>
				</c:when>
			</c:choose>
			<!-- end deciding -->
			<form:form action="${opUrl}" method="post" modelAttribute="ad" enctype="multipart/form-data" >
			<div class="col-loan">
				<ul class="loan-col1">
					<li><span>Kind of property</span> </li><label>:</label>
					<li class="loan-list-top">
						<form:select path="categ"  cssClass="drop-select form-control" required="">
							<form:options items="${adCategory }" itemValue="id_categ" itemLabel="libelle"/>
						</form:select>
					</li>
				</ul>
				<ul class="loan-col1">
					<li><span>What would you like to do ?</span></li><label>:</label>
					<li class="loan-list-top">
						<label class="radio-inline" for="sale">
                            <form:radiobutton path="reason" value="sale" required="" /> Sale
                        </label>
                        <label class="radio-inline" for="">
                        	<form:radiobutton path="reason" value="rent" required="" /> Rent
                        </label>
                        <form:errors path="reason" cssClass="text-danger"></form:errors>
					</li>
				</ul>
				<ul class="loan-col1">
					<li><span>Location</span></li><label>:</label>
					<li class="loan-list-top">
						<form:input path="property.ville" id="autocomplete" type="text" placeholder="Casablanca, Morocco" required="" />
					</li>
				</ul>
				<ul class="loan-col1">
					<li><span>Full adress </span></li><label>:</label>
					<li class="loan-list-top">
						<form:errors path="property.adress" cssClass="text-danger"></form:errors>
						<form:input path="property.adress" type="text" placeholder="Hay al irfane - N 14 - Rabat" required="" />
					</li>
				</ul>
			</div>
			<h4>Property details</h4>
			<!-- start of property details -->
			<div class="col-loan">
				<ul class="loan-col1">
					<li><span>Ad title</span> </li><label>:</label>
					<li class="loan-list-top">
						<form:errors path="titre" cssClass="text-danger"></form:errors>
						<form:input type="text" path="titre" placeholder="Small studio" required="" />
					</li>
				</ul>
				<ul class="loan-col1">
					<li><span>Ad description</span> </li><label>:</label>
					<li class="loan-list-top">
						<form:errors path="description" cssClass="text-danger"></form:errors>
						<form:textarea path="description" class="form-control" placeholder="description" rows="5" requried=""></form:textarea>
					</li>
				</ul>
				<ul class="loan-col1">
					<li><span>Area</span> </li><label>:</label>
					<li class="loan-list-top">
						<form:errors path="property.surface" cssClass="text-danger"></form:errors>
						<form:input type="text" path="property.surface" placeholder="132 m²" required="" />
					</li>
				</ul>
				<ul class="loan-col1">
					<li><span>Price</span> </li><label>:</label>
					<li class="loan-list-top">
						<form:errors path="property.price" cssClass="text-danger"></form:errors>
						<form:input type="text" path="property.price" placeholder="120000 DH" required="" />
					</li>
				</ul>
			</div>
			<!-- end of property details -->
			<h4>Property photos</h4>
			<!-- property photos -->
			<div class="col-loan">
				<ul class="loan-col1">
					<li><span>Add up to 6 photos (6 pictures remaining)</span> </li><label>:</label>
				</ul>
				<!-- The element where Fine Uploader will exist. -->
			    <div id="fine-uploader"></div>
			</div>
			<!-- end of property photos -->
			<!-- submit the form -->
			<div class="sub">
				<label class="hvr-sweep-to-right"><input type="submit" value="Apply"></label>
			</div>
			<!-- end of submit -->
			</form:form>
		</div>
	</div>
</div>
<!-- footer -->
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
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAwAAG_IJ9GVirsxg3XMyUXRHHQlElUJDM&libraries=places&callback=initAutocomplete"
        async defer></script>
    <script src='<spring:url value="${request.getContextPath()}/js/all.fine-uploader.js"></spring:url>'></script>
    <script type="text/template" id="qq-template">
        <div class="qq-uploader-selector qq-uploader" qq-drop-area-text="Drop files here">
            <div class="qq-total-progress-bar-container-selector qq-total-progress-bar-container">
                <div role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" class="qq-total-progress-bar-selector qq-progress-bar qq-total-progress-bar"></div>
            </div>
            <div class="qq-upload-drop-area-selector qq-upload-drop-area" qq-hide-dropzone>
                <span class="qq-upload-drop-area-text-selector"></span>
            </div>
            <div class="qq-upload-button-selector qq-upload-button">
                <div>Upload a file</div>
            </div>
            <span class="qq-drop-processing-selector qq-drop-processing">
                <span>Processing dropped files...</span>
                <span class="qq-drop-processing-spinner-selector qq-drop-processing-spinner"></span>
            </span>
            <ul class="qq-upload-list-selector qq-upload-list" aria-live="polite" aria-relevant="additions removals">
                <li>
                    <div class="qq-progress-bar-container-selector">
                        <div role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" class="qq-progress-bar-selector qq-progress-bar"></div>
                    </div>
                    <span class="qq-upload-spinner-selector qq-upload-spinner"></span>
                    <img class="qq-thumbnail-selector" qq-max-size="100" qq-server-scale>
                    <span class="qq-upload-file-selector qq-upload-file"></span>
                    <span class="qq-edit-filename-icon-selector qq-edit-filename-icon" aria-label="Edit filename"></span>
                    <input class="qq-edit-filename-selector qq-edit-filename" tabindex="0" type="text">
                    <span class="qq-upload-size-selector qq-upload-size"></span>
                    <button type="button" class="qq-btn qq-upload-cancel-selector qq-upload-cancel">Cancel</button>
                    <button type="button" class="qq-btn qq-upload-retry-selector qq-upload-retry">Retry</button>
                    <button type="button" class="qq-btn qq-upload-delete-selector qq-upload-delete">Delete</button>
                    <span role="status" class="qq-upload-status-text-selector qq-upload-status-text"></span>
                </li>
            </ul>

            <dialog class="qq-alert-dialog-selector">
                <div class="qq-dialog-message-selector"></div>
                <div class="qq-dialog-buttons">
                    <button type="button" class="qq-cancel-button-selector">Close</button>
                </div>
            </dialog>

            <dialog class="qq-confirm-dialog-selector">
                <div class="qq-dialog-message-selector"></div>
                <div class="qq-dialog-buttons">
                    <button type="button" class="qq-cancel-button-selector">No</button>
                    <button type="button" class="qq-ok-button-selector">Yes</button>
                </div>
            </dialog>

            <dialog class="qq-prompt-dialog-selector">
                <div class="qq-dialog-message-selector"></div>
                <input type="text">
                <div class="qq-dialog-buttons">
                    <button type="button" class="qq-cancel-button-selector">Cancel</button>
                    <button type="button" class="qq-ok-button-selector">Ok</button>
                </div>
            </dialog>
        </div>
    </script>

    <script>
        var uploader = new qq.FineUploader({
            element: document.getElementById('fine-uploader'),
            request: {
            	inputName: 'photos',
                endpoint: '<spring:url value="${request.getContextPath()}/uploadFile?${_csrf.parameterName}=${_csrf.token}"></spring:url>'
            }
        });
    </script>
</body>
</html>