<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="includes/headerImport.jsp" %>
<head>
<title>Case Worker Portal - My Appointments</title>

<script>
	$(document).ready(function() {
		$('#mySpinner').addClass('spinner');
		$('#mySpinnerBackdrop').removeClass('hide');
		$('#mySpinnerBackdrop').addClass('show');

		var appointmentsJsonObj = JSON.parse('${appointmentsJsonObj}');
		$('#inputTabularData').DataTable({
			processing : true,
			"data" : appointmentsJsonObj,
			"columns" : [ {
				"data" : "organizer"
			}, {
				"data" : "subject"
			}, {
				"data" : "location"
			}, {
				"data" : "date"
			}, {
				"data" : "time"
			}, {
				"data" : "duration"
			} ],
			responsive : true
		});

		$('#mySpinner').removeClass('spinner');
		$('#mySpinnerBackdrop').removeClass('show');
		$('#mySpinnerBackdrop').addClass('hide');

	});
</script>
<head>
<body class="dashboard-stroke">
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
					<li class="active"><a
						href="${pageContext.request.contextPath}/cwAppointment">My
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
					<h2 class="section-heading animated" data-animation="bounceInUp">My&nbsp;&nbsp;
						Appointments</h2>
				</div>
				<br>
			</div>
		</div>
		<div class="row result-section">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<table id="inputTabularData"
					class="table table-striped table-bordered dcm-datatables"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>MEETING ORGANIZER</th>
							<th>MEETING SUBJECT</th>
							<th>LOCATION</th>
							<th>START DATE</th>
							<th>START TIME</th>
							<th>MEETING DURATION</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>

	<%@include file="includes/aliceImport.jsp" %>
</body>
</html>