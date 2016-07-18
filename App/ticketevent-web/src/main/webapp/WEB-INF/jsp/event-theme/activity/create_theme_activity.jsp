<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/activity/create_theme_activity.css">

<h1>Tạo sự kiện chủ đề hoạt động với giao diện có sẵn của ticketevent.vn</h1>

<div>
	<h2>Ảnh cho sự kiện</h2>
	<div class="output-image">
		<img class="col-md-6" alt="Image upload" src="" />
		<div class="col-md-6 info-image">
			<span class="col-md-12">
				<label>Trạng thái:</label> <span class="status">Bạn hãy chọn ảnh ...</span>
			</span>
			<a href="" title="Ảnh này sẽ hiển thị ở trang chủ, tìm kiếm sự kiện." class="col-md-12 btn btn-default">
				<input class="hidden-file input-image" type="file" />
				Tải lên ảnh thu nhỏ của sự kiện
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
			<a href="" title="Ảnh này sẽ làm ảnh nền của sự kiện." class="col-md-12 btn btn-default">
				<input class="hidden-file input-image" type="file" />
				Tải lên ảnh nền cho sự kiện
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
			<a href="" title="Ảnh này sẽ hiển thị phía trước (Nên tải lên ảnh có nền trong suốt)" class="col-md-12 btn btn-default">
				<input class="hidden-file input-image" type="file" />
				Tải lên ảnh logo của sự kiện
				<i class="fa fa-upload" aria-hidden="true"></i>
			</a>
		</div>
	</div>
	<h2>Khẩu hiệu của sự kiện</h2>
	<div class="event-info">
		<span class="label-event-info cus-input-group-addon-create-event">Khẩu hiệu của sự kiện</span>
		<textarea rows="5" class="textarea-event-info"></textarea>
	</div>
	<h2>Thư viện ảnh</h2>
	<div class="upload-file-activity child-center">
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

<script src="<%=request.getContextPath()%>/resources/js/event-theme/activity/create_theme_activity.js"></script>