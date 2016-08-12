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
			  <h2>Sự kiện của bạn</h2>
			  <div class="eventType col-xs-12">
			  		<span id="btnEventPassed" class="btn btn-success">ĐÃ DUYỆT</span> <span id="btnEventNotAccept" class="btn btn-warning">CHƯA DUYỆT</span>
			  </div>
			  
			  <div style="width: 100%;">
			  <table class="table" id="myEventTable">
			    <thead>
			      <tr>
			        <th>Tên sự kiện</th>
			        <th>Thời gian</th>
			        <th>Địa chỉ</th>
			        <th>Tác vụ</th>
			        <th>Tình trạng</th>
			        <th>Passed</th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach items="${listEvent}" var="eventItem">
			    	<fmt:formatDate value="${eventItem.startDate}" pattern="dd/MM/yyyy - hh:mm:ss" var="startDate" />
			    		 <tr>
					        <td><p><c:out value="${eventItem.name}"></c:out></p></td>
					        <td><p><c:out value="${startDate}"></c:out></p></td>
					        <td><p><c:out value="${eventItem.place}"></c:out></p></td>
					        <td>
					        	<c:choose>
					        		<c:when test="${eventItem.isAccept == 1}">
					        			<c:choose>
							        		<c:when test="${dateToday > eventItem.endDate}">
							        			<a id="eDetail" href="<%=request.getContextPath()%>/event-detail?id=${eventItem.id}"><span id="${eventItem.id}" class="fa fa-line-chart"></span></a>
							        		</c:when>
							        		<c:otherwise>
							        			<a href="<%=request.getContextPath()%>/edit-event/${eventItem.id}"><span class="fa fa-pencil"></span></a>
							        		</c:otherwise>
						        		</c:choose>
					        		</c:when>
					        		<c:otherwise>
					        			<a href="<%=request.getContextPath()%>/edit-event/${eventItem.id}"><span class="fa fa-pencil"></span></a>  |  <a href="#"><span class="fa fa-trash-o"></span></a>
					        		</c:otherwise>
					        	</c:choose>
														        	
					        </td>
					        <td>
					        	<c:choose>
					        		<c:when test="${dateToday > eventItem.endDate}">
					        			<c:out value="Đã qua"></c:out>
					        		</c:when>
					        		<c:otherwise><c:out value="Chưa diễn ra"></c:out></c:otherwise>
					        	</c:choose>
					        </td>
					        <td>
					        	<c:choose>
					        		<c:when test="${eventItem.isAccept == 1 }">
					        			<c:out value="1"></c:out>
					        		</c:when>
					        		<c:otherwise><c:out value="0"></c:out></c:otherwise>
					        	</c:choose>
					        </td>
					      </tr>
			    	</c:forEach>
			    </tbody>
			  </table>
			 </div>
	  </div>
</section>
	<script	src="<%=request.getContextPath()%>/resources/js/lib/jQuery-2.1.4.min.js"></script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script	src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/user-view/dataTable.js"></script>
</body>
</html>