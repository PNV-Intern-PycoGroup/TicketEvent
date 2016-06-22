<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag pageEncoding="UTF-8"%>

<link rel="stylesheet"
	href="/ticketevent-web/resources/css/comment.css">

<section class="comment ">
	<div class="content">
		<h1>Bình luận (1000)</h1>
		<div class="blog-comment">
			<ul class="comments">
				<li class="clearfix">
					<div class="post-comments">
						<div class="meta">
							<img src="http://bootdey.com/img/Content/user_1.jpg" class="avatar" alt="">
							<p>
								Ngày 18 tháng 5, 2015 <a href="#">Sonhv</a> đã bình luận :
							</p>
						</div>
						<p>Bình luận Demo</p>
					</div></li>
				<li class="clearfix">
					<div class="post-comments">
						<div class="meta">
							<img src="http://bootdey.com/img/Content/user_2.jpg" class="avatar" alt="">
							<p>
								May 19, 2016 <a href="#">Ypv</a> says :
							</p>
						</div>
						<p>Bình luận demo</p>
					</div>
				</li>
			</ul>
			<h2>Bình Luận của bạn</h2>
			<form action="" class="comment-box">
				<textarea rows="6" id="autosize-textarea"></textarea>
				<button class="btn btn-default" type="submit">Bình luận</button>
			</form>
		</div>
	</div>
</section>

<script src="/ticketevent-web/resources/js/autosize.min.js"></script>