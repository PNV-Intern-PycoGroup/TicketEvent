<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/music/create_theme_music.css">

<div class="conteiner-music-theme">
<input id="event-id" type="hidden" value='<c:out value="${event.id }"></c:out>'/>
<input id="music-id" type="hidden" value='<c:out value="${musicLayout.id }"></c:out>' />
<h1 style="margin-top: 30px;">Chủ đề âm nhạc với giao diện có sẵn của ticketevent.vn</h1>

<div class="row">
	<p style="font-size: 20pt;" class="col-sm-3">Ảnh cho sự kiện</p>
	<div class="output-image col-sm-12">
		<div class="col-md-10 info-image">
			<span class="col-md-12">
				<label>Trạng thái:</label> <span class="status">
				<c:choose>
					<c:when test="${musicLayout.bannerImage ne null }">
						Đã load ảnh
					</c:when>
					<c:otherwise>
						Bạn hãy chọn ảnh ...
					</c:otherwise>
				</c:choose>
				</span>
			</span>
			<a href="" title="Tải lên banner." class="col-md-12 btn btn-default">
				<input id="add-music-banner-image" class="hidden-file input-image" type="file" />
				Tải lên banner của sự kiện
				<i class="fa fa-upload" aria-hidden="true"></i>
			</a>
		</div>
		<c:choose>
			<c:when test="${musicLayout.bannerImage ne null }">
				<img id="output-banner-image" class="col-md-2" alt="Image upload" src="<c:url value="/resources/images/${musicLayout.bannerImage }" />" />
			</c:when>
			<c:otherwise>
				<img id="output-banner-image" class="col-md-2" alt="Image upload" src="" />
			</c:otherwise>
		</c:choose>
	</div>
	<div class="output-image col-sm-12">
		<div class="col-md-10 info-image">
			<span class="col-md-12">
				<label>Trạng thái:</label> <span class="status">
				<c:choose>
					<c:when test="${musicLayout.placeImage ne null }">
						Đã load ảnh
					</c:when>
					<c:otherwise>
						Bạn hãy chọn ảnh ...
					</c:otherwise>
				</c:choose>
				</span>
			</span>
			<a href="" title="Ảnh này sẽ miêu tả địa điểm diển ra sự kiện." class="col-md-12 btn btn-default">
				<input id="add-music-place-image" class="hidden-file input-image" type="file" />
				Tải lên ảnh địa điểm của sự kiện
				<i class="fa fa-upload" aria-hidden="true"></i>
			</a>
		</div>
		<c:choose>
			<c:when test="${musicLayout.placeImage ne null }">
				<img id="output-place-image" class="col-md-2" alt="Image upload" src="<c:url value="/resources/images/${musicLayout.placeImage }" />" />
			</c:when>
			<c:otherwise>
				<img id="output-place-image" class="col-md-2" alt="Image upload" src="" />
			</c:otherwise>
		</c:choose>
	</div>
	<p style="font-size: 20pt;" class="col-sm-6">Người nổi tiếng <span id="add-famous-person" class="btn btn-default btn-add-famous-person">Thêm người nổi tiếng <i class="fa fa-plus-circle" aria-hidden="true"></i></span></p>
	<div class="clear"></div>
	<div id="contain-famous-person" class="contain-person-highlight col-sm-12">
		<c:forEach items="${musicLayout.listMusicLayouFamousPerson }" var="famousPerson">
			<div class="col-md-12">
				<figure class="col-md-3">
					<c:choose>
						<c:when test="${famousPerson.image ne null }">
							<img alt="famous person" src="<c:url value="/resources/images/${famousPerson.image }" />">
						</c:when>
						<c:otherwise>
							<img alt="famous person" src="">
						</c:otherwise>
					</c:choose>
				</figure>
				<div class="col-md-9">
					<div class="input-group col-md-12 cus-input-group-theme-music">
						<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-music">Nghệ danh</span>
						<span class="form-control cus-form-control-theme-study" ><c:out value="${famousPerson.name }"></c:out></span>
					</div>
					<div class="input-group col-md-12 cus-input-group-theme-music">
						<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-music">Ngày sinh</span>
						<span class="form-control cus-form-control-theme-music" ><c:out value="${famousPerson.getDateOfBirthString() }"></c:out></span>
					</div>
					<div class="cus-event-info-theme-music">
						<span class="label-event-info cus-input-group-addon-create-event">Giới thiệu hoặc mô tả đôi nét về diễn giả</span>
						<p class="textarea-event-info" ><c:out value="${famousPerson.introduction }"></c:out></p>
					</div>
				</div>
				<div class="clear"></div>
				<hr class="divider">
			</div>
		</c:forEach>
	</div>
	
	
	<p style="font-size: 20pt;" class="col-sm-3">Thành tựu nổi bật</p>
	<div class="input-group col-md-12 cus-input-group-theme-music">
		<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-music">Link youtube.com về sự kiện</span>
		<input id="music-link-highlight" class="form-control cus-form-control-theme-study" value="<c:out value="${musicLayout.linkHighlight }"></c:out>" />
	</div>
	<h2>Thư viện ảnh</h2>
	<div class="upload-file-music child-center">
		<a href="" class="btn btn-default" title="Thêm ảnh">
			<input id="add-music-image-lib" class="hidden-file logo-file-organization input-image" type="file" />
			Thêm ảnh
			<i class="fa fa-plus-circle" aria-hidden="true"></i>
		</a>
	</div>
	<div class="library-image" id="container-image-lib">
		<c:forEach items="${musicLayout.listMusicLayoutImageLibrary }" var="image">
			<figure class="col-md-3">
				<img alt="Library image upload" src="<c:url value="/resources/images/${image.image }" />">
			</figure>
		</c:forEach>
	</div>
	<div class="contain-btn-create-event-step">
		<button id="btn-save-music" class="btn btn-default btn-ticket btn-create-event-step">Lưu và tiếp tục <i class="fa fa-arrow-circle-right" aria-hidden="true"></i></button>
	</div>
</div>
</div>
<script src="<%=request.getContextPath()%>/resources/js/event-theme/music/create_theme_music.js"></script>