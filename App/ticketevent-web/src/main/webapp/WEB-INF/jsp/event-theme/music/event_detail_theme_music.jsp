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
	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/music/event_detail_theme_music.css">
</head>
<body data-spy="scroll" data-target="#scroll-page" data-offset="100">
	<header>
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
			<figure>
				<img class="img-cover" alt=""
					src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1">
			</figure>
		</section>
		<section id="introduction">
			<div class="content">
				<h1>Giới thiệu</h1>
				<p>Quest 2016 đã trở lại ở một đẳng cấp mới! Được bình chọn là
					một trong những lễ hội mãn nhãn nhất thế giới và một trong những lễ
					hội mang tính tiên phong của Châu Á (Mixmag, Buzzfeed), hãy chuẩn bị
					tinh thần để cho một dịp vui chưa từng có. Quest là đơn vị đầu tiên
					giới thiệu tới khán giả Việt Nam mô hình lễ hội âm nhạc với hơn 150
					nghệ sĩ trong nước và quốc tế, biểu diễn tại 4 sân khấu tuyệt đẹp
					cùng với các hoạt động điện ảnh, workshop, nghệ thuật đường phố và
					hơn thế nữa … Tổ chức tại khuôn viên sinh thái Sơn Tinh camp (Ba Vì,
					Hà Nội), Quest là 3 ngày nguyên vẹn của những trải nghiệm âm nhạc,
					nghệ thuật giữa thiên nhiên.</p>
			</div>
		</section>
		<section id="famous-person">
			<div class="content">
				<h1>Người nổi tiếng</h1>
				<div id="famous-person-slider" class="carousel slide vertical">
					<!-- Carousel items -->
					<div class="carousel-inner">
						<div class="active item">
							<img class="img-cover col-md-6"
								src="http://placehold.it/600x400&amp;text=First+Slide">
							<div class="col-md-6">
								<h2>1. Nghệ danh</h2>
								<p>
									<label>Ngày sinh: </label><span>11/12/1996</span>
								</p>
								<p>
									<label>Tài năng, tính cách: </label><span>ok</span>
								</p>
								<p>
									<label>Quá trình hoạt động: </label><span>ok</span>
								</p>
							</div>
						</div>
						<div class="item">
							<img class="img-cover col-md-6"
								src="http://placehold.it/600x400&amp;text=Second+Slide">
							<div class="col-md-6">
								<h2>2. Nghệ danh</h2>
								<p>
									<label>Ngày sinh: </label><span>1/1/1996</span>
								</p>
								<p>
									<label>Tài năng, tính cách: </label><span>ok</span>
								</p>
								<p>
									<label>Quá trình hoạt động: </label><span>ok</span>
								</p>
							</div>
						</div>
						<div class="item">
							<img class="img-cover col-md-6"
								src="http://placehold.it/600x400&amp;text=Third+Slide">
							<div class="col-md-6">
								<h2>3. Nghệ danh</h2>
								<p>
									<label>Ngày sinh: </label><span>18/09/1996</span>
								</p>
								<p>
									<label>Tài năng, tính cách: </label><span>ok</span>
								</p>
								<p>
									<label>Quá trình hoạt động: </label><span>ok</span>
								</p>
							</div>
						</div>
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
				<iframe src="https://www.youtube.com/embed/AQm9GDjVdgs"
					frameborder="0" allowfullscreen></iframe>
			</div>
		</section>
		<section id="library-image">
			<div>
				<h1>Thư viện ảnh</h1>
				<div id="slide-lib-image" class="carousel slide content">
					<div class="carousel-inner">
						<div class="item active">
							<img class="img-cover"
								src="http://placehold.it/350x250/e8117f/fff&amp;text=Product+Main">
						</div>
						<div class="item">
							<img class="img-cover"
								src="http://placehold.it/350x250/00ffff/000&amp;text=Product+Image+2">
						</div>
						<div class="item">
							<img class="img-cover"
								src="http://placehold.it/350x250/ff00ff/fff&amp;text=Product+Image+3">
						</div>
						<div class="item">
							<img class="img-cover"
								src="http://placehold.it/350x250/ffff00/000&amp;text=Product+Image+4">
						</div>
						<div class="item">
							<img class="img-cover"
								src="http://placehold.it/350x250/612b65/fff&amp;text=Product+Image+5">
						</div>
						<div class="item">
							<img class="img-cover"
								src="http://placehold.it/350x250/00ffff/000&amp;text=Product+Image+6">
						</div>
						<div class="item">
							<img class="img-cover"
								src="http://placehold.it/350x250/db371b/fff&amp;text=Product+Image+7">
						</div>
						<div class="item">
							<img class="img-cover"
								src="http://placehold.it/350x250/feb8aa/000&amp;text=Product+Image+8">
						</div>
					</div>
				</div>
				<div class="clearfix">
					<div class="carousel slide" data-interval="false">
						<div>
							<div class="item active">
								<div data-target="#slide-lib-image" data-slide-to="0"
									class="thumb">
									<img
										src="http://placehold.it/100/e8117f/fff&amp;text=Product+Main">
								</div>
								<div data-target="#slide-lib-image" data-slide-to="1"
									class="thumb">
									<img
										src="http://placehold.it/100/00ffff/000&amp;text=Product+Image+2">
								</div>
								<div data-target="#slide-lib-image" data-slide-to="2"
									class="thumb">
									<img
										src="http://placehold.it/100/ff00ff/fff&amp;text=Product+Image+3">
								</div>
								<div data-target="#slide-lib-image" data-slide-to="3"
									class="thumb">
									<img
										src="http://placehold.it/100/ffff00/000&amp;text=Product+Image+4">
								</div>
	
								<div data-target="#slide-lib-image" data-slide-to="4"
									class="thumb">
									<img
										src="http://placehold.it/100/612b65/fff&amp;text=Product+Image+5">
								</div>
								<div data-target="#slide-lib-image" data-slide-to="5"
									class="thumb">
									<img
										src="http://placehold.it/100/00ffcc/000&amp;text=Product+Image+6">
								</div>
								<div data-target="#slide-lib-image" data-slide-to="6"
									class="thumb">
									<img
										src="http://placehold.it/100/db371b/fff&amp;text=Product+Image+7">
								</div>
								<div data-target="#slide-lib-image" data-slide-to="7"
									class="thumb">
									<img
										src="http://placehold.it/100/feb8aa/000&amp;text=Product+Image+8">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<section id="place">
			<div class="content">
				<h1>Địa điểm</h1>
				<p class="small-content"><label class="event-time">06:00 Ngày 11/12/2015</label> <label> tại nhà tui</label> </p>
				<figure>
					<img class="img-cover" alt=""
						src="https://az810058.vo.msecnd.net/static-page/img/365-seatmap.png">
				</figure>
				<button class="btn btn-default btn-large">Đặt vé ngay</button>
			</div>
		</section>
		<section id="organizer">
			<div class="content">
				<h1>Ban tổ chức</h1>
				<div>
					<figure class="col-md-4">
						<img class="img-cover" alt=""
							src="http://netcommsuisse.ch/dam/jcr:837b5fcf-5068-43e0-9000-a1a149e94587/11bba7189814-logo_PYCOGROUP_3quare_3x%20(1).2016-06-15-10-16-41.png">
					</figure>
					<p class="col-md-8">Pyco Group is divided in 3 main departments.
						Pyco Consulting, it's a digital service provider. Pyco Digital who
						is a premium offshore production center. Pyco Ventures that allows
						companies to scale their business through BOT.</p>
				</div>
			</div>
		</section>
	</article>
	
	<layout:comment></layout:comment>
	<layout:user_footer></layout:user_footer>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/autosize.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/event-theme/music/event_detail_theme_music.js"></script>
</body>
</html>