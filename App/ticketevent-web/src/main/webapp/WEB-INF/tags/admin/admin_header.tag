<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@tag pageEncoding="UTF-8"%>

<div class="wrapper">

	<header class="main-header">

		<a href="index2.html" class="logo">
			<span class="logo-lg"><b>Admin TicketEvent</b></span>
		</a>

		<nav class="navbar navbar-static-top" role="navigation">
			<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
				role="button"> <span class="sr-only">Toggle navigation</span>
			</a>
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">

					<li class="dropdown notifications-menu">
						<a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <span
							class="label label-warning">10</span>
					</a>
						<ul class="dropdown-menu">
							<li class="header">You have 10 notifications</li>
							<li>
								<ul class="menu">
									<li>
										<a href="#"> <i
											class="fa fa-users text-aqua"></i> 5 new members joined today
									</a>
									</li>
								</ul>
							</li>
							<li class="footer"><a href="#">View all</a></li>
						</ul>
					</li>
					<li class="dropdown user user-menu">
						<a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> 
							<c:choose>
							<c:when test="${account.userInfor.avatar != null}">
								<img src="<c:url value="/resources/images/avatar/${account.userInfor.avatar}"/>" class="user-image" alt="Your avatar" />
							</c:when>
							<c:otherwise>
								<img src="http://plugins.krajee.com/uploads/default_avatar_male.jpg" class="user-image" alt="Your avatar"/>
							</c:otherwise>
						</c:choose>
							<span class="hidden-xs"><c:out value="${account.userName}"></c:out></span>
					</a>
						<ul class="dropdown-menu">
							<li class="user-header"><img src="#" class="img-circle userAvatar"	alt="User Image" />
								<p>
									<c:out value="${account.userName}"></c:out> - TicketEvent Administrator
								</p></li>
							<!-- Menu Footer-->
							<li class="user-footer">
								<div class="pull-right">
									<a href="logout" class="btn btn-default btn-flat">Sign out</a>
								</div>
							</li>
						</ul>
					</li>
					<li><a href="#" data-toggle="control-sidebar"><i
							class="fa fa-gears"></i></a></li>
				</ul>
			</div>
		</nav>
	</header>
	<aside class="main-sidebar">

		<section class="sidebar">

			<div class="user-panel">
				<div class="pull-left image">
					<img src="#" class="img-circle userAvatar" alt="Your avatar" />
				</div>
				<div class="pull-left info">
					<p><c:out value="${account.userName}"></c:out></p>
				</div>
			</div>

			<form action="#" method="get" class="sidebar-form">
				<div class="input-group">
					<input type="text" name="q" class="form-control"
						placeholder="Search..." /> <span class="input-group-btn">
						<button type="submit" name="search" id="search-btn"
							class="btn btn-flat">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div>
			</form>

			<ul class="sidebar-menu">
				<li class="header">Dashboard</li>
				<li class="active"><a href="<%=request.getContextPath()%>/admin-page"><i
						class="fa fa-dashboard"></i> <span>Bảng điều khiển</span></a></li>
				<li><a href="#"><i class="fa fa-leaf"></i> <span>Quản lí sự kiện</span></a></li>
				<li><a href="<%=request.getContextPath()%>/user-management?page=1&type=2"><i class="fa fa-users"></i> <span>Quản lí tài khoản</span></a></li>
				<li><a href="#"><i class="fa fa-pie-chart"></i> <span>Thống kê</span></a></li>
				<li><a href="<%=request.getContextPath()%>/admin-comment-manage?page=1"><i class="fa fa-comment"></i>
						<span>Quản lí bình luận</span><small class="label pull-right bg-blue">12</small></a></li>
			</ul>
		</section>
	</aside>