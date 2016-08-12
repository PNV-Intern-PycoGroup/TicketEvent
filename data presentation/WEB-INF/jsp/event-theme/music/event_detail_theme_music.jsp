<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<title>Event detail | </title>
	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/music/event_detail_theme_music.css">
</head>
<body data-spy="scroll" data-target="#scroll-page" data-offset="100">
	<header>
		<input id="event-id" type="hidden" value='<c:out value="${event.id }"></c:out>' />
		<nav class="navbar navbar-default navbar-fixed-top"  id="scroll-page">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand toggle-close" href="<%=request.getContextPath()%>" id="home"></a>
				<ul class="nav navbar-nav toggle-close">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Ngôn ngữ  <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li>
								<a href="?lang=vi">
									<img src="<c:url value="/resources/icon/flag_vn.png" />"></img> Tiếng Việt
								</a>
								<a href="?lang=en">
									<img src="<c:url value="/resources/icon/flag_en.png" />"></img> English
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
	                       <a class="page-scroll" href="#famous-person">Người nổi tiếng</a>
	                   </li>
	                   <li>
	                       <a class="page-scroll" href="#famous-song">Sáng tác nổi bật</a>
	                   </li>
	                   <li>
	                       <a class="page-scroll" href="#library-image">Thư viện ảnh</a>
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
	
	<article>
		<section>
			<!-- Facebook -->
		    <a class="btn-share btn-share-facebook" href="http://www.facebook.com/sharer.php?u=http://localhost:8080/ticketevent-web/event/<c:out value="${event.path }"></c:out>" target="_blank" title="share on facebook">
		        <i class="fa fa-facebook" aria-hidden="true"></i>
		    </a>
		    <!-- Google+ -->
		    <a class="btn-share btn-share-google-plus" href="https://plus.google.com/share?url=http://localhost:8080/ticketevent-web/event/<c:out value="${event.path }"></c:out>" target="_blank" title="share on google plus">
		        <i class="fa fa-google-plus" aria-hidden="true"></i>
		    </a>
			<figure>
				<img class="img-cover" alt="" src="<c:url value="/resources/images/${musicLayout.bannerImage }" />">
			</figure>
		</section>
		<section id="introduction">
			<div class="content">
				<h1>Giới thiệu</h1>
				<p><c:out value="${event.introduction }"></c:out></p>
			</div>
		</section>
		<section id="famous-person">
			<div class="content">
				<h1>Người nổi tiếng</h1>
				<div id="famous-person-slider" class="carousel slide vertical">
					<!-- Carousel items -->
					<div class="carousel-inner">
						<c:set var="countIndex" value="${0}"/>
						<c:forEach items="${musicLayout.listMusicLayouFamousPerson }" var="famousPerson">
							<div class="<c:if test="${countIndex == 0 }">active</c:if> item">
								<img class="img-cover col-md-6" src='<c:url value="/resources/images/${famousPerson.image }" />'>
								<div class="col-md-6">
									<h2><c:out value="${countIndex + 1 }. ${famousPerson.name }"></c:out></h2>
									<p>
										<label>Ngày sinh: </label><span><c:out value="${famousPerson.getDateOfBirthString() }"></c:out></span>
									</p>
									<p>
										<label>Giới thiệu: </label><span><c:out value="${famousPerson.introduction }"></c:out></span>
									</p>
								</div>
							</div>
							<c:set var="countIndex" value="${countIndex + 1}"/>
						</c:forEach>
					</div>
					<!-- Carousel nav -->
					<a class="carousel-control left" href="#famous-person-slider"
						data-slide="prev"><i class="fa fa-arrow-circle-up"
						aria-hidden="true"></i></a> <a class="carousel-control right"
						href="#famous-person-slider" data-slide="next"><i
						class="fa fa-arrow-circle-down" aria-hidden="true"></i></a>
				</div>
			</div>
		</section>
		<section id="famous-song">
			<div class="content">
				<h1>Sáng tác nổi bật</h1>
				<iframe src="<c:out value="${musicLayout.linkHighlight }"></c:out>"
					frameborder="0" allowfullscreen></iframe>
			</div>
		</section>
		<section id="library-image">
			<div>
				<h1>Thư viện ảnh</h1>
				<div id="slide-lib-image" class="carousel slide content">
					<div class="carousel-inner">
						<c:set var="countIndex" value="${0}"/>
						<c:forEach items="${musicLayout.listMusicLayoutImageLibrary }" var="imageLib">
							<div class="item <c:if test="${countIndex == 0 }">active</c:if>">
								<img class="img-cover" src="<c:url value="/resources/images/${imageLib.image }" />" alt="image library">
							</div>
							<c:set var="countIndex" value="${countIndex + 1}"/>
						</c:forEach>
					</div>
				</div>
				<div class="clearfix">
					<div class="carousel slide" data-interval="false">
						<div>
							<div class="item active">
								<c:set var="countIndex" value="${0}"/>
								<c:forEach items="${musicLayout.listMusicLayoutImageLibrary }" var="imageLib">
									<div data-target="#slide-lib-image" data-slide-to='<c:out value="${countIndex}"></c:out>' class="thumb">
										<img src="<c:url value="/resources/images/${imageLib.image }" />" alt="image library">
									</div>
									<c:set var="countIndex" value="${countIndex + 1}"/>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<section id="place">
			<div class="content">
				<h1>Địa điểm</h1>
				<p class="small-content">
					<label class="event-time">
						<c:out value="${event.getHoursStartDate() } ${event.getDateStartDate() } - ${event.getHoursEndDate() } ${event.getDateEndDate() }"></c:out>
					</label> <label> <c:out value="${event.place }"></c:out></label> </p>
				<figure>
					<img class="img-cover" alt="Địa điểm" src="<c:url value="/resources/images/${musicLayout.placeImage }" />">
				</figure>
				<button class="btn btn-default btn-large btn-buy-ticket">Đặt vé ngay</button>
			</div>
		</section>
		<section id="organizer">
			<div class="content">
				<h1>Ban tổ chức</h1>
				<div>
					<figure class="col-md-4">
						<img class="organization-image" alt="Ban tổ chức" src="<c:url value="/resources/images/${event.organizeLogo }" />">
					</figure>
					<p class="col-md-8"><c:out value="${event.organizeInfo }"></c:out></p>
				</div>
			</div>
		</section>
	</article>
	<article>
		<section class="content">
			<input id="map-place" type="hidden" value='<c:out value="${event.place }"></c:out>' />
			<div class="contain-map">
				<div id='gmap_canvas'></div>
			</div>
		</section>
		<layout:comment></layout:comment>
	</article>
	<layout:user_footer></layout:user_footer>
	
	<script src='https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&key=AIzaSyBFR-TVgJEJLGO0StzbDW6lGYGLlu4a0qs'></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/autosize.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/bootstrap-notify.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/event-theme/music/event_detail_theme_music.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/event-theme/comment.js"></script>
</body>
</html>