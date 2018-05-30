<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="includes/headerImport.jsp" %>
<head>
<title>Case Worker Portal - My Account Details</title>

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
					<li><a href="${pageContext.request.contextPath}/cwDashboard">My
							Dashboard</a></li>
				</ul>
				<ul class="nav navbar-nav w-100">
					<li><a
						href="${pageContext.request.contextPath}/cwCaseCreation">Add
							New Case</a></li>
				</ul>
				<ul class="nav navbar-nav w-100">
					<li><a href="${pageContext.request.contextPath}/cwAppointment">My
							Appointments</a></li>
				</ul>
				<ul class="nav navbar-nav w-100">
					<li class="active"><a
						href="${pageContext.request.contextPath}/cwAccountDetails">My
							Account</a></li>
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
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
				<div class="section-header">
					<h2 class="section-heading animated" data-animation="bounceInUp">My&nbsp;&nbsp;Account&nbsp;&nbsp;Details</h2>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 pull-right"></div>
		</div>
		<br>
		<div class="row">
			<div class="cform" id="contact-form">

				<form:form modelAttribute="cwUsers" method="POST"
					action="cwAccountDetailsProcess" class="contactForm">

					<c:if test="${not empty success}">
						<div class="col-md-8 col-md-offset-2">
							<div class="isa_success dcm-success-msg">
								<i class="fa fa-check"></i> ${success}
							</div>
						</div>
						<br>
					</c:if>

					<div class="col-md-8 col-md-offset-2 wow bounceIn">
						<spring:bind path="cwId">
							<div class="form-group">
								<form:label path="cwId" id="customlabel" name="cwId">Case Worker ID</form:label>
								<form:input path="cwId" type="text" id="cwId"
									class="form-control ${status.error ? 'has-error' : ''}"
									maxlength="10" readonly="true" />
							</div>
						</spring:bind>
					</div>

					<div class="col-md-8 col-md-offset-2 wow bounceIn">
						<spring:bind path="name">
							<div class="form-group">
								<form:label path="name" id="customlabel" name="name">Case Worker Name</form:label>
								<form:input path="name" type="text" id="name"
									class="form-control ${status.error ? 'has-error' : ''}"
									maxlength="40" />
							</div>
						</spring:bind>
					</div>

					<div class="col-md-8 col-md-offset-2 wow bounceIn">
						<spring:bind path="email">
							<div class="form-group">
								<form:label path="email" id="customlabel" name="email">Case Worker Email</form:label>
								<form:input path="email" type="text" id="email"
									class="form-control ${status.error ? 'has-error' : ''}"
									maxlength="40" />
							</div>
						</spring:bind>
					</div>

					<div class="col-md-8 col-md-offset-2 wow bounceIn">
						<spring:bind path="role">
							<div class="form-group">
								<form:label path="role" id="customlabel" name="role">Case Worker Role</form:label>
								<form:input path="role" type="text" id="role"
									class="form-control ${status.error ? 'has-error' : ''}"
									maxlength="40" />
							</div>
						</spring:bind>
					</div>

					<div class="col-md-8 col-md-offset-2 wow bounceIn">
						<spring:bind path="designation">
							<div class="form-group">
								<form:label path="designation" id="customlabel"
									name="designation">Case Worker Designation</form:label>
								<form:input path="designation" type="text" id="designation"
									class="form-control ${status.error ? 'has-error' : ''}"
									maxlength="40" />
							</div>
						</spring:bind>
					</div>

					<div class="col-md-8 col-md-offset-2 wow bounceIn">
						<spring:bind path="department">
							<div class="form-group">
								<form:label path="department" id="customlabel" name="department">Department Name</form:label>
								<form:input path="department" type="text" id="department"
									class="form-control ${status.error ? 'has-error' : ''}"
									maxlength="40" />
							</div>
						</spring:bind>
					</div>

					<div class="col-md-3 col-md-offset-7 wow bounceIn">
						<input type="submit" name="updateAccount"
							class="btn emt-btn-dark mrgBtm1Prcnt" value="Update Account" />
					</div>
				</form:form>

			</div>
		</div>
	</div>

	<%@include file="includes/aliceImport.jsp" %>
</body>
</html>