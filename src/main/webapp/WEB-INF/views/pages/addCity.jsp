<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="bootstrap.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.mycss {
	width: 100%;
	height: 45%;
}
</style>

<script>
function getDist() {
	var stateId = $("#state_id").val();
	$("#distId").empty();
	$.post("${pageContext.request.contextPath }/getDist?id=" + stateId,
			function(response) {
				console.log("response " + response);
				$.each(response, function(j, datavalue) {
					$("#distId").append(
							'<option value="'+datavalue.id+'">'
									+ datavalue.distName + '</option>');
				});
			});
}
</script>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/saveCity"
			method="post">
			<div class="text-center">${message }</div>
			<h4>Add City</h4>
			<div class="row">
				<div class="col-md-6">
					<label>Country Name</label> <select
						class="form-select form-select-lg mb-3 mycss" name="countryId"
						aria-label="Select Country" id="comboboxCountry">
						<c:forEach var="country" items="${countryList }">
							<option value="${country.id}">${country.countryName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>State Name</label> <select
						class="form-select form-select-lg mb-3 mycss" name="stateId" id="state_id" onchange="getDist();">
						<c:forEach var="state" items="${stateList }">
							<option value="${state.id}">${state.stateName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>Select District</label> <select
						class="form-select form-select-lg mb-3 mycss" name="distId" id="distId"
						aria-label="Select District">
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>City Name</label><input type="text" name="cityName"
						class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>City Code</label><input type="text" name="cityCode"
						class="form-control">
				</div>
			</div>

			<div class="row text-center mt-4">

				<div class="col-md-6">
					<input type="submit" class="btn btn-success">
				</div>

			</div>
		</form>
	</div>
</body>
</html>