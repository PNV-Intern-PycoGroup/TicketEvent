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
</head>
<body class="skin-blue sidebar-mini">
	<layout:admin_header></layout:admin_header>
	<div class="content-wrapper">
		<section class="content-header">
			<h1>
				Thống kê vé bán và lợi nhuận
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
				<li class="active">Dashboard</li>
			</ol>
		</section>

		<section class="content">
			<div class="row">
			<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box">
						<div class="info-box-content">
							<p class="info-box-text">TỔNG SỐ SỰ KIỆN TRONG NĂM</p>
							<p id="countEventOfYear"></p>
						</div>
					</div>
			</div>
			<div class="col-md-3 col-sm-6 col-xs-12">
			</div>
			<div class="col-md-3 col-sm-6 col-xs-12">
			</div>
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="info-box-content">
					<span>Chọn năm : <select id="selectYear"></select></span>
				</div>
			</div>
				
            <div class="col-md-12">
                  <div class="chart">
                    <div id="areaChart" style="height: 550px; width:100%; margin-bottom: 15px"></div>
                  </div>
            </div>
            
            <div class="col-md-3 col-sm-6 col-xs-12">
					
			</div>
			<div class="col-md-3 col-sm-6 col-xs-12">
					
			</div>
			<div class="col-md-3 col-sm-6 col-xs-12">
					
			</div>
			<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box">
						<div class="info-box-content">
							<p class="info-box-text">TỔNG DOANH THU</p>
							<p id="totalOfYear"></p>
						</div>
					</div>
			</div>
          </div>
		</section>
	</div>
	
	<layout:admin_footer></layout:admin_footer>

	<script src="<%=request.getContextPath()%>/resources/js/lib/jQuery-2.1.4.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/app.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin_chart.js"></script>
	<script src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/bootstrap-notify.min.js"></script>
</body>
</html>