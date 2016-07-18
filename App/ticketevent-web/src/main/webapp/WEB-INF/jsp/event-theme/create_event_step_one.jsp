<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<input id="is-exist-event-info" type="hidden" value='<c:out value="${event }"></c:out>'/>
<input id="event-id" type="hidden" value='<c:out value="${event.id }"></c:out>'/>
<input id="event-account" type="hidden" value='<c:out value="${event.account }"></c:out>'/>
<input id="event-event-layout" type="hidden" value='<c:out value="${event.eventLayout }"></c:out>'/>
<input id="event-create-date" type="hidden" value='<c:out value="${event.createDate }"></c:out>'/>
<input id="event-is-public" type="hidden" value='<c:out value="${event.isPublic }"></c:out>'/>
<input id="event-is-accept" type="hidden" value='<c:out value="${event.isAccept }"></c:out>'/>
<input id="event-list-ticket" type="hidden" value='<c:out value="${event.listTicket }"></c:out>'/>
<input id="event-list-comment" type="hidden" value='<c:out value="${event.listComment }"></c:out>'/>
<h2>Về sự kiện <span class="require">*</span></h2>
<div  class="col-md-6">
	<div class="input-group cus-input-group cus-input-group-vertical-padding">
		<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-inline">Tên sự kiện</span>
		<input id="event-name" class="form-control" type="text" placeholder="Nhập tên sự kiện" value='<c:out value="${event.name }"></c:out>' />
	</div>
</div>
<div  class="col-md-6">
	<div class="input-group cus-input-group cus-input-group-vertical-padding">
		<span id="show-tooltip-event-type" class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-inline">Loại sự kiện</span> 
		<select id="event-type" class="selectpicker form-control type-event" title="Chọn thể loại sự kiện" >
			<c:forEach items="${listEventType }" var="eventType">
				<option value='<c:out value="${eventType.id }"></c:out>' <c:if test="${event.eventType.id == eventType.id }">selected</c:if> ><c:out value="${eventType.name }"></c:out></option>
			</c:forEach>
		</select>
	</div>
</div>
<div class="input-group cus-input-group cus-input-group-padding">
	<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-inline">Nơi tổ chức</span>
	<input id="event-address" class="form-control" type="text" placeholder="Nhập địa chỉ" value='<c:out value="${event.getAddress() }"></c:out>' />
	<select id="event-city" class="selectpicker input-group-addon cus-input-group-addon province-select" title="Chọn tỉnh/thành phố" data-live-search="true" data-size="10">
		<c:forEach items="${listCityInVietNam }" var="city">
			<option <c:if test="${event.getCity() == city }">selected</c:if> ><c:out value="${city }"></c:out></option>
		</c:forEach>
	</select>
</div>
<h3>Ngày tổ chức</h3>
<div class="input-group col-md-12 cus-input-group cus-input-group-padding">
	<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-inline">Bắt đầu ngày</span>
	<input id="event-start-date" class="form-control date-select" type="text" placeholder="Từ ngày" value='<c:out value="${event.getDateStartDate() }"></c:out>' />
	<select id="event-start-hours" class="selectpicker input-group-addon cus-input-group-addon province-select hours" title="Giờ" data-live-search="true" data-size="10">
		<c:forEach items="${listHours }" var="hours">
			<option <c:if test="${event.getHoursStartDate() == hours }">selected</c:if> ><c:out value="${hours }"></c:out></option>
		</c:forEach>
	</select>
</div>
<div class="input-group col-md-12 cus-input-group cus-input-group-padding">
	<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-inline">Kết thúc ngày</span>
	<input id="event-end-date" class="form-control date-select" type="text" placeholder="Đến ngày" value="<c:out value="${event.getDateEndDate() }"></c:out>" />
	<select id="event-end-hours" class="selectpicker input-group-addon cus-input-group-addon province-select hours" title="Giờ" data-live-search="true" data-size="10">
		<c:forEach items="${listHours }" var="hours">
			<option <c:if test="${event.getHoursEndDate() == hours }">selected</c:if> ><c:out value="${hours }"></c:out></option>
		</c:forEach>
	</select>
</div>
<div class="event-info">
	<span class="label-event-info cus-input-group-addon-create-event">Giới thiệu hoặc mô tả đôi nét về sự kiện</span>
	<textarea id="event-info" rows="10" class="textarea-event-info"><c:out value="${event.introduction }"></c:out></textarea>
</div>

<h2>Nhà tổ chức <span class="require">*</span></h2>
<div class="upload-file-bg">
	<a href=""><input class="hidden-file logo-file-organization" type="file"></a>
</div>
<div class="input-group col-md-12 cus-input-group cus-input-group-padding">
	<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-inline">Tên nhà tổ chức</span>
	<input id="event-organize-name" class="form-control" type="text" placeholder="Nhập tên nhà tổ chức" value='<c:out value="${event.organizeName }"></c:out>'/>
</div>
<div class="event-info">
	<span class="label-event-info cus-input-group-addon-create-event">Thông tin nhà tổ chức</span>
	<textarea id="event-organize-info" rows="10" class="textarea-event-info"><c:out value="${event.organizeInfo }"></c:out></textarea>
</div>

<h2>Thông tin liên lạc <span class="require">*</span></h2>
<div class="col-md-6">
	<div class="input-group cus-input-group cus-input-group-vertical-padding">
		<span class="input-group-addon"><i class="fa fa-phone cus-input-group-addon-create-event cus-input-group-addon-inline" aria-hidden="true"></i></span>
		<input id="event-organize-phone-number" class="form-control" type="text" placeholder="Eg: (+84) xxx-xxx-xxx(x)" value="<c:out value="${event.phoneNumber }"></c:out>" />
	</div>
</div>
<div class="col-md-6">
	<div class="input-group cus-input-group cus-input-group-vertical-padding">
		<span class="input-group-addon"><i class="fa fa-envelope-o cus-input-group-addon-create-event cus-input-group-addon-inline" aria-hidden="true"></i></span>
		<input id="event-organize-email" class="form-control" type="text" placeholder="Eg: xxx@xxx.xxx" value="<c:out value="${event.email }"></c:out>" />
	</div>
</div>
<div class="clear"></div>
<div class="col-md-12">
	<span class="alert alert-info cus-input-group cus-input-group-padding" role="alert">
		Nếu bạn có việt bận. Hãy lưu nháp bản này bằng cách nhấn vào nút bên dưới.
		<i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
	</span>
</div>
<div class="contain-btn-create-event-step">
	<button id="btn-save-step-one" class="btn btn-default btn-ticket btn-create-event-step">Lưu hoặc tiếp tục <i class="fa fa-arrow-circle-right" aria-hidden="true"></i></button>
</div>

<script src="<%=request.getContextPath()%>/resources/js/event-theme/create_event_step_one.js"></script>