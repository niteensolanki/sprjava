<%@page import="com.mysql.cj.api.Session"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DBatuwaPortal</title>
<link rel="icon" type="image/png" sizes="25x25"
	href="${pageContext.request.contextPath }/resources/elements_materialart_pack/images/Digital-Batuwa.png">
<link
	href="${pageContext.request.contextPath }/resources/elements_materialart_pack/dist/css/style.css"
	rel="stylesheet">

<link
	href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css"
	rel="stylesheet" />

<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/elements_materialart_pack/assets/libs/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.css">
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/elements_materialart_pack/assets/libs/jquery/dist/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/elements_materialart_pack/dist/js/materialize.min.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/elements_materialart_pack/assets/libs/perfect-scrollbar/dist/js/perfect-scrollbar.jquery.min.js"></script>
</head>
<body>

	<div class="main-wrapper" id="main-wrapper">
		<%
			if (session.getAttribute("lead_type") == "IDFC") {
		%>
		<header class="topbar">
			<nav style="background-color: #9D1D27;">
				<div class="nav-wrapper">
					<img class="img-responsive" height="50px" border="1px solid #555"
						style="margin: 6px 0px 0px 100px; border: 1px solid white;"
						src="${pageContext.request.contextPath }/resources/elements_materialart_pack/images/idfc.png" />
				</div>
			</nav>
		</header>
		<%
			} else if (session.getAttribute("lead_type") == "ICICI"){
		%>
		<header class="topbar">
			<nav style="background-color: #f5821f;">
				<div class="nav-wrapper">
					<img class="img-responsive" height="50px" border="1px solid #555"
						style="margin: 6px 0px 0px 100px;"   
						src="${pageContext.request.contextPath }/resources/elements_materialart_pack/images/logoblue.png" />
				</div>
			</nav>
		</header>
		<%
			}
		%>



		<div class="page-wrapper">
			<div class="container-fluid">
				<tiles:insertAttribute name="body" />

			</div>
		</div>
		<div class="footer wizard-content center-align">
			<div class="row">
			<%
			if (session.getAttribute("lead_type") == "IDFC") {
		%>
				<div class="col-md-6 col-sm-12 m-t-40" >
					<p style="color: #9D1D27;">
						Pampered by <a href="#" class="text-dark" target="_blank">dbatuwaportal
						</a> © 2020
					</p>
				</div>
				<%
			} else if (session.getAttribute("lead_type") == "ICICI"){
		%>
		<div class="col-md-6 col-sm-12 m-t-40" >
					<p style="color: #f5821f;">
						Pampered by <a href="#" class="text-dark" target="_blank">dbatuwaportal
						</a> © 2020
					</p>
				</div>
		<%
			}
		%>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath }/resources/elements_materialart_pack/assets/extra-libs/DataTables/datatables.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/elements_materialart_pack/dist/js/pages/datatable/datatable-advanced.init.js"></script>

	<script
		src="resources/elements_materialart_pack/assets/libs/moment/moment.js"></script>
	<script
		src="resources/elements_materialart_pack/assets/libs/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker-custom.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/elements_materialart_pack/assets/libs/pickadate/lib/compressed/picker.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/elements_materialart_pack/assets/libs/pickadate/lib/compressed/picker.date.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/elements_materialart_pack/assets/libs/pickadate/lib/compressed/picker.time.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/elements_materialart_pack/assets/libs/pickadate/lib/compressed/legacy.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/elements_materialart_pack/assets/libs/daterangepicker/daterangepicker.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/elements_materialart_pack/dist/js/pages/forms/datetimepicker/datetimepicker.init.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/elements_materialart_pack/assets/libs/moment/moment.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/elements_materialart_pack/assets/libs/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker-custom.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/parsleyjs/dist/parsley.js">
		
	</script>
	<script
		src="${pageContext.request.contextPath }/resources/parsleyjs/dist/parsley.min.js"></script>
	<script>
		// MAterial Date picker  
		$(".matdate").bootstrapMaterialDatePicker({
			weekStart : 0,
			time : false
		});
		$(document).ready(function() {
			$(".select2").select2();
		});
	</script>
</body>
</html>