<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Welcome</title> 
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="_csrf" content="${_csrf.token}"/>
 	<meta name="_csrf_header" content="${_csrf.headerName}"/>
 	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/index.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/lib/datepicker.css">
</head>
<body ng-app="myApp" ng-controller = "MainCtrl">

	<layout:user_header></layout:user_header>
	
	<section id="myCarousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<c:set var="countIndex" value="${0}"/>
			<c:forEach items="${listEventSlide }" var="slideEventRecent">
				<li data-target="#myCarousel" data-slide-to='<c:out value="${countIndex }"></c:out>' class='<c:if test="${countIndex == 0 }">active</c:if>'></li>
				<c:set var="countIndex" value="${countIndex + 1}"/>
			</c:forEach>
		</ol>

		<div class="carousel-inner" role="listbox">
			<c:set var="countIndex" value="${0}"/>
			<c:forEach items="${listEventSlide }" var="slideEventRecent">
				<div class="item <c:if test="${countIndex == 0 }" >active</c:if>">
					<a href="<%=request.getContextPath()%>/event/<c:out value='${slideEventRecent.path }'></c:out>"><img src="<c:url value="/resources/images/${slideEventRecent.imageThumbnail }" />" alt="event"></a>
				</div>
				<c:set var="countIndex" value="${countIndex + 1}"/>
			</c:forEach>
		</div>

		<a class="left carousel-control" ng-non-bindable href="#myCarousel" data-slide="prev">
			<span class="icon-prev"></span>
		</a> <a class="right carousel-control" ng-non-bindable href="#myCarousel"
			data-slide="next"> <span class="icon-next"></span>
		</a>
	</section>
	<section class="hot-title" id="top-event">
		<spring:message code="index.hotEventTitle" />
	</section>

	<section class="event-container">
		<div id="contain-event-thumbnail" class="row event-element">
		</div>
		<ul class="pager">
			<li><button class="btn btn-default btn-event-pre">trước</button></li>
			<li><button class="btn btn-default btn-ticket btn-event-current"></button></li>
			<li><button class="btn btn-default btn-event-next">tiếp</button></li>
		</ul>
	</section>

	<section class="hot-title" id="top-event">
		<spring:message code="index.eventByCategory" />
	</section>

	<section class="event-category-bar">
		<div class="event-cgb-element">
		<div class="row">
			<div class="col-sm-4 center-position">
				<a href = "<%=request.getContextPath()%>/search?c=am nhac">
				<img class="hidden-xs category" src="<%=request.getContextPath()%>/resources/icon/music_category.png"></img>
				<div class="event-category-title"><spring:message code="index.eventEntertaiment" /></div>
				<div class="event-link"><span id="course-count"></span> <spring:message code="index.eventCount"/></div>
				</a>
			</div>
			<div class="col-sm-4 center-position">
				<a href = "<%=request.getContextPath()%>/search?c=khoa hoc">
				<img class="hidden-xs category" src="<%=request.getContextPath()%>/resources/icon/course_category.png"></img>
				<div class="event-category-title"><spring:message code="index.eventCourse" /></div>
				<div class="event-link"><span id="activity-count"></span> <spring:message code="index.eventCount"/></div>
				</a>
			</div>
			<div class="col-sm-4 center-position">
				<a href = "<%=request.getContextPath()%>/search?c=hoat dong">
				<img class="hidden-xs category" src="<%=request.getContextPath()%>/resources/icon/activity_category.png"></img>
				<div class="event-category-title"><spring:message code="index.eventElse"/></div>
				<div class="event-link"><span id="music-count"></span> <spring:message code="index.eventCount"/></div>
				</a>
			</div>
			
			</div>
		</div>
	</section>
	
	<layout:user_footer></layout:user_footer>

	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.12.1/ui-bootstrap-tpls.min.js"></script>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/bootstrap-notify.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/boostrap-datepicker.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/header.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/index.js"></script>
</body>
</html>