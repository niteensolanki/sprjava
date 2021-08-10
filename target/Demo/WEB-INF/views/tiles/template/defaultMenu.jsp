<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!-- <ul> -->

<%-- 	<li><a href="${pageContext.request.contextPath }/addCountry">Add --%>
<!-- 			Country</a></li> -->
<%-- 	<li><a href="${pageContext.request.contextPath }/addState">Add --%>
<!-- 			State</a></li> -->
<%-- 	<li><a href="${pageContext.request.contextPath }/addDist">Add --%>
<!-- 			District</a></li> -->
<%-- 	<li><a href="${pageContext.request.contextPath }/addCity">Add --%>
<!-- 			City</a></li> -->
<!-- </ul> -->
<nav class="navbar navbar-expand-lg navbar-light bg-light mb-5">
  <a class="navbar-brand" href="#">Demo</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath }/addCountry">Add Country </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath }/addState">Add State</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath }/addDist">Add District</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath }/addCity">Add City</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath }/addEmployee">Add Employee</a>
      </li>
    </ul>
  </div>
</nav>