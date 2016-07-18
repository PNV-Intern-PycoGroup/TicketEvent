<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<title>Create event</title>
	
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/event-theme/create_event.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/lib/cropper.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/lib/datepicker.css">
</head>
<body>
	<article>
		<header>
			<nav class="navbar navbar-default navbar-fixed-top">
				<ul class="nav nav-pills header-control-step" role="tablist">
					<li class="active"><a class="a-header" href="#ticket-info" aria-controls="ticket-info" role="tab" data-toggle="tab">Thông tin sự kiện</a></li>
					<li><a class="a-header" href="#ticket-layout" aria-controls="ticket-layout" role="tab" data-toggle="tab">Bố cục trang web</a></li>
					<li><a class="a-header" href="#ticket-setting" aria-controls="ticket-setting" role="tab" data-toggle="tab">Cài đặt</a></li>
				</ul>
				<div>
					<div class="dropdown navbar-right language"><a href="#" class="dropdown-toggle a-header"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><span id="lang"><spring:message code="label.Language"/></span><span class="caret"> </span></a>
						<ul class="dropdown-menu">
							<li>
								<a href="?lang=vi">
									<img src="resources/icon/flag_vn.png"></img> Tiếng Việt
								</a>
								<a href="?lang=en">
									<img src="resources/icon/flag_en.png"></img> English
								</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- Modal -->
			<div class="modal fade" id="inform-modal" role="dialog" aria-labelledby="modalLabel" tabindex="-1">
			    <div class="modal-dialog modal-lg" role="document">
			    	<div class="modal-content">
			      		<div class="modal-header">
			        		<button type="button" class="close crop-none" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        		<h4 class="modal-title" id="modalLabel">Thông báo!</h4>
			      		</div>
			      		<div class="modal-body">
			        		<p class="message"></p>
			      		</div>
			      		<div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
			      		</div>
			    	</div>
			  	</div>
			</div>
			<div class="clear"></div>
		</header>
		<section class="banner tab-content content">
			<div role="tabpanel" class="tab-pane fade in active" id="ticket-info">
				<!-- Layout of step one here -->
			</div>
			<div role="tabpanel" class="tab-pane fade in" id="ticket-layout">
				<!-- Layout of step two here -->
			</div>
			<div role="tabpanel" class="tab-pane fade in" id="ticket-setting">
				<!-- Layout of last step here -->
			</div>
		</section>
	</article>
	<layout:user_footer></layout:user_footer>

	<script src='https://cdn.tinymce.com/4/tinymce.min.js'></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/boostrap-datepicker.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/bootstrap-notify.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/event-theme/create_event.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lib/cropper.min.js"></script>
</body>
</html>