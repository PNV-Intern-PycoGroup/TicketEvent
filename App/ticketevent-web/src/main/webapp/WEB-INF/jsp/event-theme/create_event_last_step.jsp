<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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