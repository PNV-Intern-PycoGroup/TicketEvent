<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<input id="event-id" type="hidden" value='<c:out value="${event.id }"></c:out>'/>
<div>
	<span class="label label-danger create-theme-make-error"></span>
	<div class="input-group col-md-12 cus-input-group cus-input-group-padding">
		<span class="input-group-addon cus-input-group-addon-create-event"><spring:message code="step2.label.layout"/></span>
		<select id="select-layout" class="selectpicker form-control select-layout" title="<spring:message code="step2.label.layoutSelect"/>">
			<c:forEach items="${listLayout }" var="layout">
				<option value="<c:out value="${layout.id }"></c:out>"><c:out value="${layout.name }"></c:out></option>
			</c:forEach>
		</select>
	</div>
</div>
<div class="contain-btn-create-event-step">
	<button class="btn btn-default btn-ticket btn-create-event-step choose-layout"><spring:message code="step1.title.event.buttonSave"/> <i class="fa fa-arrow-circle-right" aria-hidden="true"></i></button>
</div>
<div>
	<h2>Giao diện demo của các theme có sẵn</h2>
	<img class="col-md-6" alt="theme-activity" src="<c:url value="/resources/images/music_demo.png" />" title="theme-activity">
	<img class="col-md-6" alt="theme-music" src="<c:url value="/resources/images/activity_demo.png" />" title="theme-music">
</div>