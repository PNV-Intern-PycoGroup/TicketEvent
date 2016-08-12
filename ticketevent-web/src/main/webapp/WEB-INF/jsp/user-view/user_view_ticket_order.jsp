<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/user-view/layout.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/common.css" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" />
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*,java.text.*"%>
<c:set var="today" value="<%=new Date()%>" />
<fmt:formatDate var="dateToday" value="${today}"
	pattern="yyyy-MM-dd HH:mm:ss" />

<title>Các vé đã đặt</title>
</head>
<body>
	<layout:user_view_layout></layout:user_view_layout>
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<h2>Các vé đã đặt</h2>
				<div>
					<table class="table table-hover" id="listBuyer">
						<thead>
							<tr>
								<th>Tên người đặt vé</th>
								<th>Địa chỉ</th>
								<th>Điện thoại</th>
								<th>Tên sự kiện</th>
								<th>Tổng số vé</th>
								<th>Tổng tiền</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${buyers}" var="buyerItem">
								<tr class="buyer-item">
									<td>
											<input type="hidden" class="buyer-id" value="<c:out value="${buyerItem.id}"></c:out>" />
										<p>
											<c:out value="${buyerItem.name}"></c:out>
										</p></td>
									<td><p>
											<c:out value="${buyerItem.address}"></c:out>
										</p></td>
									<td><p>
											<c:out value="${buyerItem.phone}"></c:out>
										</p></td>
									<td><p>
											<a href="<%=request.getContextPath()%>/event/<c:out value="${buyerItem.getOrderEvent().path }" />"
											title='<c:out value="${buyerItem.getOrderEvent().name }" />'><c:out value="${buyerItem.getOrderEvent().name}"></c:out></a>
										</p></td>
									<td><p>
											<c:out value="${buyerItem.getCountOrder()}"></c:out>
										</p></td>
									<td><p>
											<c:out value="${buyerItem.getTotalPriceOrder()}"></c:out>
										</p></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="eventType col-xs-12">
					<span id="btnEventPassed" class="btn btn-success">THỐNG KÊ</span>
					<p style="color: white; margin-top: 10px">Khách hàng lưu ý:
						Mức cước áp dụng đối với mỗi vé bán ra được là 10%</p>
				</div>
			</div>
		</div>
	</section>
	<layout:user_footer></layout:user_footer>
	
	<script
		src="<%=request.getContextPath()%>/resources/js/lib/jQuery-2.1.4.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/user-view/ticket_order.js"></script>
</body>
</html>