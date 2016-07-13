<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div>
	<input type="hidden" value="<%=request.getContextPath()%>" id="context-path">
	<span class="label label-danger create-theme-make-error"></span>
	<div class="input-group col-md-12 cus-input-group-col-md">
		<span class="input-group-addon cus-input-group-addon-create-event">Giao diện sự kiện của bạn</span>
		<select class="selectpicker form-control select-layout" title="Chọn cách tạo giao diện">
			<option value="free">Tự tạo giao diện</option>
			<option value="music">Giao diện có sẵn</option>
		</select>
	</div>
</div>
<button class="btn btn-default choose-layout">Xác nhận</button>
<div>
	<h2>Giao diện demo của các theme có sẵn</h2>
	<img class="col-md-6" alt="theme-activity" src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1" title="theme-activity">
	<img class="col-md-6" alt="theme-music" src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1" title="theme-music">
</div>

<script src="<%=request.getContextPath()%>/resources/js/event-theme/create_event_step_two.js"></script>