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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
	function add() {
		var new_chq_no = parseInt($('#total_chq').val()) + 1;
		var new_input = "<input type='file' name='addressProfs' id='new_"+new_chq_no+"' class='form-control mt-2'>";
		$('#multAddress').append(new_input);
		$('#total_chq').val(new_chq_no)
	}
	function remove() {
		var last_chq_no = $('#total_chq').val();
		if (last_chq_no > 1) {
			$('#new_' + last_chq_no).remove();
			$('#total_chq').val(last_chq_no - 1);
		}
	}

	function getDist() {
		var stateId = $("#state_id").val();
		$("#distId").empty();
		$.post("${pageContext.request.contextPath }/getDist?id=" + stateId,
				function(response) {
					$.each(response, function(j, datavalue) {
						$("#distId").append(
								'<option value="'+datavalue.id+'">'
										+ datavalue.distName + '</option>');
					});
				});
	}

	function getcity() {
		var distId = $("#distId").val();
		$("#cityId").empty();
		$.post("${pageContext.request.contextPath }/getCity?id=" + distId,
				function(response) {
					$.each(response, function(j, datavalue) {
						$("#cityId").append(
								'<option value="'+datavalue.id+'">'
										+ datavalue.cityName + '</option>');
					});
				});
	}
</script>



</head>
<body>
	<div class="card">
		<div class="card-body">
			<div class="container">
				<div class="row">
					<div class="col-md-6 offset-md-3">
						<h4 class="text-center">Add Employee</h4>

						<form:form
							action="${pageContext.request.contextPath}/saveEmployee"
							modelAttribute="employeeVo" method="post">
							<div class="form-group">
								<label>Employee Name</label>
								<form:input type="text" path="empName" class="form-control" />
							</div>
							<div class="form-group">
								<label>Employee Code</label>
								<form:input path="empCode" class="form-control" />
							</div>
							<div class="form-group">
								<label>Employee Mobile No</label>
								<form:input path="empMobNo" class="form-control" />
							</div>
							<div class="form-group">
								<label>Employee Email</label>
								<form:input type="email" path="emailId" class="form-control" />
							</div>
							<div class="form-group">
								<label>House No </label>
								<form:input path="adr_houseno" class="form-control"
									required="true" />
							</div>
							<div class="form-group">
								<label>Select Country</label>
								<form:select path="country_id" class="form-control">
									<c:forEach items="countryList" var="country">
										<%-- 										<option value="${country.id }">${country.countryName }</option> --%>
									</c:forEach>
								</form:select>
							</div>
							<div class="form-group">
								<label>Select State</label>
								<form:select class="form-control" path="state_id" id="state_id">
									<c:forEach items="stateList" var="state">
										<%-- 										<form:option value="${state.id }">${state.stateName }</form:option> --%>
									</c:forEach>
								</form:select>
							</div>
							<div class="form-group">
								<label>Select Distic</label>
								<form:select path="dist_id" id="distId" class="form-control">
								</form:select>
							</div>
							<div class="form-group">
								<label>Select City</label>
								<form:select path="city_id" id="cityId" class="form-control"></form:select>
							</div>


							<div class="form-group">
								<label>House No </label>
								<form:input path="adr_houseno" class="form-control"
									required="true" />
							</div>

							<div class="form-group">
								<label>Floar No </label>
								<form:input path="adr_flrno" class="form-control"
									required="true" />
							</div>


							<div class="form-group">
								<label>Address Street </label>
								<form:input path="adr_street" class="form-control"
									required="true" />
							</div>
							<div class="form-group">
								<label>Area </label>
								<form:input path="adr_area" class="form-control" required="true" />
							</div>

							<div class="form-group">
								<label>Pincode </label>
								<form:input path="adr_pinno" class="form-control"
									required="true" />
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-md-8">
										<label>Upload document</label><input type="file"
											name="addressProfs">
									</div>
									<div class="col-md-2 mt-4">
										<button onclick="add()" type="button">Add</button>
									</div>
									<div class="col-md-2 mt-4">
										<button onclick="remove()" type="button">remove</button>
									</div>
								</div>
							</div>
							<input type="hidden" value="1" id="total_chq">
							<input type="hidden" id="new_">
							<div class="form-group" id="multAddress"></div>

							<div class="form-group">
								<div class="text-center mt-4">
									<input type="submit" class="btn btn-success">
								</div>
							</div>

						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>