<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@tag pageEncoding="UTF-8"%>

<div class="wrapper">

	<!-- Main Header -->
	<header class="main-header">

		<!-- Logo -->
		<a href="index2.html" class="logo"> <!-- logo for regular state and mobile devices -->
			<span class="logo-lg"><b>Admin TicketEvent</b></span>
		</a>

		<!-- Header Navbar -->
		<nav class="navbar navbar-static-top" role="navigation">
			<!-- Sidebar toggle button-->
			<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
				role="button"> <span class="sr-only">Toggle navigation</span>
			</a>
			<!-- Navbar Right Menu -->
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">

					<!-- Notifications Menu -->
					<li class="dropdown notifications-menu">
						<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <span
							class="label label-warning">10</span>
					</a>
						<ul class="dropdown-menu">
							<li class="header">You have 10 notifications</li>
							<li>
								<!-- Inner Menu: contains the notifications -->
								<ul class="menu">
									<li>
										<!-- start notification --> <a href="#"> <i
											class="fa fa-users text-aqua"></i> 5 new members joined today
									</a>
									</li>
									<!-- end notification -->
								</ul>
							</li>
							<li class="footer"><a href="#">View all</a></li>
						</ul>
					</li>
					<!-- User Account Menu -->
					<li class="dropdown user user-menu">
						<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> 
							<c:choose>
							<c:when test="${account.avatar != null}">
								<img src="<c:url value="/resources/images/avatar/${account.avatar}"/>" class="user-image" alt="Your avatar" />
							</c:when>
							<c:otherwise>
								<img src="http://plugins.krajee.com/uploads/default_avatar_male.jpg" class="user-image" alt="Your avatar"/>
							</c:otherwise>
						</c:choose>
							<span class="hidden-xs"><c:out value="${account.name}"></c:out></span>
					</a>
						<ul class="dropdown-menu">
							<!-- The user image in the menu -->
							<li class="user-header"><img src="#" class="img-circle userAvatar"	alt="User Image" />
								<p>
									<c:out value="${account.name}"></c:out> - TicketEvent Administrator
								</p></li>
							<!-- Menu Footer-->
							<li class="user-footer">
								<div class="pull-right">
									<a href="logout" class="btn btn-default btn-flat">Sign out</a>
								</div>
							</li>
						</ul>
					</li>
					<!-- Control Sidebar Toggle Button -->
					<li><a href="#" data-toggle="control-sidebar"><i
							class="fa fa-gears"></i></a></li>
				</ul>
			</div>
		</nav>
	</header>
	<!-- Left side column. contains the logo and sidebar -->
	<aside class="main-sidebar">

		<!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar">

			<!-- Sidebar user panel (optional) -->
			<div class="user-panel">
				<div class="pull-left image">
					<img src="#" class="img-circle userAvatar" alt="Your avatar" />
				</div>
				<div class="pull-left info">
					<p><c:out value="${account.name}"></c:out></p>
				</div>
			</div>

			<!-- search form (Optional) -->
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
			<!-- /.search form -->

			<!-- Sidebar Menu -->
			<ul class="sidebar-menu">
				<li class="header">Dashboard</li>
				<!-- Optionally, you can add icons to the links -->
				<li class="active"><a href="<%=request.getContextPath()%>/admin-page"><i
						class="fa fa-dashboard"></i> <span>Dashboard</span></a></li>
				<li><a href="#"><i class="fa fa-leaf"></i> <span>Events</span></a></li>
				<li><a href="<%=request.getContextPath()%>/user-management"><i class="fa fa-users"></i> <span>Users</span></a></li>
				<li><a href="#"><i class="fa fa-pie-chart"></i> <span>Chart</span></a></li>
				<li><a href="<%=request.getContextPath()%>/admin-comment-manage"><i class="fa fa-comment"></i>
						<span>New Comments</span><small class="label pull-right bg-blue">12</small></a></li>
			</ul>
			<!-- /.sidebar-menu -->
		</section>
		<!-- /.sidebar -->
	</aside>