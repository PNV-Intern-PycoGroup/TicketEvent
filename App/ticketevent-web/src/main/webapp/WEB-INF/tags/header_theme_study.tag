<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag pageEncoding="UTF-8" %>

<link rel="stylesheet" href="/ticketevent-web/resources/css/header_style.css">
<header>
	<nav class="navbar navbar-default navbar-fixed-top">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand toggle-close" href="#" id="home"></a>
			<ul class="nav navbar-nav toggle-close">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Ngôn ngữ  <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li>
							<a href="?lang=vi">
								<img src="resources/icon/flag_vn.png"></img> Tiếng Việt
							</a>
							<a href="?lang=en">
								<img src="resources/icon/flag_en.png"></img> English
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
                   <li>
                       <a class="page-scroll" href="#introduction">Giới thiệu</a>
                   </li>
                   <li>
                       <a class="page-scroll" href="#content">Nội dung</a>
                   </li>
                   <li>
                       <a class="page-scroll" href="#teacher">Diễn giả</a>
                   </li>
                   <li>
                       <a class="page-scroll" href="#place">Địa điểm</a>
                   </li>
                   <li>
                       <a class="page-scroll" href="#organizer">Ban tổ chức</a>
                   </li>
               </ul>
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="clear"></div>
</header>
	
<!-- Script -->

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>