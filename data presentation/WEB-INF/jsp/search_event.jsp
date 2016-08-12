<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Search event</title> 
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
	<layout:user_header></layout:user_header>
	
    <div class="clearfix contain-search">
        <div class="col-md-12">
            <div class="col-md-4 cus-col-md-4 event-search-selectpicker">
                <!-- type -->
				<select id="event-type-search" class="selectpicker" title="Thể loại sự kiện" >
					<c:forEach items="${listEventType }" var="eventType">
						<option value='<c:out value="${eventType.name }"></c:out>'><c:out value="${eventType.name }"></c:out></option>
					</c:forEach>
				</select>
            </div>
            <div class="col-md-4 cus-col-md-4">
                <!-- date time -->
                <div class="">
                	<div class="input-group">
						<input id="search-event-start-date" class="form-control" type="text" placeholder="Bắt đầu" />
	                	<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
						<input id="search-event-end-date" class="form-control" type="text" placeholder="Kết thúc" />
					</div>
                </div>
            </div>
            <div class="col-md-4 cus-col-md-4 event-search-selectpicker">
                <!-- price -->
                <select id="event-price-search" class="selectpicker" title="Giá vé" >
					<option>Miễn phí</option>
					<option>Có phí</option>
				</select>
            </div>
        </div>
    </div>

	<section class="event-container">
		<div id="contain-event-thumbnail" class="row event-element">
		</div>
		<ul class="pager">
			<li><button class="btn btn-default btn-event-pre">trước</button></li>
			<li><button class="btn btn-default btn-ticket btn-event-current">1</button></li>
			<li><button class="btn btn-default btn-event-next">tiếp</button></li>
		</ul>
	</section>
	
	<layout:user_footer></layout:user_footer>

	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.12.1/ui-bootstrap-tpls.min.js"></script>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/boostrap-datepicker.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/header.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/search.js"></script>
</body>
</html>