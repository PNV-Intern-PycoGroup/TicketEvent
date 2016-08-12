<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/study/create_theme_study.css">

<input id="event-id" type="hidden" value='<c:out value="${event.id }"></c:out>'/>
<input id="course-id" type="hidden" value='<c:out value="${courseLayout.id }"></c:out>' />
<h1 style="margin-top: 30px; margin-bottom: 30px;">Chủ đề học tập với giao diện có sẵn của ticketevent.vn</h1>

<div class="container-study-theme">
	<h2>Ảnh cho sự kiện</h2>
	<div class="output-image">
		<div class="col-md-10 info-image">
			<span class="col-md-12">
				<label>Trạng thái:</label> <span class="status">
				<c:choose>
					<c:when test="${courseLayout.bannerImage ne null }">
						Đã load ảnh
					</c:when>
					<c:otherwise>
						Bạn hãy chọn ảnh ...
					</c:otherwise>
				</c:choose>
				</span>
			</span>
			<a href="" title="Tải lên banner." class="col-md-12 btn btn-default">
				<input id="add-course-banner-image" class="hidden-file input-image" type="file" />
				Tải lên banner của sự kiện
				<i class="fa fa-upload" aria-hidden="true"></i>
			</a>
		</div>
		<c:choose>
			<c:when test="${courseLayout.bannerImage ne null }">
				<img id="output-banner-image" class="col-md-2" alt="Image upload" src="<c:url value="/resources/images/${courseLayout.bannerImage }" />" />
			</c:when>
			<c:otherwise>
				<img id="output-banner-image" class="col-md-2" alt="Image upload" src="" />
			</c:otherwise>
		</c:choose>
	</div>
	
	
	<div class="output-image">
		<div class="col-md-10 info-image">
			<span class="col-md-12">
				<label>Trạng thái:</label> <span class="status">
				<c:choose>
					<c:when test="${courseLayout.placeImage ne null }">
						Đã load ảnh
					</c:when>
					<c:otherwise>
						Bạn hãy chọn ảnh ...
					</c:otherwise>
				</c:choose>
				</span>
			</span>
			<a href="" title="Ảnh này sẽ miêu tả địa điểm diển ra sự kiện." class="col-md-12 btn btn-default">
				<input id="add-course-place-image" class="hidden-file input-image" type="file" />
				Tải lên ảnh địa điểm của sự kiện
				<i class="fa fa-upload" aria-hidden="true"></i>
			</a>
		</div>
		<c:choose>
			<c:when test="${courseLayout.placeImage ne null }">
				<img id="output-place-image" class="col-md-2" alt="Image upload" src="<c:url value="/resources/images/${courseLayout.placeImage }" />" />
			</c:when>
			<c:otherwise>
				<img id="output-place-image" class="col-md-2" alt="Image upload" src="" />
			</c:otherwise>
		</c:choose>
	</div>
	<h2>Diễn giả</h2>
	<div class="add-speaker child-center">
		<a id="add-speaker" href="" class="btn btn-default btn-add-speaker" title="Thêm diễn giả">
			Thêm diễn giả
			<i class="fa fa-plus-circle" aria-hidden="true"></i>
		</a>
	</div>
	<div id="contain-speaker" class="contain-person-highlight">
		<c:forEach items="${courseLayout.listCourseLayoutSpeaker }" var="speaker">
			<div class="col-md-12">
				<figure class="col-md-3">
					<c:choose>
						<c:when test="${speaker.image ne null }">
							<img alt="speaker image" src="<c:url value="/resources/images/${speaker.image }" />">
						</c:when>
						<c:otherwise>
							<img alt="speaker image" src="">
						</c:otherwise>
					</c:choose>
				</figure>
				<div class="col-md-9">
					<div class="input-group col-md-12 cus-input-group-theme-study">
						<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-study">Tên diễn giả</span>
						<span class="form-control cus-form-control-theme-study" ><c:out value="${speaker.name }"></c:out></span>
					</div>
					<div class="input-group col-md-12 cus-input-group-theme-study">
						<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-study">Lĩnh vực</span>
						<span class="form-control cus-form-control-theme-study" ><c:out value="${speaker.field }"></c:out></span>
					</div>
					<div class="cus-event-info-theme-study">
						<span class="label-event-info cus-input-group-addon-create-event">Giới thiệu hoặc mô tả đôi nét về diễn giả</span>
						<p class="textarea-event-info" ><c:out value="${speaker.history }"></c:out></p>
					</div>
				</div>
				<div class="clear"></div>
				<hr class="divider">
			</div>
		</c:forEach>
	</div>
	<h2>Nội dung khóa học</h2>
	<div class="add-course child-center">
		<a id="add-content" href="" class="btn btn-default btn-add-course" title="Thêm khóa học">
			Thêm khóa học
			<i class="fa fa-plus-circle" aria-hidden="true"></i>
		</a>
	</div>
	<div id="contain-content" class="contain-content">
		<div class="col-md-12">
			<c:forEach items="${courseLayout.listCourseLayoutContent }" var="content">
				<div class="input-group col-md-12 cus-input-group-theme-study">
					<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-study">Tiêu đề bài giảng</span>
					<span class="form-control cus-form-control-theme-study" ><c:out value="${content.title }"></c:out></span>
				</div>
				<div class="cus-event-info-theme-study">
					<span class="label-event-info cus-input-group-addon-create-event">Mô tả về nội dung bài giảng</span>
					<p class="textarea-event-info" ><c:out value="${content.content }"></c:out></p>
				</div>
				<div class="clear"></div>
				<hr class="divider">
			</c:forEach>
		</div>
	</div>
	<div class="contain-btn-create-event-step">
		<button id="save-course-layout" class="btn btn-default btn-ticket btn-create-event-step">Lưu và tiếp tục <i class="fa fa-arrow-circle-right" aria-hidden="true"></i></button>
	</div>
</div>

<script src="<%=request.getContextPath()%>/resources/js/event-theme/study/create_theme_study.js"></script>