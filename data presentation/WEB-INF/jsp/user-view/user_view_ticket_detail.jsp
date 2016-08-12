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
<meta name="_csrf" content="${_csrf.token}"/>
 <meta name="_csrf_header" content="${_csrf.headerName}"/>

<link rel="stylesheet"	href="<%=request.getContextPath()%>/resources/css/user-view/layout.css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" />
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<c:set var="today" value="<%=new Date()%>"/>
<fmt:formatDate var="dateToday" value="${today}" pattern="yyyy-MM-dd HH:mm:ss"/>

<title>Sự kiện của bạn</title>
</head>
<body>
<layout:user_view_layout></layout:user_view_layout>
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div>
					<h2>Sự kiện của bạn</h2>
					  <div class="eventType col-xs-12" id="${event.id}">
					  		<span id="btnEventPassed" class="btn btn-success">CHI TIẾT SỰ KIỆN</span>
					  </div>
					  <div class="event-content col-xs-12">
					  	<div class="col-sm-4 object_fix">
					  		<img alt="" src="http://www.theluckymonk.com/wp-content/uploads/2013/07/event-default.png">
					  	</div>
					  	<div class="col-sm-8">
					  		<h3><c:out value="${event.name}"></c:out></h3>
					  		<fmt:formatDate value="${event.startDate}" pattern="dd/MM/yyyy - HH:mm" var="startDate"/>
					  		<fmt:formatDate value="${event.endDate}" pattern="dd/MM/yyyy - HH:mm" var="endDate"/>
					  		<p><i class="fa fa-calendar" aria-hidden="true"></i> Thời gian: <b><c:out value="${startDate} - ${endDate}"></c:out></b></p>
					  		<p><i class="fa fa-map-marker" aria-hidden="true"></i> Địa điểm: <b><c:out value="${event.place}"></c:out></b></p>
					  	</div>
					  </div>
					  <div class="eventType col-xs-12">
					  		<span id="btnEventPassed" class="btn btn-success">DANH SÁCH NGƯỜI MUA VÉ</span>
					  </div>
			<div>
			  <table class="table" id="listBuyer">
			    <thead>
			      <tr>
			        <th>Tên khách hàng</th>
			        <th>Địa chỉ</th>
			        <th>Tên vé</th>
			        <th>Giá & Số lượng</th>
			        <th>Điện thoại</th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach items="${buyers}" var="buyerItem">
			    	<fmt:formatDate value="${eventItem.startDate}" pattern="dd/MM/yyyy - hh:mm:ss" var="startDate" />
			    		 <tr>
					        <td><p><c:out value="${buyerItem.ticketBuyer.name}"></c:out></p></td>
					        <td><p><c:out value="${buyerItem.ticketBuyer.address}"></c:out></p></td>
					        <td><p><c:out value="${buyerItem.ticket.name}"></c:out></p></td>
					        <td><p><c:out value="${buyerItem.ticket.price} (x ${buyerItem.quantity})"></c:out></p></td>
					      	<td><c:out value="${buyerItem.ticketBuyer.phone}"></c:out></td>
					      </tr>
			    	</c:forEach>
			    </tbody>
			  </table>
			  </div>
			  <div class="eventType col-xs-12">
					 <span id="btnEventPassed" class="btn btn-success">THỐNG KÊ</span>
					 <p style="color: white; margin-top: 10px">Khách hàng lưu ý: Mức cước áp dụng đối với mỗi vé bán ra được là 10%</p>
			  </div>
			  <div class="col-xs-12" id="areaChart" style="height: 300px;"></div> 
				</div>
				
	  	</div>
	  </div>
</section>
	<script	src="<%=request.getContextPath()%>/resources/js/lib/jQuery-2.1.4.min.js"></script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script	src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/user-view/datatable_user_detail_event.js"></script>
</body>
</html>