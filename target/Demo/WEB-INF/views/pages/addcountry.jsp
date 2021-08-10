<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="bootstrap.jsp" %>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<div class="container">
	<form action="${pageContext.request.contextPath}/saveCountry"
		method="post">
		<h4>Add Country</h4>
		<div class="row">
		
			<div class="col-md-6">
				<label>Country Name</label><input type="text" name="CountryName"
					class="form-control">
			</div>
			</div>
			<div class="row mt-2">
			<div class="col-md-6">
				<label>Country Code</label><input type="text" name="CountryCode"
					class="form-control">
			</div>
			</div>
			<div class="row mt-4 text-center ">
			<div class="col-md-6">
				<input type="submit" class="btn btn-success">
			</div>
		</div>
	</form>
</div>