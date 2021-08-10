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
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/saveCity"
			method="post">
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
						class="form-select form-select-lg mb-3 mycss"
						aria-label="Select Country">
						<option selected>Select State</option>
						<option value="1">Rajasthan</option>
						<option value="2">UP</option>
						<option value="3">MP</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>District Name</label> <select
						class="form-select form-select-lg mb-3 mycss"
						aria-label="Select Country">
						<option selected>Select District</option>
						<option value="1">Jaipur</option>
						<option value="2">Ajmer</option>
						<option value="3">Kota</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>City Name</label><input type="text" name="stateName"
						class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>City Code</label><input type="text" name="stateCode"
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