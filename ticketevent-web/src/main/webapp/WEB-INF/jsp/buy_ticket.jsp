<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Buy ticket | </title> 
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="_csrf" content="${_csrf.token}"/>
 	<meta name="_csrf_header" content="${_csrf.headerName}"/>
 	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/index.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/lib/datepicker.css">
</head>
<body>
	<h1 class="title">Đặt vé</h1>
    <div class="clearfix contain-search">
        <div class="col-md-12">
            <div class="col-md-6">
                <div class="margin-col-15">
                	<div class="input-group">
	                	<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span> Tên</span>
						<input id="buyer-name" class="form-control" type="text" placeholder="Tên" value='<c:if test="${account.userInfor != null}"><c:out value="${account.userInfor.name }"></c:out></c:if>' />
						<select id="buyer-gender" class="selectpicker input-group-addon cus-second-group-addon buyer" title="Giới tính" >
							<option <c:if test="${account.userInfor != null && account.userInfor.gender eq 'Nam'}">selected</c:if>>Nam</option>
							<option <c:if test="${account.userInfor != null && account.userInfor.gender eq 'Nữ'}">selected</c:if>>Nữ</option>
						</select>
					</div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="margin-col-15">
                	<div class="input-group">
	                	<span class="input-group-addon"><span class="glyphicon glyphicon-map-marker"></span> Địa chỉ</span>
						<input id="buyer-address" class="form-control" type="text" placeholder="Địa chỉ" value="<c:if test="${account.userInfor != null}"><c:out value="${account.userInfor.address }"></c:out></c:if>" />
					</div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="margin-col-15">
                	<div class="input-group">
	                	<span class="input-group-addon"><span class="glyphicon glyphicon-earphone"></span> Số điện thoại</span>
						<input id="buyer-phone-number" class="form-control" type="number" placeholder="Số điện thoại" value="<c:if test="${account.userInfor != null}"><c:out value="${account.userInfor.phone }"></c:out></c:if>" />
					</div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="margin-col-15">
                	<div class="input-group">
	                	<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span> Ngày sinh</span>
						<input id="buyer-date-of-birth" class="form-control" type="text" placeholder="Ngày sinh" value="<c:if test="${account.userInfor != null}"><c:out value="${account.userInfor.getDateOfBirthString() }"></c:out></c:if>" />
					</div>
                </div>
            </div>
        </div>
        <div class="col-md-12 background-hightligh contain-ticket">
        	<h2 class="title">Chọn vé</h2>
        	<c:forEach items="${event.listTicket }" var="ticket">
        		<div class="col-md-12">
	                <div class="margin-col-15">
	                	<div class="input-group">
	                		<input type="hidden" class="ticket-id" value="${ticket.id }" />
	                		<input type="hidden" class="ticket-price" value="${ticket.price }" />
		                	<span class="input-group-addon"><c:out value="${ticket.name }" /></span>
							<input class="form-control ticket-quantity" type="number" placeholder="Số lượng" value="0" min="0"/>
							<span class="input-group-addon cus-second-group-addon total-money-ticket">Thành tiền</span>
						</div>
	                </div>
	            </div>
        	</c:forEach>
        </div>
        
        <div class="contain-btn-create-event-step">
			<button id="btn-save-buy-ticket" class="btn btn-default btn-ticket btn-finish">Đặt vé <i class="fa fa-floppy-o" aria-hidden="true"></i></button>
		</div>
    </div>
	
	<layout:user_footer></layout:user_footer>

	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.12.1/ui-bootstrap-tpls.min.js"></script>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/boostrap-datepicker.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/buy_ticket.js"></script>
</body>
</html>