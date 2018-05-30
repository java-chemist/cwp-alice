<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "en">
<head>
	<title>Case Worker Portal - Login</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/loginPage.css">
	<script src="${pageContext.servletContext.contextPath}/js/loginPage.js"></script>
<head>
<body>
	<div id="mySpinnerBackdrop" class="spinnerBackdrop"></div>
	
	<div class="cont">
	  <div id="mySpinner"></div>
	  <div class="demo">
	    <div class="login">
	      <form name='f'
					action="${pageContext.request.contextPath}/j_spring_security_check"
					method='POST'>
	      <!-- <div class="login__check"></div> -->
		  <div class="app-logo">Case <span>Worker </span>Portal</div>
		  <div class="emt-logo"></div>
	      <div class="login__form">
	      	<c:if test="${not empty logout}">
				<div class="isa_info dcm-logout-msg">
					<i class="glyphicon glyphicon-info-sign"></i> Logout Successful!!!
				</div>
			</c:if>
			<c:if test="${param.error == 'true'}">
				<div class="isa_error dcm-login-err-msg">
					<i class="glyphicon glyphicon-ban-circle"></i> Login Failed!!! Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				</div>
			</c:if>
	        <div class="login__row">
	          <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
	            <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
	          </svg>
	          <input type="text" name="username" class="login__input name" placeholder="Username"/>
	        </div>
	        <div class="login__row">
	          <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
	            <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
	          </svg>
	          <input type="password" name="password" class="login__input pass" placeholder="Password"/>
	        </div>
	        <button id="getStarted" type="submit" class="login__submit">Sign in</button>
	        <p class="login__signup">© All Rights Reserved</p>
	        
	      </div>
	      </form>
	    </div>
	    <div class="app">      
	      <div class="app__logout">
	        <svg class="app__logout-icon svg-icon" viewBox="0 0 20 20">
	          <path d="M6,3 a8,8 0 1,0 8,0 M10,0 10,12"/>
	        </svg>
	      </div>
	    </div>
	  </div>
	</div>
</body>	
</html>