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
	
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/activity/event_detail_theme_activity.css">
</head>
<body>
	<article>
		<section class="banner">
			<!-- Facebook -->
		    <a class="btn-share btn-share-facebook" href="http://www.facebook.com/sharer.php?u=http://localhost:8080/ticketevent-web/event/<c:out value="${event.path }"></c:out>" target="_blank" title="share on facebook">
		        <i class="fa fa-facebook" aria-hidden="true"></i>
		    </a>
		    <!-- Google+ -->
		    <a class="btn-share btn-share-google-plus" href="https://plus.google.com/share?url=http://localhost:8080/ticketevent-web/event/<c:out value="${event.path }"></c:out>" target="_blank" title="share on google plus">
		        <i class="fa fa-google-plus" aria-hidden="true"></i>
		    </a>
		    
			<input id="event-id" type="hidden" value='<c:out value="${event.id }"></c:out>' />
			<input id="activity-bg" type="hidden" value='<c:url value="/resources/images/${activityLayout.backgroundImage }" />' />
			<figure>
				<img class="img-cover" alt="" src='<c:url value="/resources/images/${activityLayout.eventLogo }" />'>
			</figure>
			<h3>
				<c:out value="${event.getHoursStartDate() } ${event.getDateStartDate() } - ${event.getHoursEndDate() } ${event.getDateEndDate() } ${event.place }"></c:out>
			</h3>
			<h4><i class="fa fa-quote-left" aria-hidden="true"></i> <c:out value="${activityLayout.sologan }"></c:out> <i class="fa fa-quote-right" aria-hidden="true"></i></h4>
			<div class="content content-description">
				<div class="col-md-4">
					<p><c:out value="${event.introduction }"></c:out></p>
					<p>Giá vé: <label>400.000 vnđ</label></p>
					<button class="btn btn-default btn-ticket btn-buy-ticket" >Mua vé ngay</button>
				</div>
				<div id="slide-event" class="carousel slide col-md-8" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<c:set var="imageLibIndex" value="${0}"/>
						<c:forEach items="${activityLayout.listActivityLayoutImageLibrary }" var="imageLib">
							<li data-target="#slide-event" data-slide-to='<c:out value="${imageLibIndex }"></c:out>' class='<c:if test="${imageLibIndex == 0 }">active</c:if>'></li>
							<c:set var="imageLibIndex" value="${imageLibIndex + 1}"/>
						</c:forEach>
					</ol>
	
					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<c:set var="imageLibIndex" value="${0}"/>
						<c:forEach items="${activityLayout.listActivityLayoutImageLibrary }" var="imageLib">
							<div class="item <c:if test="${imageLibIndex == 0 }">active</c:if>">
								<img class="img-cover" src="<c:url value="/resources/images/${imageLib.image }" />" alt="">
							</div>
							<c:set var="imageLibIndex" value="${imageLibIndex + 1}"/>
						</c:forEach>
					</div>
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
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/autosize.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/bootstrap-notify.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/event-theme/activity/event_detail_theme_activity.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/event-theme/comment.js"></script>
</body>
</html>