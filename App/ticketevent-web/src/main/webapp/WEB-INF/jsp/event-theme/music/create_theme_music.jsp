<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/music/create_theme_music.css">

<h1>Tạo sự kiện chủ đề ca nhạc với giao diện có sẵn của ticketevent.vn</h1>

<div>
	<h2>Ảnh cho sự kiện</h2>
	<div class="output-image">
		<img class="col-md-6" alt="Image upload" src="" />
		<div class="col-md-6 info-image">
			<span class="col-md-12">
				<label>Trạng thái:</label> <span class="status">Bạn hãy chọn ảnh ...</span>
			</span>
			<a href="" title="Tải lên banner." class="col-md-12 btn btn-default">
				<input class="hidden-file input-image" type="file" />
				Tải lên banner của sự kiện
				<i class="fa fa-upload" aria-hidden="true"></i>
			</a>
		</div>
	</div>
	<div class="output-image">
		<img class="col-md-6" alt="Image upload" src="" />
		<div class="col-md-6 info-image">
			<span class="col-md-12">
				<label>Trạng thái:</label> <span class="status">Bạn hãy chọn ảnh ...</span>
			</span>
			<a href="" title="Ảnh này sẽ miêu tả địa điểm diển ra sự kiện." class="col-md-12 btn btn-default">
				<input class="hidden-file input-image" type="file" />
				Tải lên ảnh địa điểm của sự kiện
				<i class="fa fa-upload" aria-hidden="true"></i>
			</a>
		</div>
	</div>
	<h2>Người nổi tiếng</h2>
	<div class="add-famous-person child-center">
		<a href="" class="btn btn-default btn-add-famous-person" title="Thêm người nổi tiếng">
			Thêm người nổi tiếng
			<i class="fa fa-plus-circle" aria-hidden="true"></i>
		</a>
	</div>
	<div class="contain-person-highlight">
		<div class="col-md-12">
			<figure class="col-md-3">
				<img alt="Library image upload" src="/ticketevent-web/resources/images/1.jpg">
			</figure>
			<div class="col-md-9">
				<div class="input-group col-md-12 cus-input-group-theme-music">
					<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-music">Nghệ danh</span>
					<span class="form-control cus-form-control-theme-study" >Huỳnh Văn A</span>
				</div>
				<div class="input-group col-md-12 cus-input-group-theme-music">
					<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-music">Ngày sinh</span>
					<span class="form-control cus-form-control-theme-music" >11/12/1996</span>
				</div>
				<div class="cus-event-info-theme-music">
					<span class="label-event-info cus-input-group-addon-create-event">Giới thiệu hoặc mô tả đôi nét về diễn giả</span>
					<p class="textarea-event-info" >Là một ca sĩ, nhạc sĩ nổi tiếng trong ngành giải trí Việt Nam</p>
				</div>
			</div>
			<div class="clear"></div>
			<hr class="divider">
		</div>
	</div>
	<h2>Thành tựu nổi bật</h2>
	<div class="input-group col-md-12 cus-input-group-theme-music">
		<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-music">Link youtube.com về sự kiện</span>
		<span class="form-control cus-form-control-theme-study" >https://www.youtube.com/watch?v=AQm9GDjVdgs&feature=youtu.be</span>
	</div>
	<h2>Thư viện ảnh</h2>
	<div class="upload-file-music child-center">
		<a href="" class="btn btn-default" title="Thêm ảnh">
			<input class="hidden-file logo-file-organization input-image" type="file" />
			Thêm ảnh
			<i class="fa fa-plus-circle" aria-hidden="true"></i>
		</a>
	</div>
	<div class="library-image">
		<figure class="col-md-3">
			<img alt="Library image upload" src="/ticketevent-web/resources/images/1.jpg">
		</figure>
		<figure class="col-md-3">
			<img alt="Library image upload" src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1">
		</figure>
		<figure class="col-md-3">
			<img alt="Library image upload" src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1">
		</figure>
		<figure class="col-md-3">
			<img alt="Library image upload" src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1">
		</figure>
		<figure class="col-md-3">
			<img alt="Library image upload" src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1">
		</figure>
		<figure class="col-md-3">
			<img alt="Library image upload" src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1">
		</figure>
		<figure class="col-md-3">
			<img alt="Library image upload" src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1">
		</figure>
	</div>
	<div class="contain-btn-create-event-step">
		<button class="btn btn-default btn-ticket btn-create-event-step">Lưu và tiếp tục <i class="fa fa-arrow-circle-right" aria-hidden="true"></i></button>
	</div>
</div>

<script src="<%=request.getContextPath()%>/resources/js/event-theme/music/create_theme_music.js"></script>