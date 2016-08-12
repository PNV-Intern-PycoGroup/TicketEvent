<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/lib/AdminLTE.min.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/lib/skin-blue.min.css" />
</head>
<body class="skin-blue sidebar-mini">
	<layout:admin_header></layout:admin_header>

	<div class="content-wrapper">
		<section class="content-header">
		</section>

		<section class="content">
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box">
						<span class="info-box-icon bg-red"><i class="fa fa-list"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">Total Events</span> <span id="countEventOfYearHome"
								class="info-box-number">0</span>
						</div>
					</div>
				</div>

				<div class="clearfix visible-sm-block"></div>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box">
						<span class="info-box-icon bg-green"><i
							class="ion ion-ios-cart-outline"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">Sales</span> <span id="totalOfYearHome"
								class="info-box-number">0</span>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box">
						<span class="info-box-icon bg-yellow"><i
							class="ion ion-ios-people-outline"></i></span>
						<div class="info-box-content">
							<span class="info-box-text">All Members</span> <span
								class="info-box-number"><c:out value="${listAllUser}"></c:out></span>
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<!-- Left col -->
				<div class="col-md-8">

					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">Latest Events</h3>

						</div>
						<div class="box-body">
							<div class="table-responsive">
								<table class="table no-margin">
									<thead>
										<tr>
											<th>Tên sự kiện</th>
											<th>Loại sự kiện</th>
											<th>Người tạo</th>
											<th>Địa điểm</th>
											<th>Ngày tạo</th>
											<th>Thời gian</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${lastestEvent}" var="eventItem">
										<tr>
											<fmt:formatDate value="${eventItem.createDate}" pattern="dd/MM/yyyy" var="createDate"/>
											<fmt:formatDate value="${eventItem.startDate}" pattern="HH:mm dd/MM/yyyy" var="startDate"/>
											<fmt:formatDate value="${eventItem.endDate}" pattern="HH:mm dd/MM/yyyy" var="endDate"/>
											
											<td><a href="pages/examples/invoice.html"><c:out value="${eventItem.name}"></c:out></a></td>
											<td><c:out value="${eventItem.eventType.name}"></c:out></td>
											<td><c:out value="${eventItem.account.userName}"></c:out></td>
											<td><c:out value="${eventItem.place}"></c:out></td>
											<td><c:out value="${createDate}"></c:out></td>
											<td><c:out value="${startDate} - ${endDate}"></c:out></td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<div class="box-footer clearfix">
							<a href="event-management"
								class="btn btn-sm btn-info btn-flat pull-left">Xem tất cả</a>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="box box-danger">
						<div class="box-header with-border">
							<h3 class="box-title">Thành viên mới</h3>
							<div class="box-tools pull-right">
								<span class="label label-danger">8 New Members</span>
							</div>
						</div>
						<div class="box-body no-padding">
							<ul class="users-list clearfix">
								<c:forEach var="member" items="${newLastestMember}">
								<li>
									<fmt:formatDate value="${member.activeDate}" pattern="dd/MM/yyyy - hh:mm" var="activeDate"/>
									<img src="<c:url value="/resources/images/avatar/${member.userInfor.avatar}"/>" alt="User Image" />
										<a class="users-list-name" href="#">${member.userName}</a> <span
										class="users-list-date">${activeDate}</span>
								</li>
								</c:forEach>
							</ul>
						</div>
						<div class="box-footer text-center">
							<a href="user-management" class="uppercase">View All Users</a>
						</div>
					</div>

				</div>
			</div>
		</section>
	</div>
	<layout:admin_footer></layout:admin_footer>

	<script src="<%=request.getContextPath()%>/resources/js/lib/jQuery-2.1.4.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin_home.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/app.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/bootstrap-notify.min.js"></script>
</body>
</html>