<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/study/create_theme_study.css">

<h1>Tạo sự kiện chủ đề học tập với giao diện có sẵn của ticketevent.vn</h1>

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
	<h2>Diễn giả</h2>
	<div class="add-teacher child-center">
		<a href="" class="btn btn-default btn-add-teacher" title="Thêm diễn giả">
			Thêm diễn giả
			<i class="fa fa-plus-circle" aria-hidden="true"></i>
		</a>
	</div>
	<div class="contain-person-highlight">
		<div class="col-md-12">
			<figure class="col-md-3">
				<img alt="Library image upload" src="/ticketevent-web/resources/images/1.jpg">
			</figure>
			<div class="col-md-9">
				<div class="input-group col-md-12 cus-input-group-theme-study">
					<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-study">Tên diễn giả</span>
					<span class="form-control cus-form-control-theme-study" >Huỳnh Văn A</span>
				</div>
				<div class="input-group col-md-12 cus-input-group-theme-study">
					<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-study">Lĩnh vực</span>
					<span class="form-control cus-form-control-theme-study" >Java</span>
				</div>
				<div class="cus-event-info-theme-study">
					<span class="label-event-info cus-input-group-addon-create-event">Giới thiệu hoặc mô tả đôi nét về diễn giả</span>
					<p class="textarea-event-info" >Giới thiệu</p>
				</div>
			</div>
			<div class="clear"></div>
			<hr class="divider">
		</div>
	</div>
	<h2>Nội dung khóa học</h2>
	<div class="add-course child-center">
		<a href="" class="btn btn-default btn-add-course" title="Thêm khóa học">
			Thêm khóa học
			<i class="fa fa-plus-circle" aria-hidden="true"></i>
		</a>
	</div>
	<div class="contain-content">
		<div class="col-md-12">
			<div class="input-group col-md-12 cus-input-group-theme-study">
				<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-study">Tiêu đề</span>
				<span class="form-control cus-form-control-theme-study" >Nội dung 1</span>
			</div>
			<div class="cus-event-info-theme-study">
				<span class="label-event-info cus-input-group-addon-create-event">Nội dung</span>
				<p class="textarea-event-info" >Nội dung của nội dung 1</p>
			</div>
			<div class="clear"></div>
			<hr class="divider">
		</div>
	</div>
	<div class="contain-btn-create-event-step">
		<button class="btn btn-default btn-ticket btn-create-event-step">Lưu và tiếp tục <i class="fa fa-arrow-circle-right" aria-hidden="true"></i></button>
	</div>
</div>

<script src="<%=request.getContextPath()%>/resources/js/event-theme/study/create_theme_study.js"></script>