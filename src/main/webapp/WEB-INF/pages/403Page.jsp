<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Case Worker Portal - 403</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/animate.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/default.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/message.css"
	media="screen" type="text/css" />

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		$('#mySpinner').addClass('spinner');
		$('#mySpinnerBackdrop').removeClass('hide');
		$('#mySpinnerBackdrop').addClass('show');

		$('#mySpinner').removeClass('spinner');
		$('#mySpinnerBackdrop').removeClass('show');
		$('#mySpinnerBackdrop').addClass('hide');

	});
</script>
<head>
<body>
	<div id="mySpinnerBackdrop" class="spinnerBackdrop"></div>
	<nav id="navSection" class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img
					src="${pageContext.servletContext.contextPath}/img/EMT_logo.png"
					class="img-responsive"></a> <a
					class="navbar-brand navbar-brand-text emt-brand-text" href="#">Case
					<span class="switch">Worker </span>Portal
				</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav w-100">
					<li class="active"><a
						href="${pageContext.request.contextPath}/cwDashboard">Home
							Page</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">${welcomeMsg}</a></li>
					<li><a href="${pageContext.request.contextPath}/logout"><span>Logout
								&nbsp;<span class="glyphicon glyphicon-log-out"></span>
						</span></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Container Starts -->
	<div id="mainSection" class="container-fluid" role="main">
		<div id="mySpinner"></div>

		<div class="col-lg-12 col-md-12 col-sm-12 mrgTop15 emt-conv-err hide"
			id="convertorErrDiv"></div>
		<br>
		<div class="row mar-bot40">
			<div class="col-md-offset-3 col-md-6">
				<div class="section-header">
					<h2 class="section-heading animated" data-animation="bounceInUp">403
						Access Denied</h2>
				</div>
			</div>
			<br>
		</div>

		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="cform" id="contact-form">

					<c:if test="${not empty message}">
						<div class="isa_error">
							<i class="fa fa-times-circle"></i> ${message}
						</div>
						<br>

						<div class="isa_warning">
							<i class="fa fa-warning"></i> Kindly contact support team to get
							access to this page.
						</div>
						<br>
					</c:if>

					<c:if test="${not empty msg}">
						<div class="isa_error">
							<i class="fa fa-times-circle"></i> ${msg}
						</div>
						<br>

						<div class="isa_warning">
							<i class="fa fa-warning"></i> Kindly contact support team to get
							access to this page.
						</div>
					</c:if>

				</div>
			</div>
		</div>
	</div>

</body>
</html>