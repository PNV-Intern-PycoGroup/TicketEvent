<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/activity/create_theme_activity.css">

<div class="container-activity-theme">
<input id="event-id" type="hidden" value='<c:out value="${event.id }"></c:out>'/>
<input id="activity-id" type="hidden" value='<c:out value="${activityLayout.id }"></c:out>' />
<h1 style="margin-top: 30px;">Chủ đề hoạt động với giao diện có sẵn của ticketevent.vn</h1>

<div>
	<h2>Ảnh cho sự kiện</h2>
	<div class="output-image">
		<div class="col-md-10 info-image">
			<span class="col-md-12">
				<label>Trạng thái:</label> <span class="status">
				<c:choose>
					<c:when test="${activityLayout.backgroundImage ne null }">
						Đã load ảnh
					</c:when>
					<c:otherwise>
						Bạn hãy chọn ảnh ...
					</c:otherwise>
				</c:choose>
				</span>
			</span>
			<a href="" title="Ảnh này sẽ làm ảnh nền của sự kiện." class="col-md-12 btn btn-default">
				<input id="add-activity-background-image" class="hidden-file input-image" type="file" />
				Tải lên ảnh nền cho sự kiện
				<i class="fa fa-upload" aria-hidden="true"></i>
			</a>
		</div>
		<c:choose>
			<c:when test="${activityLayout.backgroundImage ne null }">
				<img id="output-background-image" class="col-md-2" alt="Image upload" src="<c:url value="/resources/images/${activityLayout.backgroundImage }" />" />
			</c:when>
			<c:otherwise>
				<img id="output-background-image" class="col-md-2" alt="Image upload" src="" />
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="output-image">
		<div class="col-md-10 info-image">
			<span class="col-md-12">
				<label>Trạng thái:</label> <span class="status">
				<c:choose>
					<c:when test="${activityLayout.eventLogo ne null }">
						Đã load ảnh
					</c:when>
					<c:otherwise>
						Bạn hãy chọn ảnh ...
					</c:otherwise>
				</c:choose>
				</span>
			</span>
			<a href="" title="Ảnh này sẽ hiển thị phía trước (Nên tải lên ảnh có nền trong suốt)" class="col-md-12 btn btn-default">
				<input id="add-activity-logo-image" class="hidden-file input-image" type="file" />
				Tải lên ảnh logo của sự kiện
				<i class="fa fa-upload" aria-hidden="true"></i>
			</a>
		</div>
		<c:choose>
			<c:when test="${activityLayout.eventLogo ne null }">
				<img id="output-logo" class="col-md-2" alt="Image upload" src="<c:url value="/resources/images/${activityLayout.eventLogo }" />" />
			</c:when>
			<c:otherwise>
				<img id="output-logo" class="col-md-2" alt="Image upload" src="" />
			</c:otherwise>
		</c:choose>
	</div>
	<h2>Khẩu hiệu của sự kiện</h2>
	<div class="event-info">
		<span class="label-event-info cus-input-group-addon-create-event">Khẩu hiệu của sự kiện</span>
		<textarea id="activity-sologan" rows="5" class="textarea-event-info"><c:out value="${activityLayout.sologan }"></c:out></textarea>
	</div>
	<h2>Thư viện ảnh</h2>
	<div class="upload-file-activity child-center">
		<a href="" class="btn btn-default" title="Thêm ảnh">
			<input id="add-activity-image-lib" class="hidden-file logo-file-organization input-image" type="file" />
			Thêm ảnh
			<i class="fa fa-plus-circle" aria-hidden="true"></i>
		</a>
	</div>
	<div class="library-image" id="container-image-lib">
		<c:forEach items="${activityLayout.listActivityLayoutImageLibrary }" var="image">
			<figure class="col-md-3">
				<img alt="Library image upload" src="<c:url value="/resources/images/${image.image }" />">
			</figure>
		</c:forEach>
	</div>
	<div class="contain-btn-create-event-step">
		<button id="btn-save-activity" class="btn btn-default btn-ticket btn-create-event-step">Lưu và tiếp tục <i class="fa fa-arrow-circle-right" aria-hidden="true"></i></button>
	</div>
</div>
</div>

<script src="<%=request.getContextPath()%>/resources/js/event-theme/activity/create_theme_activity.js"></script>