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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/study/event_detail_theme_study.css">

</head>
<body data-spy="scroll" data-target="#scroll-page" data-offset="100">
	<header>
		<nav class="navbar navbar-default navbar-fixed-top" id="scroll-page">
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
	<article>
		<section>
			<figure>
				<img class="img-cover" alt=""
					src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1">
			</figure>
		</section>
		<section id="introduction">
			<div class="content">
				<h1>Giới thiệu về khóa học</h1>
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
		<section id="content">
			<div class="content">
				<h1>Nội dung</h1>
				<ul class="timeline">
					<li>
						<div class="timeline-badge">
							<i class="glyphicon glyphicon-chevron-left"></i>
						</div>
						<div class="timeline-panel">
							<h4>Nội dung 1</h4>
							<p>
								Bạn học được gì? nhận được thành quả gì sau nội dung đó?
							</p>
						</div>
					</li>
					<li class="timeline-inverted">
						<div class="timeline-badge">
							<i class="glyphicon glyphicon-chevron-right"></i>
						</div>
						<div class="timeline-panel">
							<h4>Nội dung 2</h4>
							<p>
								Bạn học được gì? nhận được thành quả gì sau nội dung đó?
							</p>
						</div>
					</li>
					<li>
						<div class="timeline-badge">
							<i class="glyphicon glyphicon-chevron-left"></i>
						</div>
						<div class="timeline-panel">
							<h4>Nội dung 3</h4>
							<p>
								Bạn học được gì? nhận được thành quả gì sau nội dung đó?
							</p>
						</div>
					</li>
				</ul>
			</div>
		</section>
		<section id="teacher">
			<div class="content">
				<h1>Diễn giả</h1>
				<div id="teacher-slider" class="carousel slide vertical">
					<!-- Carousel items -->
					<div class="carousel-inner">
						<div class="active item">
							<img class="img-cover col-md-6"
								src="http://placehold.it/600x400&amp;text=First+Slide">
							<div class="col-md-6">
								<h2>1. GS. Huỳnh Văn A</h2>
								<p>
									<label>Kinh nghiệm: </label><span>Java, ...</span>
								</p>
								<p>
									<label>Hoạt động: </label><span>ok</span>
								</p>
							</div>
						</div>
						<div class="item">
							<img class="img-cover col-md-6"
								src="http://placehold.it/600x400&amp;text=Second+Slide">
							<div class="col-md-6">
								<h2>2. TS. Phạm Văn B</h2>
								<p>
									<label>Kinh nghiệm: </label><span>Android, ...</span>
								</p>
								<p>
									<label>Hoạt động: </label><span>ok</span>
								</p>
							</div>
						</div>
					</div>
					<!-- Carousel nav -->
					<a class="carousel-control left" href="#teacher-slider"
						data-slide="prev"><i class="fa fa-arrow-circle-up"
						aria-hidden="true"></i></a> <a class="carousel-control right"
						href="#teacher-slider" data-slide="next"><i
						class="fa fa-arrow-circle-down" aria-hidden="true"></i></a>
				</div>
			</div>
		</section>
		<section id="place">
			<div class="content">
				<h1>Địa điểm</h1>
				<p class="small-content">
					<label class="event-time">19:00 Ngày 18/9/2014</label> <label>tại
						nhà</label>
				</p>
				<figure>
					<img class="img-cover" alt=""
						src="https://az810058.vo.msecnd.net/static-page/img/365-seatmap.png">
				</figure>
				<button class="btn btn-default btn-large btn-ticket">Đặt vé ngay</button>
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
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/autosize.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/event-theme/study/event_detail_theme_study.js"></script>
</body>
</html>