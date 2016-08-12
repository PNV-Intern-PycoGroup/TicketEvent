<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/free/create_theme_free.css">

<input id="event-id" type="hidden" value='<c:out value="${event.id }"></c:out>'/>
<input id="free-id" type="hidden" value='<c:out value="${freeLayoutModel.id }"></c:out>' />
<h1>Tạo sự kiện theo cách của bạn</h1>
<div>
	<div class="upload-contain">
		<c:forEach items="${freeLayoutModel.listFreeLayoutImageLibrary }" var="imageUpload">
			<div class="output-image cus-output-image">
				<button type="button" class="close cus-close">&times;</button>
				<img class="col-md-6" alt="Image upload" src="<%=request.getContextPath()%>/resources/images/<c:out value="${imageUpload.image }"></c:out>" />
				<div class="col-md-6 info-image">
					<span class="col-md-12">
						<label class="message">Ảnh đã được tải.</label> <span class="url invisible">http://localhost:8080<%=request.getContextPath()%>/resources/images/<c:out value="${imageUpload.image }"></c:out></span>
					</span>
					<a href="" title="Nhấn vào đây để copy đường dẫn." class="col-md-12 btn btn-default btn-copy-url disable-href">
						<i class="fa fa-files-o" aria-hidden="true"></i> Copy đường dẫn
					</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div id="upload" class="upload-file-free-style">
		<a href="" class="btn btn-default" title="Tải ảnh của bạn tại đây rồi copy đường dẫn">
			<input id="input-image" class="hidden-file logo-file-organization input-image" type="file" />
			Tải file ảnh lên
			<i class="fa fa-upload" aria-hidden="true"></i>
		</a>
	</div>
	
	<p>Để chèn được ảnh từ máy tính của bạn vào khung thiết kế giao diện. Hãy tải ảnh của bạn lên (giới hạn 2Mb). Trang web sẽ cung cấp cho bạn một đường dẫn để copy.</p>
	
	<div class="cus-input-group-padding">
		<textarea id="create-event-free-style"><c:out value="${freeLayoutModel.content }"></c:out></textarea>
	</div>
	<div class="contain-btn-create-event-step">
		<button id="save-free-layout" class="btn btn-default btn-ticket btn-create-event-step">Lưu hoặc tiếp tục <i class="fa fa-arrow-circle-right" aria-hidden="true"></i></button>
	</div>
</div>

<script src="<%=request.getContextPath()%>/resources/js/event-theme/free/create_theme_free.js"></script>