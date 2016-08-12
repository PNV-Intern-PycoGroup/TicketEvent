<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="accountLoged" value="${account}" scope="page"></c:set>
<c:set var="typeUser" value="2" scope="page"></c:set>
<c:set var="typeAdmin" value="1" scope="page"></c:set>

<!DOCTYPE html>
<html>
<head>
<title>TicketEvent Quản trị viên</title>
<meta name="_csrf" content="${_csrf.token}"/>
 <meta name="_csrf_header" content="${_csrf.headerName}"/>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
<link rel="stylesheet"	href="<%=request.getContextPath()%>/resources/css/lib/AdminLTE.min.css" />
<link rel="stylesheet"	href="<%=request.getContextPath()%>/resources/css/lib/skin-blue.min.css" />
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" />


</head>
<body class="skin-blue ">
	<layout:admin_header></layout:admin_header>

	
		<div class="modal fade" id="newAccount" role="dialog">
		<div class="modal-dialog">
	    	<div class="modal-content">
	        	<div class="modal-header">
	        		<button type="button" class="close" data-dismiss="modal">&times;</button>
		        	<div class="">
						<ul class="nav nav-pills" role="tablist">
							<li role="presentation" class="active">Thêm mới</li>
						</ul>
					</div>
		        </div>
		        <div class="modal-body">
					    <div role="tabpanel" class="tab-pane fade in" id="createAccount">
					    	<form:form id="createAccount" action="addAdmin" method="post" modelAttribute="account">
					    		<div class="input-group center fix">
									<span class="input-group-addon cus-icon-input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
					    			<input class="form-control has-feedback form-register-error" type="text" name="userName" id="username" placeholder="<spring:message code="label.form.register.username"/>"
					    				/>
								</div>
								
								<div class="input-group center fix">
									<span class="input-group-addon cus-icon-input-group-addon"><i class="fa fa-envelope-o" aria-hidden="true"></i></span>
					    			<input class="form-control form-register-error" type="email" name="email" id="email" placeholder="<spring:message code="label.form.email"/>"
					    			/>
								</div>
								<div class="input-group center fix">
									<span class="input-group-addon cus-icon-input-group-addon"><i class="fa fa-lock" aria-hidden="true"></i></span>
					    			<input class="form-control form-register-error" type="password" name="password" id="uPassword"  placeholder="<spring:message code="label.form.pass"/>"
					    			/>
								</div>
					    		<button class="btn btn-primary btn-submit btn-ticket" type="submit" id="btCreate">Hoàn tất</button>
					    	</form:form>
					    </div>
					</div>
		        </div>
	    	</div>
	    </div>
	<div class="content-wrapper">
		<section class="content-header">
			<h1>Quản Lí Tài Khoản</h1>
		</section>

		<section class="content">
			<div class="col-sm-6">
				<div class="col-sm-3">
					<select class="form-control" id="sel1" name="permision">
				        <option value="${typeUser}">Người dùng</option>
				        <option value="${typeAdmin}">Quản Trị</option>
				    </select>
				</div>
				<div class="col-sm-3">
					<button class="btn btn-primary" data-toggle="modal" data-target="#newAccount">Thêm mới</button>
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-12">
					<!-- <div class="box"> -->
						<div class="box-header">
							<div class="box-tools">
								<div class="input-group" style="width: 150px;">
									<input type="text" name="table_search" id="usermanage-search"
										class="form-control input-sm pull-right" placeholder="Tìm kiếm" />
									<div class="input-group-btn">
										<button class="btn btn-sm btn-default">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class="box-body">
							<table id="myDatatable" class="table table-hover">
								<thead>
								<tr>
									<th>Tên Đăng Nhập</th>
									<th>Tên hiển thị</th>
									<th>Ngày đăng kí</th>
									<th>Loại tài khoản</th>
									<th>Trạng thái tài khoản</th>
									<th>Email</th>
									<th>Kích hoạt/ Bỏ kích hoạt</th>
								</tr>
								</thead>
								<tbody>
								<c:forEach items="${listAllAccount}" var="userItem">
									<tr>
										<td><c:out value="${userItem.userName}" /></td>
										<c:choose>
											<c:when test="${userItem.userInfor.name != null}">
												<td><c:out value="${userItem.userInfor.name}" /></td>
											</c:when>
											<c:otherwise>
												<td><span class="label label-default">Not set</span></td>
											</c:otherwise>
										</c:choose>

										<fmt:formatDate value="${userItem.activeDate}"
											pattern="dd/MM/yyyy - hh:mm:ss" var="activeDate" />
										<td><c:out value="${activeDate}" /></td>
										<td><c:out value="${userItem.userRole.id}"></c:out></td>
										<c:choose>
											<c:when test="${userItem.isActive != 0}">
												<td><span class="label label-success">Actived</span></td>
											</c:when>
											<c:otherwise>
												<td><span class="label label-danger">InActived</span></td>
											</c:otherwise>
										</c:choose>

										<td><c:out value="${userItem.email}" /></td>
										<td>
											<c:choose>
												<c:when test="${!accountLoged.userName.equals(userItem.userName)}">
													<input id="${userItem.id}"	name="${userItem.isActive}" class="activeToggle" type="checkbox">
												</c:when>
												<c:otherwise>
													<input id="${userItem.id}"	name="${userItem.isActive}" class="activeToggle disabled" disabled="disabled" type="checkbox">
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>

						</div>
					<!-- </div> -->
				</div>
			</div>
		</section>
	</div>


	<layout:admin_footer></layout:admin_footer>


	<script	src="<%=request.getContextPath()%>/resources/js/lib/jQuery-2.1.4.min.js"></script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script	src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/app.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin-dataTable.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/bootstrap-notify.min.js"></script>
</body>
</html>