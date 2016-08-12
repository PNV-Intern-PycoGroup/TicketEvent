<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="content-last-step">
<p style="margin-top: 50px; font-size: 20pt">Thiết lập sự kiện</p>
<div class="row">
	<div class="col-md-6">
		<label class="col-md-12">Đường dẫn sự kiện</label>
		<div class="input-group col-md-12 cus-input-group cus-input-group-padding">
			<span class="input-group-addon cus-input-group-addon-create-event">https://ticketevent.vn/event/</span>
			<input class="form-control" id="path-last-step" type="text" value='<c:out value="${event.path }"></c:out>' placeholder="Nhập đường dẫn" />
			<button id="copy-path" class="input-group-addon cus-input-group-addon-create-event">Copy</button>
		</div>
	</div>
	<div class="col-md-6">
		<label class="col-md-12">Quyền riêng tư</label>
		<div class="col-md-6">
			<div class="input-group cus-input-group contain-radio cus-input-group-vertical-padding">
				<span class="input-group-addon cus-input-group-addon-create-event"><input type="radio" value="1" name="isPrivate" <c:if test="${event.isPublic != 0}">checked</c:if> />  <i class="fa fa-globe" aria-hidden="true"></i></span>
				<label class="form-control">Công khai</label>
			</div>
		</div>
		<div class="col-md-6">
			<div class="input-group cus-input-group contain-radio cus-input-group-vertical-padding">
				<span class="input-group-addon cus-input-group-addon-create-event"><input type="radio" value="0" name="isPrivate" <c:if test="${event.isPublic == 0}">checked</c:if> />  <i class="fa fa-users" aria-hidden="true"></i></span>
				<label class="form-control">Hạn chế</label>
			</div>
		</div>
	</div>
</div>

<div class="row" style="margin-top: 30px;">
	<div class="col-md-4">
		<p style="font-size: 20pt">Vé sự kiện <button class="btn btn-default" id="add-ticket"><i class="fa fa-plus-circle" aria-hidden="true"></i> Thêm vé</button></p>
	</div>
</div>


<div class="col-md-12 contain-ticket">
	<c:forEach items="${event.listTicket }" var="ticket">
		<div class="ticket">
			<div class="col-md-6">
				<div class="input-group cus-input-group contain-radio cus-input-group-vertical-padding">
					<span class="input-group-addon">Tên vé</span>
					<span class="form-control" ><c:out value="${ticket.name }"></c:out></span>
				</div>
			</div>
			<div class="col-md-6">
				<div class="input-group cus-input-group contain-radio cus-input-group-vertical-padding">
					<span class="input-group-addon cus-input-group-addon-create-event">Giá vé (VND)</span>
					<label class="form-control"><c:out value="${ticket.price }"></c:out></label>
				</div>
			</div>
			<div class="col-md-12">
				<span class="label-event-info">Mô tả về vé</span>
				<p class="textarea-event-info" ><c:out value="${ticket.description }"></c:out></p>
			</div>
			<div class="clear"></div>
			<hr class="divider">
		</div>
	</c:forEach>
</div>

<div class="cus-input-group-padding">
	<h2 style="margin-top: 250px;">Nội dung gửi tới người tham gia</h2>
	<textarea id="send-email"><c:out value="${event.confirmEmail }"></c:out></textarea>
</div>
<div class="contain-btn-create-event-step">
	<button id="create-event-finish" class="btn btn-default btn-ticket btn-create-event-step">Tạo sự kiện <i class="fa fa-plus-circle" aria-hidden="true"></i></button>
</div>
</div>