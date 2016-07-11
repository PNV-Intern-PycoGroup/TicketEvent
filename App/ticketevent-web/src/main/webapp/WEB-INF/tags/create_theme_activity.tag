<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@tag pageEncoding="UTF-8"%>

<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
<link rel="stylesheet" href="/ticketevent-web/resources/css/header_style.css">
<link rel="stylesheet" href="/ticketevent-web/resources/css/footer.css">
<link rel="stylesheet" href="/ticketevent-web/resources/css/create_theme_activity.css">
<link rel="stylesheet" href="/ticketevent-web/resources/css/cropper.min.css">
<link rel="stylesheet" href="/ticketevent-web/resources/css/create_theme_free_style.css">
<article>
	<header>
		<nav class="navbar navbar-default navbar-fixed-top">
			<ul class="nav nav-pills" role="tablist">
				<li role="presentation" class="active"><a class="a-header" href="#ticket-info" aria-controls="ticket-info" role="tab" data-toggle="tab">Thông tin sự kiện</a></li>
				<li role="presentation"><a class="a-header" href="#ticket-layout" aria-controls="ticket-layout" role="tab" data-toggle="tab">Bố cục trang web</a></li>
				<li role="presentation"><a class="a-header" href="#ticket-setting" aria-controls="ticket-setting" role="tab" data-toggle="tab">Cài đặt</a></li>
			</ul>
			<div>
				<div class="dropdown navbar-right language"><a href="#" class="dropdown-toggle a-header"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><span id="lang"><spring:message code="label.Language"/></span><span class="caret"> </span></a>
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
				</div>
			</div>
		</nav>
		<div class="clear"></div>
	</header>
	<section class="banner tab-content content">
		<div role="tabpanel" class="tab-pane fade in active" id="ticket-info">
			<form action="" method="post">
				<h2>Về sự kiện</h2>
				<div class="input-group col-md-6 cus-input-group-col-md">
					<span class="input-group-addon cus-input-group-addon-create-event">Tên sự kiện</span> <input
						class="form-control" type="text" placeholder="Nhập tên sự kiện" />
				</div>
				<div class="input-group col-md-6 cus-input-group-col-md">
					<span class="input-group-addon cus-input-group-addon-create-event">Loại sự kiện</span> 
					<select class="selectpicker form-control type-event" multiple title="Chọn thể loại sự kiện">
						<optgroup label="Thể loại" data-max-options="1">
							<option>Âm nhạc</option>
							<option>Khóa Học</option>
							<option>Hoạt động</option>
						</optgroup>
						<optgroup id="place-event" label="Nơi tổ chức" data-max-options="1" disabled>
							<option>Ngoài trời</option>
							<option>Trong nhà</option>
							<option>Sân vận động</option>
							<option>Bãi biển</option>
							<option>Đường phố</option>
							<option>Núi</option>
						</optgroup>
					</select>
				</div>
				<div class="input-group col-md-12 cus-input-group-col-md">
					<span class="input-group-addon cus-input-group-addon-create-event">Nơi tổ chức</span>
					<input class="form-control" type="text" placeholder="Nhập địa chỉ" />
					<select class="selectpicker input-group-addon cus-input-group-addon province-select" title="Chọn tỉnh/thành phố">
						<option>Hà Nội</option>
						<option>Hải Phòng</option>
						<option>Đà Nẵng</option>
						<option>Quảng Nam</option>
						<option>Huế</option>
						<option>Tp Hồ Chí Minh</option>
						<option>Cần Thơ</option>
					</select>
				</div>
				<div class="event-info">
					<span class="label-event-info cus-input-group-addon-create-event">Giới thiệu hoặc mô tả đôi nét về sự kiện</span>
					<textarea rows="10" class="textarea-event-info"></textarea>
				</div>
				
				<h2>Nhà tổ chức</h2>
				<div class="upload-file-bg">
					<a href=""><input class="hidden-file logo-file-organization" type="file"></a>
				</div>
				<div class="input-group col-md-12 cus-input-group-col-md">
					<span class="input-group-addon cus-input-group-addon-create-event">Tên nhà tổ chức</span>
					<input class="form-control" type="text" placeholder="Nhập tên nhà tổ chức" />
				</div>
				<div class="event-info">
					<span class="label-event-info cus-input-group-addon-create-event">Thông tin nhà tổ chức</span>
					<textarea rows="10" class="textarea-event-info"></textarea>
				</div>
				
				<h2>Thông tin liên lạc</h2>
				<div class="input-group col-md-6 cus-input-group-col-md">
					<span class="input-group-addon"><i class="fa fa-phone cus-input-group-addon-create-event" aria-hidden="true"></i></span>
					<input class="form-control" type="text" placeholder="Eg: (+84) xxx-xxx-xxx(x)" />
				</div>
				<div class="input-group col-md-6 cus-input-group-col-md">
					<span class="input-group-addon"><i class="fa fa-envelope-o cus-input-group-addon-create-event" aria-hidden="true"></i></span>
					<input class="form-control" type="text" placeholder="Eg: xxx@xxx.xxx" />
				</div>
			</form>
		</div>
		<div role="tabpanel" class="tab-pane fade in" id="ticket-layout">
		<c:choose>
			<c:when test="${layout == null}">
				<div class="input-group col-md-12 cus-input-group-col-md output-layout">
					<span class="input-group-addon cus-input-group-addon-create-event">Giao diện sự kiện của bạn</span>
					<select class="selectpicker form-control province-select select-layout" title="Chọn giao diện">
						<option value="free">Tự tạo giao diện</option>
						<option value="music">Giao diện có sẵn</option>
					</select>
				</div>
				<button class="choose-layout">ok</button>
			</c:when>
		</c:choose>
		</div>
		<div role="tabpanel" class="tab-pane fade in" id="ticket-setting">
			<h2>Đường đẫn đến sự kiện</h2>
			<div class="input-group col-md-12 cus-input-group-col-md">
				<span class="input-group-addon cus-input-group-addon-create-event">https://ticketevent.vn/event/</span>
				<input class="form-control" type="text" placeholder="Nhập đường dẫn" />
			</div>
			<h2>Quyền riêng tư</h2>
			<div class="input-group col-md-6 cus-input-group-col-md contain-radio">
				<span class="input-group-addon cus-input-group-addon-create-event"><input type="radio" name="isPrivate"/>  <i class="fa fa-globe" aria-hidden="true"></i></span>
				<label class="form-control">Công khai cho mọi người</label>
			</div>
			<div class="input-group col-md-6 cus-input-group-col-md contain-radio">
				<span class="input-group-addon cus-input-group-addon-create-event"><input type="radio" name="isPrivate"/>  <i class="fa fa-users" aria-hidden="true"></i></span>
				<label class="form-control">Chỉ ai biết đường dẫn</label>
			</div>
			
			<h2>Tin nhắn email xác nhận người tham gia</h2>
			<div>
				<form method="post">
					<textarea id="text-editor"></textarea>
				</form>
			</div>
		</div>
	</section>
</article>
<!-- Script -->
<script src='https://cdn.tinymce.com/4/tinymce.min.js'></script>
 
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
<!-- <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script> -->
<script src="/ticketevent-web/resources/js/create_theme_activity.js"></script>
<script src="/ticketevent-web/resources/js/cropper.min.js"></script>
