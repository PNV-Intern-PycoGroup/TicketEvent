<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Sign in | Sign up</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css" />
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body ng-app="myApp" ng-controller = "MainCtrl">
	<div class="modal fade" id="login-logout" role="dialog" data-keyboard="false" data-backdrop="static">
		<div class="modal-dialog">
	    	<!-- Modal content-->
	    	<div class="modal-content">
	        	<div class="modal-header">
		        	<div class="login-logout-content">
						<!-- Nav tabs -->
						<ul class="nav nav-pills" role="tablist">
							<li role="presentation" class="active"><a href="#login" aria-controls="login" role="tab" data-toggle="tab"><spring:message code="label.login"/></a></li>
							<li role="presentation"><a href="#register" aria-controls="logout" role="tab" data-toggle="tab"><spring:message code="label.register"/></a></li>
						</ul>
					</div>
		        </div>
		        <div class="modal-body">
		        	<!-- Tab panes -->
					<div class="tab-content login-logout-content">
					    <div role="tabpanel" class="tab-pane fade in active" id="login">
					    	<form action='<%=request.getContextPath()%>/login/<c:out value="${urlRedirect }"></c:out>' method="post">
					    		<c:if test="${error ne null}">
									<div class="alert-danger login-fail">Invalid username and password.</div>
								</c:if>
					    	
						    	<div class="input-group center">
									<span class="input-group-addon cus-icon-input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
									<input class="form-control" type="text" name="userName" placeholder="<spring:message code="label.form.login.username"/>"/>
								</div>
					    		<div class="input-group center">
									<span class="input-group-addon cus-icon-input-group-addon"><i class="fa fa-lock" aria-hidden="true"></i></span>
					    			<input class="form-control" type="password" name="password" placeholder="<spring:message code="label.form.pass"/>"/>
								</div>
					    		<button class="btn btn-default btn-submit btn-ticket" type="submit"><spring:message code="label.login"/></button>
					    		<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
					    	</form>
					    </div>

					    <div role="tabpanel" class="tab-pane fade in" id="register">
					    	<form:form id="registerForm" name="myForm" action='register' method="post" modelAttribute="account">
					    		<div class="input-group center">
									<span class="input-group-addon cus-icon-input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
					    			<input class="form-control has-feedback form-register-error" type="text" name="userName" id="username" placeholder="<spring:message code="label.form.register.username"/>"
					    				ng-model="userName" required username-available
					    				ng-minlength="4" ng-maxlength = "10"
								        tooltip="{{(myForm.userName.$touched && myForm.userName.$invalid) ? (!myForm.userName.$viewValue.length) ?'Username is required':'Min 4 character Max 10' :''}}"
								        tooltip-placement="right"/>
					    			<span class="glyphicon glyphicon-ok-sign text-success form-control-feedback ip_username_rg" aria-hidden="true" ng-show="myForm.userName.$valid"></span>
								</div>
								
								<div class="input-group center">
									<span class="input-group-addon cus-icon-input-group-addon"><i class="fa fa-envelope-o" aria-hidden="true"></i></span>
					    			<input class="form-control form-register-error" type="email" name="email" id="email" placeholder="<spring:message code="label.form.email"/>"
					    				ng-model="email" ng-pattern="/^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/"
					    			 	required
								        tooltip="{{(myForm.email.$invalid && myForm.email.$touched) ? (!myForm.email.$viewValue.length) ? 'Email is required' : 'Email is invalid' : ''}}" 
								        tooltip-placement="right"
					    			/>
					    			<span class="glyphicon glyphicon-ok-sign text-success form-control-feedback ip_username_rg" aria-hidden="true" ng-show="myForm.email.$valid"></span>
								</div>
								<div class="input-group center">
									<span class="input-group-addon cus-icon-input-group-addon"><i class="fa fa-lock" aria-hidden="true"></i></span>
					    			<input class="form-control form-register-error" type="password" name="password"  placeholder="<spring:message code="label.form.pass"/>"
					    			ng-model="password"
					    			 required
								        tooltip="{{(myForm.password.$invalid && myForm.password.$touched) ? 'Password is required' : ''}}" 
								        tooltip-placement="right"
					    			/>
					    			<span class="glyphicon glyphicon-ok-sign text-success form-control-feedback ip_username_rg" aria-hidden="true" ng-show="myForm.password.$valid"></span>
								</div>
					    		<div class="input-group center">
									<span class="input-group-addon cus-icon-input-group-addon"><i class="fa fa-key" aria-hidden="true"></i></span>
					    			<input class="form-control form-register-error" type="password" name="passConfirm" password-match="password" placeholder="<spring:message code="label.form.confirmpass"/>"
					    			ng-model="passConfirm"
					    			 required
					    			 tooltip="{{(myForm.passConfirm.$invalid && myForm.passConfirm.$touched) ? 'Confirm password is not match' : ''}}" 
								        tooltip-placement="right" ng-match="password"
					    			/>
					    			<span class="glyphicon glyphicon-ok-sign text-success form-control-feedback ip_username_rg" aria-hidden="true" ng-show="myForm.passConfirm.$valid"></span>
								</div>
					    		<button ng-disabled="myForm.$invalid" class="btn btn-default btn-submit btn-ticket" type="submit" id="btRegister"><spring:message code="label.register"/></button>
					    	</form:form>
					    </div>
					</div>
		        </div>
	    	</div>
	    </div>
	</div>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.12.1/ui-bootstrap-tpls.min.js"></script>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/boostrap-datepicker.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/header.js"></script>
	<script>
		$('.modal').modal();
	</script>
</body>
</html>