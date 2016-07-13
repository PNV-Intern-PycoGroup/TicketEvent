<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/free/create_theme_free.css">

<h1>Tạo sự kiện theo cách của bạn</h1>
<div>
	<div class="upload-contain">
		<div class="output-image">
			<img class="col-md-6" alt="Image upload" src="" />
			<div class="col-md-6 info-link-image">
				<span class="col-md-12">
					<label>Link:</label> <span class="url">Đang tải ảnh lên ...</span>
				</span>
				<a href="" title="Nhấn vào đây để copy đường dẫn." class="col-md-12 btn btn-default btn-copy-url disable-href">
					<i class="fa fa-files-o" aria-hidden="true"></i> Copy đường dẫn
				</a>
			</div>
		</div>
	</div>
	<div id="upload" class="upload-file-free-style">
		<a href="" class="btn btn-default" title="Tải ảnh của bạn tại đây rồi copy đường dẫn">
			<input id="input-image" class="hidden-file logo-file-organization input-image" type="file" />
			Tải file ảnh lên
			<i class="fa fa-upload" aria-hidden="true"></i>
		</a>
	</div>
	
	<p>Để chèn được ảnh từ máy tính của bạn vào khung thiết kế giao diện. Hãy tải ảnh của bạn lên (giới hạn 2Mb). Trang web sẽ cung cấp cho bạn một đường dẫn để copy.</p>

	<form method="post">
		<textarea id="create-event-free-style"></textarea>
	</form>
</div>

<script src="<%=request.getContextPath()%>/resources/js/event-theme/free/create_theme_free.js"></script>