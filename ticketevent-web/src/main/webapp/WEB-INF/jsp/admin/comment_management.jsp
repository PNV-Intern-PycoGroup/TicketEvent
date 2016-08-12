<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
	<title>TicketEvent Quản trị viên</title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<meta name="_csrf" content="${_csrf.token}"/>
 <meta name="_csrf_header" content="${_csrf.headerName}"/>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/lib/AdminLTE.min.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/lib/skin-blue.min.css" />
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" />
</head>
<body class="skin-blue sidebar-mini">
	<layout:admin_header></layout:admin_header>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				Quản Lí Bình Luận
			</h1>
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<!-- <div class="box"> -->
						<div class="box-header">
							<div class="box-tools">
			                    <div class="input-group" style="width: 150px;">
			                      <input type="text" id="comment-search" name="table_search" class="form-control input-sm pull-right" placeholder="Search" />
			                      <div class="input-group-btn">
			                        <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
			                      </div>
			                    </div>
			                </div>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
						<form action="deleteComments" method="post">
							<button type="submit" id="delete">Xóa</button>
							<table id="myDataComment" class="table table-bordered">
								<thead>
									<tr>
									<th>
									<c:choose>
										<c:when test="${listAllComment.size() == 0}">
											<input type="checkbox" id="selectAll" disabled="disabled">
										</c:when>
										<c:otherwise>
											<input type="checkbox" id="selectAll">
										</c:otherwise>
									</c:choose>
									
									</th>
									<th>Bởi Tài Khoản</th>
									<th>Nội dung</th>
									<th>Thời gian</th>
									<th>Tên sự kiện</th>
									<th>Loại sự kiện</th>
									<th>Tác vụ</th>
									</tr>
								</thead>
								<c:forEach items="${listAllComment}" var="commentItem">
								<tr>
									<td><input type="checkbox" class="selectID" value="${commentItem.id}"></td>
									<td><c:out value="${commentItem.account.userName}"></c:out></td>
									<td><c:out value="${commentItem.content}"></c:out></td>
									<fmt:formatDate value="${commentItem.commentDate}" pattern="dd/MM/yyyy - HH:mm" var="commentDate"/>
									<td><c:out value="${commentDate}"></c:out></td>
									<td><c:out value="${commentItem.event.name}"></c:out></td>
									<td><c:out value="${commentItem.event.eventType.name}"></c:out></td>
									<td><p class="btn btn-primary btn-xs commentDelete" id="${commentItem.id}">Delete</p></td>
								</tr>
								</c:forEach>
							</table>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
						</div>
						<!-- /.box-body -->
					<!-- </div> -->
					<!-- /.box -->
				</div>
			</div>
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	
	<layout:admin_footer></layout:admin_footer>

	<script src="<%=request.getContextPath()%>/resources/js/lib/jQuery-2.1.4.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script	src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/app.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin-dataTable.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/bootstrap-notify.min.js"></script>
</body>
</html>