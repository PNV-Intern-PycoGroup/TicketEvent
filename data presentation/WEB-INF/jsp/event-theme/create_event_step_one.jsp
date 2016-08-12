<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="backgroundEvent upload-center-image event-image-thumbnail" style="width:100%; height: 720px;">
	<input id="event-image-thumbnail-input" class="hidden-file" type="file" accept="image/*">
	<div class="ouput-image" id="thumbnail-output-image">
		<c:choose>
			<c:when test="${event.imageThumbnail ne null }">
				<img id="image-thumbnail-init" src='<c:url value="/resources/images/${event.imageThumbnail}" />' alt="event image thumbnail">
				<div class="center-upload ">UPLOAD</div>
			</c:when>
			<c:otherwise>
				<img id="image-thumbnail-init" src="http://anhdep.pro/wp-content/uploads/2015/05/anh-bia-co-ba-la-9.jpg" title="event image thumbnail">
				<div class="center-upload">
					<div><a class="bt-upload-cover" style="color: white">
						<div class="show-text">
							<div class="left"><span class="icon-camera"></span></div>
								<div class="left"><div style="position: relative; top: -2px"><spring:message code="step1.label.title.uploadBackground"/></div>
									<div style="font-size: 11px; line-height: 14px;"><spring:message code="step1.label.title.small.uploadBackground"/></div>
								</div>
						</div>
						</a>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div style="width: 80%; margin: 0px auto;">
<input id="event-id" type="hidden" value='<c:out value="${event.id }"></c:out>'/>
<div class="col-md-12">
	<span class="alert alert-info cus-input-group cus-input-group-padding cus-alert" role="alert">
		<spring:message code="step1.label.title.eventInfor"/> <span class="require">*</span>
	</span>
</div>

<div class="row">
	<div class="col-sm-6">
		<div  class="col-md-6">
	<div class="input-group cus-input-group cus-input-group-vertical-padding">
		<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-inline"><spring:message code="step1.title.eventInfro.name"/></span>
		<input id="event-name" class="form-control" type="text" placeholder="<spring:message code="step1.title.eventInfro.holder.name"/>" value='<c:out value="${event.name }"></c:out>' />
	</div>
</div>
<div  class="col-md-6">
	<div class="input-group cus-input-group cus-input-group-vertical-padding">
		<span id="show-tooltip-event-type" class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-inline"><spring:message code="step1.title.eventInfro.type"/></span> 
		<select id="event-type" class="selectpicker form-control type-event" title="<spring:message code="step1.title.eventInfro.holder.type"/>" >
			<c:forEach items="${listEventType }" var="eventType">
				<option value='<c:out value="${eventType.id }"></c:out>' <c:if test="${event.eventType.id == eventType.id }">selected</c:if> ><c:out value="${eventType.name }"></c:out></option>
			</c:forEach>
		</select>
	</div>
</div>
<div class="input-group cus-input-group cus-input-group-padding">
	<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-inline"><spring:message code="step1.title.eventInfro.palce"/></span>
	<input id="event-address" class="form-control" type="text" placeholder="<spring:message code="step1.title.eventInfro.holder.palce"/>" value='<c:out value="${event.getAddress() }"></c:out>' />
	<select id="event-city" class="selectpicker input-group-addon cus-input-group-addon province-select" title="<spring:message code="step1.title.eventInfro.palce.select"/>" data-live-search="true" data-size="10">
		<c:forEach items="${listCityInVietNam }" var="city">
			<option <c:if test="${event.getCity() == city }">selected</c:if> ><c:out value="${city }"></c:out></option>
		</c:forEach>
	</select>
</div>
<div class="clear"></div>
	</div>
	<div class="col-sm-6">
		<div class="input-group col-md-12 cus-input-group cus-input-group-padding">
	<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-inline"><spring:message code="step1.title.eventInfro.startDate"/></span>
	<input id="event-start-date" class="form-control" type="text" placeholder="<spring:message code="step1.title.eventInfro.holder.startDate"/>" value='<c:out value="${event.getDateStartDate() }"></c:out>' />
	<select id="event-start-hours" class="selectpicker input-group-addon cus-input-group-addon province-select hours" title="<spring:message code="step1.title.eventInfro.time"/>" data-live-search="true" data-size="10">
		<c:forEach items="${listHours }" var="hours">
			<option <c:if test="${event.getHoursStartDate() == hours }">selected</c:if> ><c:out value="${hours }"></c:out></option>
		</c:forEach>
	</select>
