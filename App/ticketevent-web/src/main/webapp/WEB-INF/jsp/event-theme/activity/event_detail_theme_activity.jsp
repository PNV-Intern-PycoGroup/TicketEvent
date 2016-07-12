<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>Event detail | </title>
	
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/activity/event_detail_theme_activity.css">
</head>
<body>
	<article>
		<section class="banner">
			<figure>
				<img class="img-cover" alt=""
					src="https://az810058.vo.msecnd.net/static-page/img/escapeRave-logo.png">
			</figure>
			<h3>09:00 10.10.2010 tp Hồ Chí Minh</h3>
			<h4><i class="fa fa-quote-left" aria-hidden="true"></i> Sologan của sự kiện <i class="fa fa-quote-right" aria-hidden="true"></i></h4>
			<div class="content content-description">
				<div class="col-md-4">
					<p>Miêu tả sự kiện của bạn ở đây. Đây chính là nơi bạn miêu tả sự kiện của bạn cho mọi người có thể hình dung ra được.
					Miêu tả sự kiện của bạn ở đây. Đây chính là nơi bạn miêu tả sự kiện của bạn cho mọi người có thể hình dung ra được.
					Miêu tả sự kiện của bạn ở đây. Đây chính là nơi bạn miêu tả sự kiện của bạn cho mọi người có thể hình dung ra được.</p>
					<p>Giá vé: <label>400.000 vnđ</label></p>
					<button class="btn btn-default btn-ticket" >Mua vé ngay</button>
				</div>
				<div id="slide-event" class="carousel slide col-md-8" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#slide-event" data-slide-to="0" class="active"></li>
						<li data-target="#slide-event" data-slide-to="1"></li>
						<li data-target="#slide-event" data-slide-to="2"></li>
					</ol>
	
					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img class="img-cover" src="http://placehold.it/600x400&amp;text=First+Slide" alt="">
						</div>
	
						<div class="item">
							<img class="img-cover" src="http://placehold.it/600x400&amp;text=Second+Slide" alt="">
						</div>
	
						<div class="item">
							<img class="img-cover" src="http://placehold.it/600x400&amp;text=Third+Slide" alt="">
						</div>
					</div>
				</div>
			</div>
		</section>
	</article>
	
	<layout:comment></layout:comment>
	<layout:user_footer></layout:user_footer>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/autosize.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/event-theme/activity/event_detail_theme_activity.js"></script>
</body>
</html>