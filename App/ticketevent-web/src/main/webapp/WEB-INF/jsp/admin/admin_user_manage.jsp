<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="accountLoged" value="${account}" scope="page"></c:set>
<c:set var="typeUser" value="2" scope="page"></c:set>
<c:set var="typeAdmin" value="1" scope="page"></c:set>

<c:url var="firstUrl" value="/user-management?page=1&type=" />
<c:url var="lastUrl" value="/user-management?page=${page.totalPages}&type=" />
<c:url var="prevUrl" value="/user-management?page=${currentIndex - 1}&type=" />
<c:url var="nextUrl" value="/user-management?page=${currentIndex + 1}&type=" />	

<!DOCTYPE html>
<html>
<head>
<title>TicketEvent Quản trị viên</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/lib/AdminLTE.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/lib/skin-blue.min.css" />
</head>
<body class="skin-blue sidebar-mini">
	<layout:admin_header></layout:admin_header>

	<div class="content-wrapper">
		<section class="content-header">
			<h1>Quản Lí Người Dùng</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
				<li class="active">Dashboard</li>
			</ol>
		</section>

		<section class="content">
			<nav class="pagination pagination-sm">
					<select class="form-control" id="sel1" name="permision">
				        <option value="${typeUser}">Người dùng</option>
				        <option value="${typeAdmin}">Quản Trị</option>
				    </select>
			</nav>
			
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">Tất cả tài khoản người dùng</h3>
							<div class="box-tools">
								<div class="input-group" style="width: 150px;">
									<input type="text" name="table_search"
										class="form-control input-sm pull-right" placeholder="Search" />
									<div class="input-group-btn">
										<button class="btn btn-sm btn-default">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class="box-body table-responsive no-padding">
							<table id="myDatatable" class="table table-hover">
								<tr>
									<th>Tên Đăng Nhập</th>
									<th>Tên hiển thị</th>
									<th>Ngày đăng kí</th>
									<th>Trạng thái tài khoản</th>
									<th>Email</th>
									<th>Kích hoạt/ Bỏ kích hoạt</th>
								</tr>
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
							</table>

						</div>


						<div class="box-footer clearfix">
							<nav>
								<ul class="pagination pagination-sm no-margin pull-right">

									
										<c:if test="${currentIndex != 1}">
											<li><a id="firstPage" href="${firstUrl}">First</a></li>
											<li><a id="prevPage" href="${prevUrl}">&lt;</a></li>
										</c:if>
									
									<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
										<c:url var="pageUrl" value="/user-management?page=${i}&type=" />
										<c:choose>
											<c:when test="${i == currentIndex}">
												<li id="curentPage" class="page-item active"><a
													href="user-management?page=${i}"><c:out value="${i}" /></a></li>
											</c:when>
											<c:otherwise>
												<li class="page-item"><a class="page-link"
													href="${pageUrl}"><c:out value="${i}" /></a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									
										<c:if test="${currentIndex != page.totalPages}">
											<li class="page-item"><a id="nextPage" href="${nextUrl}">&gt;</a></li>
											<li class="page-item"><a id="lastPage" href="${lastUrl}">Last</a></li>
										</c:if>
									
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>


	<layout:admin_footer></layout:admin_footer>


	<script
		src="<%=request.getContextPath()%>/resources/js/lib/jQuery-2.1.4.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/app.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin.js"></script>
</body>
</html>