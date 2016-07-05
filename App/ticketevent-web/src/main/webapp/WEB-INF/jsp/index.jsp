<%@ include file="./include_tag_lib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/index.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/footer.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/header_style.css">
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.12.1/ui-bootstrap-tpls.min.js"></script>
<title>Welcome</title>
<script>
    	function Hello($scope, $http) {
    	    $http.get('http://http://localhost:8080/ticketevent-web/api').
    	        success(function(data) {
    	            $scope.user = data;
    	        });
    	}
    	</script>
    	<script type="text/javascript">
    	var app = angular.module('myApp', ['ui.bootstrap']);
    	</script>
    	<script type="text/javascript">
					   		function checkUserName(username){
					   			var varcheck;
					   			if(username.length <= 0){
					   				varcheck = "Username is required";
					   			}else if(username.length < 4 || username.length > 10){
					   				varcheck = "Min 4 character Max 10 character";
					   			}
					   			return varcheck;
					   		}
					    </script>
</head>
<body ng-app="myApp">

	<layout:header></layout:header>
	<section id="myCarousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1" alt="Chania">
			</div>

			<div class="item">
				<img src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1" alt="Chania">
			</div>

			<div class="item">
				<img src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1" alt="Flower">
			</div>
		</div>

		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="icon-prev"></span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span class="icon-next"></span>
		</a>
	</section>
	<section class="hot-title" id="top-event">
		<spring:message code="index.hotEventTitle" />
	</section>

	<section class="event-container">
		<div class="row event-element">	
				<div class="col-sm-6 event-fix">
					<div class="event-child">
						<img alt="" src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1">
						<div class="event-detail">
							<div class="event-title">Ticket Event</div>
							<div class="event-infor">
								<div class="event-price">From 500.000 vnđ</div>
								 <div class="event-action">
								<div class="event-location table-cell">HO CHI MINH</div>
								<div class="event-category table-cell">
									<i class="fa fa-th" aria-hidden="true"></i> Category
								</div>
								<div class="comment table-cell"><a href="#">1 <i class="fa fa-commenting" aria-hidden="true"></i></a></div>
								<!-- <div class="event-calendar"></div> -->
							</div>
							<div class="ribbon-wrapper">
								<div class="ribbon-month">november</div>
								<div class="ribbon-date">21</div>
								<div class="ribbon-dayofweek">Wednesday</div>
							</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-sm-6 event-fix">
					<div class="event-child">
						<img alt="" src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1">
						<div class="event-detail">
							<div class="event-title">Ticket Event</div>
							<div class="event-infor">
								<div class="event-price">From 500.000 vnđ</div>
								 <div class="event-action">
								<div class="event-location table-cell">HO CHI MINH</div>
								<div class="event-category table-cell">
									<i class="fa fa-th" aria-hidden="true"></i> Category
								</div>
								<div class="comment table-cell"><a href="#">1 <i class="fa fa-commenting" aria-hidden="true"></i></a></div>
								<!-- <div class="event-calendar"></div> -->
							</div>
							<div class="ribbon-wrapper">
								<div class="ribbon-month">november</div>
								<div class="ribbon-date">21</div>
								<div class="ribbon-dayofweek">Wednesday</div>
							</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-sm-6 event-fix">
					<div class="event-child">
						<img alt="" src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1">
						<div class="event-detail">
							<div class="event-title">Ticket Event</div>
							<div class="event-infor">
								<div class="event-price">From 500.000 vnđ</div>
								 <div class="event-action">
								<div class="event-location table-cell">HO CHI MINH</div>
								<div class="event-category table-cell">
									<i class="fa fa-th" aria-hidden="true"></i> Category
								</div>
								<div class="comment table-cell"><a href="#">1 <i class="fa fa-commenting" aria-hidden="true"></i></a></div>
								<!-- <div class="event-calendar"></div> -->
							</div>
							<div class="ribbon-wrapper">
								<div class="ribbon-month">november</div>
								<div class="ribbon-date">21</div>
								<div class="ribbon-dayofweek">Wednesday</div>
							</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-sm-6 event-fix">
					<div class="event-child">
						<img alt="" src="https://az810058.vo.msecnd.net/static-page/img/quest-2016-cover.jpg?v1">
						<div class="event-detail">
							<div class="event-title">Ticket Event</div>
							<div class="event-infor">
								<div class="event-price">From 500.000 vnđ</div>
								 <div class="event-action">
								<div class="event-location table-cell">HO CHI MINH</div>
								<div class="event-category table-cell">
									<i class="fa fa-th" aria-hidden="true"></i> Category
								</div>
								<div class="comment table-cell"><a href="#">1 <i class="fa fa-commenting" aria-hidden="true"></i></a></div>
								<!-- <div class="event-calendar"></div> -->
							</div>
							<div class="ribbon-wrapper">
								<div class="ribbon-month">november</div>
								<div class="ribbon-date">21</div>
								<div class="ribbon-dayofweek">Wednesday</div>
							</div>
							</div>
						</div>
					</div>
				</div>
		</div>
	</section>

	<section class="hot-title" id="top-event">
		<spring:message code="index.eventByCategory" />
	</section>

	<section class="event-category-bar">
		<div class="event-cgb-element">
		<div class="row">
			<div class="col-sm-4 center-position">
				<a href = "#">
				<img class="hidden-xs" src="<%=request.getContextPath()%>/resources/icon/course_category.png"></img>
				<div class="event-category-title"><spring:message code="index.eventEntertaiment" /></div>
				<div class="event-link">50 <spring:message code="index.eventCount"/></div>
				</a>
			</div>
			<div class="col-sm-4 center-position">
				<a href = "#">
				<img class="hidden-xs" src="<%=request.getContextPath()%>/resources/icon/course_category.png"></img>
				<div class="event-category-title"><spring:message code="index.eventCourse" /></div>
				<div class="event-link">100 <spring:message code="index.eventCount"/></div>
				</a>
			</div>
			<div class="col-sm-4 center-position">
				<a href = "#">
				<img class="hidden-xs" src="<%=request.getContextPath()%>/resources/icon/course_category.png"></img>
				<div class="event-category-title"><spring:message code="index.eventElse"/></div>
				<div class="event-link">1000 <spring:message code="index.eventCount"/></div>
				</a>
			</div>
			
			</div>
		</div>
	</section>
	<layout:footer></layout:footer>

	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/js/scroll_index.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/header.js"></script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>
</html>