<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>TicketEvent Quản trị viên</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/lib/AdminLTE.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/lib/skin-blue.min.css"/>
</head>
<body class="skin-blue sidebar-mini">
	<layout:admin_header></layout:admin_header>
	   
	    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            User Management
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Dashboard</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
        
<c:url var="firstUrl" value="/user-management/1" />
<c:url var="lastUrl" value="/user-management/${page.totalPages}" />
<c:url var="prevUrl" value="/user-management/${currentIndex - 1}" />
<c:url var="nextUrl" value="/user-management/${currentIndex + 1}" />

<nav>
  <ul class="pagination pagination-sm">
  
  	<c:choose>
       <c:when test="${currentIndex == 1}">
          <li class="disabled"><a class="page-link" href="#" aria-label="Previous">
                	<span aria-hidden="true">First</span>
        			<span class="sr-only">Previous</span></a></li>
                <li class="disabled"><a class="page-link" href="#">&lt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}">First</a></li>
                <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
   </c:choose>
   <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="/user-management/${i}" />
            <c:choose>
                <c:when test="${i == currentIndex}">
                    <li class="page-item active"><a class="page-link" href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item" ><a class="page-link" href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
   </c:forEach>
   <c:choose>
            <c:when test="${currentIndex == page.totalPages}">
                <li class="page-item disabled"><a class="page-link" aria-label="Next" href="#"><span aria-hidden="true">&gt;</span>
        <span class="sr-only">Next</span></a></li>
                <li class="page-item disabled"><a class="page-link" aria-label="Last" href="#">Last</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a href="${nextUrl}">&gt;</a></li>
                <li class="page-item"><a href="${lastUrl}">Last</a></li>
            </c:otherwise>
        </c:choose>
  </ul>
</nav>
         <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">All User Account</h3>
                  <div class="box-tools">
                    <div class="input-group" style="width: 150px;">
                      <input type="text" name="table_search" class="form-control input-sm pull-right" placeholder="Search" />
                      <div class="input-group-btn">
                        <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
                      </div>
                    </div>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive no-padding">
                  <table id="myDatatable" class="table table-hover">
                    <tr>
                      <th>User</th>
                      <th>Name</th>
                      <th>Acive Date</th>
                      <th>Status</th>
                      <th>Email</th>
                      <th>Set Active</th>
                    </tr>
                    <c:forEach items="${listAllAccount}" var="userItem">
                    	<tr>
	                      <td><c:out value="${userItem.username}"/></td>
	                      <c:choose>
	                      	<c:when test="${userItem.name != null}">
	                      		<td><c:out value="${userItem.name}"/></td>
	                      	</c:when>
	                      	<c:otherwise>
	                      		<td><span class="label label-default">Not set</span></td>
	                      	</c:otherwise>
	                      </c:choose>
	                      
	                      <fmt:formatDate value="${userItem.activeDate}" pattern="dd/MM/yyyy - hh:mm:ss" var="activeDate"/>
	                      <td><c:out value="${activeDate}"/></td>
	                      <c:choose>
	                      	<c:when test="${userItem.isActive != 0}">
	                      		<td><span class="label label-success">Actived</span></td>
	                      	</c:when>
	                      	<c:otherwise>
	                      		<td><span class="label label-danger">InActived</span></td>
	                      	</c:otherwise>
	                      </c:choose>
	                      
	                      <td><c:out value="${userItem.email}"/></td>
	                      <td>
						    <input id="${userItem.id}" name="${userItem.isActive}" class="activeToggle" type="checkbox">
						  </td>
	                    </tr>
                    </c:forEach>
                  </table>
                  
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
	   
	   
    <layout:admin_footer></layout:admin_footer>


    <script src="<%=request.getContextPath()%>/resources/js/lib/jQuery-2.1.4.min.js"></script>
    <script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/lib/app.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/admin.js"></script>
</body>
</html>