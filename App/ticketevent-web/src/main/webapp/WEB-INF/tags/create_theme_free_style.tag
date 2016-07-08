<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag pageEncoding="UTF-8"%>

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
	
	<!-- Modal -->
	<div class="modal fade" id="modal" role="dialog" aria-labelledby="modalLabel" tabindex="-1">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close crop-none" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="modalLabel">Cropper</h4>
	      </div>
	      <div class="modal-body">
	        <div class="img-container-1000x500">
	            <img id="image" src=""/>
	        </div>
	      </div>
	      <div class="modal-footer">
	        <button id="crop" type="button" class="btn btn-default" data-dismiss="modal">Crop</button>
	        <button type="button" class="btn btn-default crop-none" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>

	<form method="post">
		<textarea id="create-event-free-style"></textarea>
	</form>
	
	<div id="myrender">
		<button onclick="get_editor_content()"></button>
	</div>
</div>