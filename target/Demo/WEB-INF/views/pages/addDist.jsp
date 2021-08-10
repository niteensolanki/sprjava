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
		<form action="${pageContext.request.contextPath}/saveDistrict"
			method="post">
			<h4>Add District</h4>
			<div class="row">
				<div class="col-md-6">
					<label>Country Name</label> <select
						class="form-select form-select-lg mb-3 mycss"
						aria-label="Select Country" id="comboboxCountry">
						<c:forEach var="country" items="${countryList }">
							<option value="${country.id}">${country.countryName}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<label>State Name</label><select
						class="form-select form-select-lg mb-3 mycss" name="stateId"
						aria-label="Select state" id="comboboxstate">
						<c:forEach var="state" items="${stateList }">
							<option value="${state.id}">${state.stateName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>District Name</label><input type="text" name="stateName"
						class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label>District Code</label><input type="text" name="stateCode"
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