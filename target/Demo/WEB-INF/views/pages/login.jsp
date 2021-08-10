<%@include file="bootstrap.jsp" %>
<div class="text-center">
<div class="text-center mt-4">
	<div class="center-align" style="color: red;">${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
</div>

<form class="col s12" action="${pageContext.request.contextPath }/login"
	method="POST">
	<div class="row mt-4">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="text-center mt-2">
				<label>User Name&nbsp;</label> <input class="validate" type="text"
					name="username" id="username" autocomplete="off"
					required="required">
			</div>

			<div class="text-center mt-2">
				<label>Password &emsp;</label> <input class="validate"
					type="text" name="password" id="password" autocomplete="off"
					required="required">
			</div>

			<div class="text-center mt-2">
				&emsp;
				<button class="btn-large w100 btn-round indigo" type="submit">Login</button>
			</div>
		</div>
		<div class="col-md-3"></div>
	</div>
</form>
</div>
