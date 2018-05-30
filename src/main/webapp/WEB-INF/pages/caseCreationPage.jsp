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
<title>Case Worker Portal - Add New Case</title>

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
					<li class="active"><a
						href="${pageContext.request.contextPath}/cwCaseCreation">Add
							New Case</a></li>
				</ul>
				<ul class="nav navbar-nav w-100">
					<li><a href="${pageContext.request.contextPath}/cwAppointment">My
							Appointments</a></li>
				</ul>
				<ul class="nav navbar-nav w-100">
					<li><a
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
					<c:choose>
						<c:when test="${not disableFields}">
							<h2 class="section-heading animated" data-animation="bounceInUp">Add&nbsp;&nbsp;New&nbsp;&nbsp;Case</h2>
						</c:when>
						<c:otherwise>
							<h2 class="section-heading animated" data-animation="bounceInUp">Display&nbsp;&nbsp;Existing&nbsp;&nbsp;Case</h2>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 pull-right"></div>
		</div>
		<br>
		<div class="row">
			<div class="cform" id="contact-form">

				<form:form modelAttribute="caseCreationForm" method="POST"
					action="cwCaseCreationProcess" class="contactForm">

					<c:if test="${not empty success}">
						<div class="col-md-8 col-md-offset-2">
							<div class="isa_success dcm-success-msg">
								<i class="fa fa-check"></i> ${success}
							</div>
						</div><br>
					</c:if>
					<c:if test="${not empty eligBenefits}">
						<div class="col-md-8 col-md-offset-2">
							<div class="isa_info dcm-success-msg">
								<i class="fa fa-check"></i> ${eligBenefits}
							</div>
						</div><br>
					</c:if>

					<div class="col-md-8 col-md-offset-2 wow bounceIn">
						<spring:bind path="createDate">
							<div class="form-group">
								<form:label path="createDate" id="customlabel" name="createDate">Case Creation Date</form:label>
								<form:input path="createDate" type="text" id="createDate"
									class="form-control ${status.error ? 'has-error' : ''}"
									maxlength="10" readonly="true" />
							</div>
						</spring:bind>
					</div>

					<div class="col-md-8 col-md-offset-2 wow bounceIn">
						<spring:bind path="descForm.pt">
							<div class="form-group">
								<form:label path="descForm.pt" id="customlabel"
									name="descForm.pt">Assistance Program Type</form:label>
								<form:input path="descForm.pt" type="text" id="descForm.pt"
									class="form-control ${status.error ? 'has-error' : ''}"
									maxlength="30" readonly="true" />
							</div>
						</spring:bind>
					</div>

					<div class="col-md-8 col-md-offset-2 wow bounceIn">
						<spring:bind path="descForm.hoh">
							<div class="form-group">
								<form:label path="descForm.hoh" id="customlabel"
									name="descForm.hoh">Head of Household Name</form:label>
								<form:input path="descForm.hoh" type="text" id="descForm.hoh"
									class="form-control ${status.error ? 'has-error' : ''}"
									maxlength="40" readonly="${disableFields}" />
							</div>
						</spring:bind>
					</div>

					<div class="col-md-8 col-md-offset-2 wow bounceIn">
						<spring:bind path="descForm.adultCnt">
							<div class="form-group">
								<form:label path="descForm.adultCnt" id="customlabel"
									name="descForm.adultCnt">Total Number of Adults in Family</form:label>
								<form:input path="descForm.adultCnt" type="text"
									id="descForm.adultCnt"
									class="form-control ${status.error ? 'has-error' : ''}"
									maxlength="2" readonly="${disableFields}" />
							</div>
						</spring:bind>
					</div>

					<div class="col-md-8 col-md-offset-2 wow bounceIn">
						<spring:bind path="descForm.childrenCnt">
							<div class="form-group">
								<form:label path="descForm.childrenCnt" id="customlabel"
									name="descForm.childrenCnt">Total Number of Children in Family</form:label>
								<form:input path="descForm.childrenCnt" type="text"
									id="descForm.childrenCnt"
									class="form-control ${status.error ? 'has-error' : ''}"
									maxlength="2" readonly="${disableFields}" />
							</div>
						</spring:bind>
					</div>

					<div class="col-md-8 col-md-offset-2 wow bounceIn">
						<spring:bind path="descForm.monthlyIncome">
							<div class="form-group">
								<form:label path="descForm.monthlyIncome" id="customlabel"
									name="descForm.monthlyIncome">Monthly Total Income of Family (in $)</form:label>
								<form:input path="descForm.monthlyIncome" type="text"
									id="descForm.monthlyIncome"
									class="form-control ${status.error ? 'has-error' : ''}"
									maxlength="4" readonly="${disableFields}" />
							</div>
						</spring:bind>
					</div>

					<div class="col-md-8 col-md-offset-2 wow bounceIn col-">
						<spring:bind path="status">
							<div class="form-group">
								<form:label path="status" id="customlabel">Case Status</form:label>
								<form:select path="status" id="status"
									class="form-control  ${status.error ? 'has-error' : ''}">
									<form:option value="Pending Review" label="Pending Review" />
									<form:option value="Approved" label="Approved" />
									<form:option value="Denied" label="Denied" />
								</form:select>
							</div>
						</spring:bind>
					</div>

					<div class="col-md-8 col-md-offset-2 wow bounceIn">
						<spring:bind path="assignedCwName">
							<div class="form-group">
								<form:label path="assignedCwName" id="customlabel"
									name="assignedCwName">Assigned Case Worker Name</form:label>
								<form:input path="assignedCwName" type="text"
									class="form-control ${status.error ? 'has-error' : ''}"
									id="assignedCwName" maxlength="30" readonly="true" />
							</div>
						</spring:bind>
					</div>

					<c:if test="${not disableFields}">
						<div class="col-md-3 col-md-offset-7 wow bounceIn">
							<input type="submit" name="caseCreation"
								class="btn emt-btn-dark mrgBtm1Prcnt" value="Create Case" />
						</div>
					</c:if>
				</form:form>

			</div>
		</div>
	</div>
	
	<%@include file="includes/aliceImport.jsp" %>
</body>
</html>