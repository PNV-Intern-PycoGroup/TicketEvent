<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag pageEncoding="UTF-8" %>
<c:set var="male" value="Nam"></c:set>
<c:set var="female" value="Nữ"></c:set>

<header>
	<c:if test="${param.confirm != null && param.confirm == 'success'}">
		<div class="confirm-success"></div>
	</c:if>
	<c:if test="${param.confirm != null &&  param.confirm == 'error'}">
		<div class="confirm-error"></div>
	</c:if>
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
							<c:set var="searchUrl" value="/ticketevent-web/search?p="></c:set>
							<li><a href="<c:out value="${searchUrl }${listFamousCity[0] }"></c:out>"><spring:message code="labelHN"/></a></li>
							<li><a href="<c:out value="${searchUrl }${listFamousCity[1] }"></c:out>"><spring:message code="label.HP"/></a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:out value="${searchUrl }${listFamousCity[2] }"></c:out>"><spring:message code="label.DN"/></a></li>
							<li><a href="<c:out value="${searchUrl }${listFamousCity[3] }"></c:out>"><spring:message code="label.QN"/></a></li>
							<li><a href="<c:out value="${searchUrl }${listFamousCity[4] }"></c:out>"><spring:message code="label.H"/></a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:out value="${searchUrl }${listFamousCity[5] }"></c:out>"><spring:message code="labelHCM"/></a></li>
							<li><a href="<c:out value="${searchUrl }${listFamousCity[6] }"></c:out>"><spring:message code="label.CT"/></a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:out value="${searchUrl }${listFamousCity[7] }"></c:out>"><spring:message code="label.KHAC"/></a></li>
						</ul>
					</li>
					<li>
						<form role="search">
							<div class="input-group">
								<a href="#" class="input-group-addon cus-icon-input-group-addon btn-search"><i class="fa fa-search" aria-hidden="true"></i></a>
								<input type="text" class="form-control search-event"
									placeholder="<spring:message code="label.findEvent"/>" aria-describedby="basic-addon1">
								<ul class="dropdown-menu show-search">
								</ul>
							</div>
						</form>
					</li>
				</ul>
			</div>
			
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-fix-pading"
				id="bs-example-navbar-collapse-1">
				
			<!-- --------------- -->

				<a href='<%=request.getContextPath()%>/create-event' class="btn btn-default btn-ticket" id="btn-add-event"><spring:message code="label.createEvent"/></a>

				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false" id="language"><spring:message code="label.Language"/>  <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li>
								<a href="?lang=vi">
									<img src="<%=request.getContextPath()%>/resources/icon/flag_vn.png"></img> <spring:message code="label.vi"/>
								</a>
								<a href="?lang=en">
									<img src="<%=request.getContextPath()%>/resources/icon/flag_en.png"></img> <spring:message code="label.en"/>
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
							<li><a href="event-created"><spring:message code="label.myEvent"/></a></li>
							<c:if test="${account.userRole.id == 1 }">
								<li><a href="admin/admin-page"><spring:message code="admin.access"/></a></li>
							</c:if>
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
		<div class="modal-dialog modal-login">
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
					    	<form action="" method="post">
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
					    			<input class="form-control form-register-error" type="password" password-match="password" placeholder="<spring:message code="label.form.confirmpass"/>"
					    			ng-model="passConfirm"
					    			 required
					    			 tooltip="{{(myForm.passConfirm.$invalid && myForm.passConfirm.$touched) ? 'Confirm password is not match' : ''}}" 
								        tooltip-placement="right" ng-match="password"
					    			/>
					    			<span class="glyphicon glyphicon-ok-sign text-success form-control-feedback ip_username_rg" aria-hidden="true" ng-show="myForm.passConfirm.$valid"></span>
								</div>
					    		<button ng-disabled="myForm.$invalid" class="btn btn-default btn-submit btn-ticket" type="submit" id="btRegister"><spring:message code="label.register"/><i id="loading" class="fa fa-spinner fa-pulse fa-3x fa-fw" style="font-size: 15pt;color:white"></i></button>
					    		
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
								<form:form class="text-center" action="editProfile" method="post" enctype="multipart/form-data" id= "submitForm">
									<input type="hidden" name = "id" value="${accountInfo.id}">
									<input type="hidden" name ="avatar" id="imageBase64"/>
									<input type="file" id="avataUpload"/>
									<div class="kv-avatar">
										<table>
											<tr>
												<td>
													<div class="file-input">
												    	<div id="fileupload" tabindex="-1">
												    		<c:choose>
												    			<c:when test="${accountInfo.avatar != null}">
												    			<img id="avatar" src="<c:url value="/resources/images/avatar/${accountInfo.avatar}"/>" alt="Your Avatar" style="width: 160px; height: 160px;"/>
												    			</c:when>
												    			<c:otherwise>
												    				<img id="avatar" src="http://plugins.krajee.com/uploads/default_avatar_male.jpg" alt="Your Avatar" style="width: 160px; height: 160px;"/>
												    			</c:otherwise>
												    		</c:choose>
												    		
												    		<h6 class="text-muted"><spring:message code="label.form.profile.avatar.direct"></spring:message></h6>
												    	</div>
												 	</div>
												</td>
												<td>
													<div class="user-infor">
									 		<table class="user-table">
									 			<tr>
									 				<td><i class="fa fa-user"></i> </td>
									 				<td id="name"><input type="text" name="name" value="${accountInfo.name}"/></td>
									 				<td id="dis"><label for="name"><c:out value="${accountInfo.name}"></c:out></label></td>
									 				<td id="key"><a data-label="name" href="#"><i class="fa fa-pencil"></i></a></td>
									 			</tr>
									 		</table>
									 		<table class="user-table">
									 			<tr><td><i class="fa fa-envelope"></i> </td>
									 				<td id="emails"><input type="text" name="email" value="${accountInfo.email}"/></td>
									 				<td id="dis"><label for="emails"><c:out value="${accountInfo.email}"></c:out></label></td>
									 				<td id="key"><a data-label="emails" href="#"><i class="fa fa-pencil"></i></a></td>
									 			</tr>
									 		</table>
									 		<table class="user-table">
									 			<tr>
									 				<td><i class="fa fa-map-marker"></i> </td>
									 				<td id="address"><input type="text" name="address" value="${accountInfo.address}"/></td>
									 				<td id="dis"><label for="address"><c:out value="${accountInfo.address}"></c:out></label></td>
									 				<td id="key"><a data-label="address" href="#"><i class="fa fa-pencil"></i></a></td>
									 			</tr>
									 		</table>
									 		<table class="user-table">
									 			<tr>
									 				<td><i class="fa fa-phone"></i> </td>
									 				<td id="phone"><input type="text" name="phone" value="${accountInfo.phone}"/></td>
									 				<td id="dis"><label for="phone"><c:out value="${accountInfo.phone}"></c:out></label></td>
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
													<option value="${male}"><spring:message code="gender.male"/></option>
													<option value="${female}"><spring:message code="gender.female"/></option>
												</select>
											</div>
											<div class="col-sm-6">
												<div class="userif-birthday">
													<fmt:formatDate value="${accountInfo.birthday}" pattern="dd/MM/yyyy" var="birthday"/>
									                <spring:message code = "label.form.profile.birthday"></spring:message> <input type="text" value="${birthday}" placeholder='<spring:message code = "label.form.profile.plholderBirthday"></spring:message>'  id="example1">
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