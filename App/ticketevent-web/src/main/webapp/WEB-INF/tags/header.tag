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
						aria-expanded="false">
						<c:choose>
						<c:when test="${account.userInfor.name == null || account.userInfor.name.equals('')}">
							<c:out value="${account.userName}"/>
						</c:when>
						<c:otherwise>
							<c:out value="${account.userInfor.name}"/>
						</c:otherwise>
						</c:choose><span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#" data-toggle="modal" data-target="#accountInfor"><spring:message code="label.account"/></a></li>
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
					    	<form:form id="registerForm" name="myForm" action="register" method="post" modelAttribute="account">
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
	
	
	<div class="modal fade" id="accountInfor" role="dialog">
		<div class="modal-dialog modal-register">
	    	<!-- Modal content-->
	    	<div class="modal-content">
	        	<div class="modal-header">
	        		<button type="button" class="close" data-dismiss="modal">&times;</button>
		        	<div class="login-logout-content">
		        	<spring:message code="label.form.profile.tittle"></spring:message>
					</div>
		        </div>
		        <div class="modal-body fix-padding">
		        	<!-- Tab panes -->
					    <div role="tabpanel" class="tab-pane fade in active">
								<form:form class="text-center" action="editProfile" method="post" enctype="multipart/form-data" modelAttribute="account">
									<input type="hidden" name = "id" value="${account.id}">
									<input type="file" name = "file" id="avataUpload"/>
									<div class="kv-avatar">
										<table>
											<tr>
												<td>
													<div class="file-input">
												    	<div id="fileupload" tabindex="-1">
												    		<img id="avatar" src="http://plugins.krajee.com/uploads/default_avatar_male.jpg" alt="Your Avatar" style="width:160px; height: 160px;"/>
												    		<h6 class="text-muted"><spring:message code="label.form.profile.avatar.direct"></spring:message></h6>
												    	</div>
												 	</div>
												</td>
												<td>
													<div class="user-infor">
									 		<table class="user-table">
									 			<tr>
									 				<td><i class="fa fa-user"></i> </td>
									 				<td id="name"><input type="text" name="name" value="${account.userInfor.name}"/></td>
									 				<td id="dis"><label for="name"><c:out value="${account.userInfor.name}"></c:out></label></td>
									 				<td id="key"><a data-label="name" href="#"><i class="fa fa-pencil"></i></a></td>
									 			</tr>
									 		</table>
									 		<table class="user-table">
									 			<tr><td><i class="fa fa-envelope"></i> </td>
									 				<td id="emails"><input type="text" name="emails" value="${account.email}"/></td>
									 				<td id="dis"><label for="emails"><c:out value="${account.email}"></c:out></label></td>
									 				<td id="key"><a data-label="emails" href="#"><i class="fa fa-pencil"></i></a></td>
									 			</tr>
									 		</table>
									 		<table class="user-table">
									 			<tr>
									 				<td><i class="fa fa-map-marker"></i> </td>
									 				<td id="address"><input type="text" name="address" value="${account.userInfor.address}"/></td>
									 				<td id="dis"><label for="address"><c:out value="${account.userInfor.address}"></c:out></label></td>
									 				<td id="key"><a data-label="address" href="#"><i class="fa fa-pencil"></i></a></td>
									 			</tr>
									 		</table>
									 		<table class="user-table">
									 			<tr>
									 				<td><i class="fa fa-phone"></i> </td>
									 				<td id="phone"><input type="text" name="phone" value="${account.userInfor.phone}"/></td>
									 				<td id="dis"><label for="phone"><c:out value="${account.userInfor.phone}"></c:out></label></td>
									 				<td id="key"><a data-label="phone" href="#"><i class="fa fa-pencil"></i></a></td>
									 			</tr>
									 		</table>
									 	</div>
												</td>
											</tr>
										</table>
										<a href="#" data-toggle="collapse" data-target="#demo" id="userIf-more-hide"><span><spring:message code = "label.form.userProfile.hideShow"></spring:message></span> <i id="caret-change" class="fa fa-caret-down"></i></a>
										<div id="demo" class="collapse collapse-user-infor row">
											<div class="col-sm-6">
												<spring:message code="label.form.profile.genderTitle"></spring:message>
												<select class="select-gender" name="gender">
													<option>Nam</option>
													<option>Nu</option>
													<%-- <c:forEach var="enum" items="${}">
												    	<option value="${enum}"><spring:message code="${enum}" /></option>
													</c:forEach> --%>
												</select>
											</div>
											<div class="col-sm-6">
												<div class="userif-birthday">
									                <spring:message code = "label.form.profile.birthday"></spring:message> <input type="text" placeholder='<spring:message code = "label.form.profile.plholderBirthday"></spring:message>'  id="example1" name="birthday">
									            </div>
											</div>
  										</div>
										<hr>
										<button type = "submit" class="btn btn-primary btn-sm"><spring:message code = "label.form.profile.btnSave"></spring:message></button>
									</div>
									<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								</form:form>
					    </div>
		        </div>
	    	</div>
	    </div>
	</div>
	<div class="clear"></div>
</header>