</div>
<div class="input-group col-md-12 cus-input-group cus-input-group-padding">
	<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-inline"><spring:message code="step1.title.eventInfro.endDate"/></span>
	<input id="event-end-date" class="form-control" type="text" placeholder="<spring:message code="step1.title.eventInfro.holder.endDate"/>" value="<c:out value="${event.getDateEndDate() }"></c:out>" />
	<select id="event-end-hours" class="selectpicker input-group-addon cus-input-group-addon province-select hours" title="<spring:message code="step1.title.eventInfro.time"/>" data-live-search="true" data-size="10">
		<c:forEach items="${listHours }" var="hours">
			<option <c:if test="${event.getHoursEndDate() == hours }">selected</c:if> ><c:out value="${hours }"></c:out></option>
		</c:forEach>
	</select>
</div>
	</div>
</div>







<div class="event-info">
	<span class="label-event-info cus-input-group-addon-create-event"><spring:message code="step1.title.eventInfro.des"/></span>
	<textarea id="event-info" rows="10" class="textarea-event-info"><c:out value="${event.introduction }"></c:out></textarea>
</div>

<div class="col-md-12">
	<span class="alert alert-info cus-input-group cus-input-group-padding cus-alert" role="alert">
		<spring:message code="step1.title.orgination"/> <span class="require">*</span>
	</span>
</div>

<div class="row">
	<div class="col-sm-10">
		<div class="input-group col-md-12 cus-input-group cus-input-group-padding">
	<span class="input-group-addon cus-input-group-addon-create-event cus-input-group-addon-inline"><spring:message code="step1.title.orgination.name"/></span>
	<input id="event-organize-name" class="form-control" type="text" placeholder="<spring:message code="step1.title.orgination.name.holder"/>" value='<c:out value="${event.organizeName }"></c:out>'/>
</div>
<div class="event-info">
	<span class="label-event-info cus-input-group-addon-create-event"><spring:message code="step1.title.orgination.des"/></span>
	<textarea id="event-organize-info" rows="10" class="textarea-event-info"><c:out value="${event.organizeInfo }"></c:out></textarea>
</div>
	</div>
	<div class="col-sm-2">
		<h3><spring:message code="step1.title.orgination.logo"/></h3>
<div class="upload-center-image organization-image" >
	<a href="">
		<input id="organization-file-input" class="hidden-file" type="file" accept="image/*">
		<c:choose>
			<c:when test="${event.organizeLogo ne null }">
				<img class="ouput-image" alt="Upload organization logo" src='<c:url value="/resources/images/${event.organizeLogo }" />'>
			</c:when>
			<c:otherwise>
				<img class="ouput-image" src="https://az810058.vo.msecnd.net/Images/vi-default-logo-event.png" alt="Upload organization logo">
			</c:otherwise>
		</c:choose>
	</a>
</div>
	</div>
</div>



<h2><spring:message code="step1.title.event.contact"/> <span class="require">*</span></h2>
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
	<span class="alert alert-info cus-input-group cus-input-group-padding cus-alert" role="alert">
		<spring:message code="step1.title.event.note"/>
		<i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
	</span>
</div>
<div class="contain-btn-create-event-step">
	<button id="btn-save-step-one" class="btn btn-default btn-ticket btn-create-event-step"><spring:message code="step1.title.event.buttonSave"/> <i class="fa fa-arrow-circle-right" aria-hidden="true"></i></button>
</div>

<!-- Modal -->
<div class="modal fade" id="crop-thumbnail-modal" role="dialog" aria-labelledby="modalLabel" tabindex="-1">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close crop-none" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="modalLabel"><spring:message code="step1.title.event.modal.dropImage"/></h4>
			</div>
			<div class="modal-body">
				<div class="img-container-550x200">
				    <img id="thumbnail-image" src=""/>
				</div>
			</div>
			<div class="modal-footer">
				<button id="crop" type="button" class="btn btn-default" data-dismiss="modal">Crop</button>
				<button type="button" class="btn btn-default crop-none" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
</div>