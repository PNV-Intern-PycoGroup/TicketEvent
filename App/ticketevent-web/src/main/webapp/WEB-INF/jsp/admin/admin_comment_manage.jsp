<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
	<title>TicketEvent Quản trị viên</title>
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
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				Dashboard <small>Version 2.0</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
				<li class="active">Dashboard</li>
			</ol>
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">New Comments</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<button id="delete">Delete</button>
							<table class="table table-bordered">
								<tr>
									<th><input type="checkbox" id="selectAll"></th>
									<th>Comment ID</th>
									<th>By User</th>
									<th>Content</th>
									<th>Date</th>
									<th>Event</th>
									<th>Status</th>
									<td>Action</td>
								</tr>
								<tr>
									<td><input type="checkbox" class="selectID" value="abc"
										name="commentID"></td>
									<td>1.</td>
									<td>Update software</td>
									<td>Có bao nhiêu loại vé ad ?</td>
									<td>20/6/2016</td>
									<td>Music</td>
									<td>abc</td>
									<td>delete</td>
								</tr>
								<tr>
									<td><input type="checkbox" class="selectID"></td>
									<td>1.</td>
									<td>Update software</td>
									<td>Có bao nhiêu loại vé ad ?</td>
									<td>20/6/2016</td>
									<td>Music</td>
									<td>abc</td>
									<td>delete</td>
								</tr>
								<tr>
									<td><input type="checkbox" class="selectID"></td>
									<td>1.</td>
									<td>Update software</td>
									<td>Có bao nhiêu loại vé ad ?</td>
									<td>20/6/2016</td>
									<td>Music</td>
									<td>abc</td>
									<td>delete</td>
								</tr>
								<tr>
									<td><input type="checkbox" class="selectID"></td>
									<td>1.</td>
									<td>Update software</td>
									<td>Có bao nhiêu loại vé ad ?</td>
									<td>20/6/2016</td>
									<td>Music</td>
									<td>abc</td>
									<td>delete</td>
								</tr>
							</table>
						</div>
						<!-- /.box-body -->
						<div class="box-footer clearfix">
							<ul class="pagination pagination-sm no-margin pull-right">
								<li><a href="#">&laquo;</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">&raquo;</a></li>
							</ul>
						</div>
					</div>
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
	<script src="<%=request.getContextPath()%>/resources/js/lib/app.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin.js"></script>
</body>
</html>