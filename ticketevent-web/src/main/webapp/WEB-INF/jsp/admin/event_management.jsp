<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<c:set var="today" value="<%=new Date()%>"/>
<fmt:formatDate var="dateToday" value="${today}" pattern="yyyy-MM-dd HH:mm:ss"/>


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
		<section class="content-header">
			<h1>
				Quản Lí Sự Kiện
			</h1>
		</section>
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<!-- <div class="box"> -->
						<div class="box-header">
							<div class="box-tools">
			                    <div class="input-group" style="width: 150px;">
			                      <input type="text" id="event-search" name="table_search" class="form-control input-sm pull-right" placeholder="Search" />
			                      <div class="input-group-btn">
			                        <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
			                      </div>
			                    </div>
			                </div>
						</div>
						<div class="box-body">
						<form action="deleteComments" method="post">
							<!-- <button type="submit" id="delete">Xóa</button> -->
							<table id="myEventTable" class="table table-hover">
								<thead>
									<tr>
									<th>Tên sự kiện</th>
									<th>Loại sự kiện</th>
									<th>Người tạo</th>
									<th>Địa điểm</th>
									<th>Ngày tạo</th>
									<th>Thời gian</th>
									<th>Tình trạng</th>
									<th>Tình trạng</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${events}" var="eventItem">
								<tr>
									<fmt:formatDate value="${eventItem.createDate}" pattern="dd/MM/yyyy" var="createDate"/>
									<fmt:formatDate value="${eventItem.startDate}" pattern="HH:mm dd/MM/yyyy" var="startDate"/>
									<fmt:formatDate value="${eventItem.endDate}" pattern="HH:mm dd/MM/yyyy" var="endDate"/>
									<fmt:formatDate value="${today}" pattern="yyyy/MM/dd" var="todayCompare"/>
									<fmt:formatDate value="${eventItem.endDate}" pattern="yyyy/MM/dd" var="endDateCompare"/>
									
									<td><p><c:out value="${eventItem.name}"></c:out></p></td>
									<td><p><c:out value="${eventItem.eventType.name}"></c:out></p></td>
									<td><p><c:out value="${eventItem.account.userName}"></c:out></p></td>
									<td><p><c:out value="${eventItem.place}"></c:out></p></td>
									<td><p><c:out value="${createDate}"></c:out></p></td>
									<td><p><c:out value="${startDate} - ${endDate}"></c:out></p></td>
									<c:choose>
										<c:when test="${eventItem.isAccept != 1}">
											<td><span class="label label-danger">Chưa duyệt</span>
											<c:if test="${dateToday > eventItem.endDate}"><span class="label label-default">Qua hạn</span></c:if>
											</td>
										</c:when>
										<c:otherwise>
											<td>
											<span class="label label-success">Đã duyệt</span>
											<c:choose>
												<c:when test="${todayCompare == endDateCompare}">
													<span class="label label-success">Hôm nay</span>
												</c:when>
												<c:otherwise>
													<c:if test="${dateToday < eventItem.endDate}"><span class="label label-default">Chưa diễn ra</span></c:if>
													<c:if test="${dateToday > eventItem.endDate}"><span class="label label-default">Đã qua</span></c:if>
												</c:otherwise>
											</c:choose>
											</td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${eventItem.isAccept != 1}">
											<td>
												<p class="btn btn-primary btn-xs action" id="${eventItem.id}" data-toggle="popover" data-title="Lí do xóa">Delete</p>
												<c:choose>
													<c:when test="${dateToday > endDateCompare}">
													</c:when>
													<c:otherwise>
														| <p class="btn btn-primary btn-xs acception" id="${eventItem.id}">Accept</p>
													</c:otherwise>
												</c:choose>
											</td>
										</c:when>
										<c:otherwise>
											<td>
											<%-- <c:choose>
												 <c:when test="${eventItem.isAccept == 1 && (dateTodayCompare == endDateCompare || dateToday < endDate)}">--%>
													<button class="btn btn-primary btn-xs" id="${eventItem.id}" disabled="disabled">Delete</button>
												<%-- </c:when>
												<c:otherwise><p class="btn btn-primary btn-xs deleteEvent" id="${eventItem.id}">Delete</p></c:otherwise>
											</c:choose>
											</td> --%>
										</c:otherwise>
									</c:choose>
									
								</tr>
								</c:forEach>
								</tbody>
							</table>
						</form>
						<form:form name="myForm">
						<div id="popover-content" class="hide">
					        <div class="form-group form-inline">
					          <textarea class="form-control fix-formcontrol" rows="4" id="contentDelete" name="reason"></textarea>
					          <span role="separator" class="divider"></span>
					          <p id="acceptDelete" class="btn btn-primary btn-xs">Xác nhận</p>
					          <i id="handling" class="fa fa-spinner fa-pulse fa-3x fa-fw" style="font-size: 12pt;"></i>
					        </div>
					    </div>
					    </form:form>
						</div>
					<!-- </div> --> 
				</div>
			</div>
		</section>
	</div>
	
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