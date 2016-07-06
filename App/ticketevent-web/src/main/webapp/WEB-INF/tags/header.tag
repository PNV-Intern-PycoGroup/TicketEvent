<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@tag pageEncoding="UTF-8" %>


<header>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div>
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#" id="home"></a>
				<ul class="fix-on-top">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><i class="fa fa-map-marker" aria-hidden="true"></i> <span id="location"><spring:message code="label.Location"/> <span class="caret"></span></span></a>
						<ul class="dropdown-menu">
							<li><a href="#"><spring:message code="labelHN"/></a></li>
							<li><a href="#"><spring:message code="label.HP"/></a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#"><spring:message code="label.DN"/></a></li>
							<li><a href="#"><spring:message code="label.QN"/></a></li>
							<li><a href="#"><spring:message code="label.H"/></a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#"><spring:message code="labelHCM"/></a></li>
							<li><a href="#"><spring:message code="label.CT"/></a></li>
						</ul></li>
					<li>
						<form role="search">
							<div class="input-group">
								<a href="#" class="input-group-addon cus-icon-input-group-addon"><i class="fa fa-search" aria-hidden="true"></i></a>
								<input type="text" class="form-control"
									placeholder="<spring:message code="label.findEvent"/>" aria-describedby="basic-addon1">
							</div>
						</form>
					</li>
				</ul>
			</div>
			
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				
			<!-- --------------- -->

				<button class="btn btn-default btn-ticket" id="btn-add-event"><spring:message code="label.createEvent"/></button>

				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><spring:message code="label.Language"/>  <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li>
								<a href="?lang=vi">
									<img src="resources/icon/flag_vn.png"></img> <spring:message code="label.vi"/>
								</a>
								<a href="?lang=en">
									<img src="resources/icon/flag_en.png"></img> <spring:message code="label.en"/>
								</a>
							</li>
						</ul>
					</li>
					<c:if test="${account == null}">
						<li><a href="#" data-toggle="modal" data-target="#login-logout"><spring:message code="label.login"/> | <spring:message code="label.register"/></a></li>
					</c:if>
					
					<c:if test="${account != null}">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><c:out value="${account.user_name}"/> <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#"><spring:message code="label.account"/></a></li>
							<li><a href="#"><spring:message code="label.myTicket"/></a></li>
							<li><a href="#"><spring:message code="label.myEvent"/></a></li>
							<li role="separator" class="divider"></li>
							<li>
								<a href="logout"><spring:message code="label.logout"/></a>
							</li>
						</ul>
					</li>
					</c:if>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="modal fade" id="login-logout" role="dialog">
		<div class="modal-dialog">
	    	<!-- Modal content-->
	    	<div class="modal-content">
	        	<div class="modal-header">
	        		<button type="button" class="close" data-dismiss="modal">&times;</button>
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
					    	<form action="login" method="post">
					    		<c:if test="${param.error ne null}">
									<div class="alert-danger login-fail">Invalid username and password.</div>
								</c:if>
					    	
						    	<div class="input-group center">
									<span class="input-group-addon cus-icon-input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
									<input class="form-control" type="text" name="user_name" placeholder="<spring:message code="label.form.login.username"/>"/>
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
					    	<form:form id="registerForm" name="myForm" action="register" method="post" modelAttribute="account">
					    		<div class="input-group center">
									<span class="input-group-addon cus-icon-input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
					    			<input class="form-control has-feedback form-register-error" type="text" name="user_name" id="username" placeholder="<spring:message code="label.form.register.username"/>"
					    				ng-model="user_name" required username-available
					    				ng-minlength="4" ng-maxlength = "10"
								        tooltip="{{(myForm.user_name.$touched && myForm.user_name.$invalid) ? (!myForm.user_name.$viewValue.length) ?'Username is required':'Min 4 character Max 10' :''}}"
								        tooltip-placement="right"/>
					    			<span class="glyphicon glyphicon-ok-sign text-success form-control-feedback ip_username_rg" aria-hidden="true" ng-show="myForm.user_name.$valid"></span>
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
	<div class="clear"></div>
</header>