<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="bootstrap.jsp"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>Sr.no</th>
				<th>Employee Name</th>
				<th>Mobile No</th>
				<th>EMp Code</th>
				<th>Email Id</th>
				<th>Documents</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employeeList }" var="employee" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${employee.empName }</td>
					<td>${employee.empMobNo }</td>
					<td>${employee.empCode }</td>
					<td>${employee.emailId }</td>
					<td><c:forEach items="${employee.documentList }" var="pathD">
							<a
								href="${pageContext.request.contextPath}/showImage?imagePath=${pathD}"
								target="new"><i class="fa fa-file-o"></i></a>
						</c:forEach></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
