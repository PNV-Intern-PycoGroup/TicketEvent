<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag pageEncoding="UTF-8"%>


<link rel="stylesheet"
	href="/ticketevent-web/resources/css/theme_activity.css">
<link rel="stylesheet"
	href="/ticketevent-web/resources/css/header_style.css">

<article>
	<section class="banner">
		<figure>
			<img class="img-cover" alt=""
				src="https://az810058.vo.msecnd.net/static-page/img/escapeRave-logo.png">
		</figure>
		<h3>09:00 10.10.2010 tp Hồ Chí Minh</h3>
		<div class="content content-description">
			<div class="col-md-3">
				<p>Miêu tả sự kiện của bạn ở đây. Đây chính là nơi bạn miêu tả sự kiện của bạn cho mọi người có thể hình dung ra được.</p>
			</div>
			<div id="slide-event" class="carousel slide col-md-6" data-ride="carousel">
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
			<div class="col-md-3">
				<p><label>09:00 Ngày 20.11.2015 tại TP Hồ Chí Minh</label></p>
				<p>Giá vé: <label>400.000 vnđ</label></p>
				<button class="btn btn-default" >Mua vé ngay</button>
			</div>
		</div>
	</section>
</article>
<!-- Script -->

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script src="/ticketevent-web/resources/js/scroll_effect.js"></script>
