<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@tag pageEncoding="UTF-8"%>

<footer class="main-footer">
	<div class="pull-right hidden-xs">Ticket Event</div>
	<strong>Copyright &copy; 2016 <a href="#">PNV Intern PYCO Group</a>.
	</strong> All rights reserved.
</footer>

<aside class="control-sidebar control-sidebar-dark">
	<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
		<li><a href="#control-sidebar-settings-tab" data-toggle="tab" class="hidden"></a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="control-sidebar-settings-tab">
				<h3 class="control-sidebar-heading">Cấu hình mail hệ thống</h3>
				<div class="form-group">
					<form:form class="form-horizontal" role="form" id="configForm">
					<input type=hidden name = "id">
					    <div class="form-group">
					      <label class="control-label col-sm-3" >Host:</label>
					      <div class="col-sm-9">
					        <input type="text" class="form-control" name="mailHost" placeholder="Enter host">
					      </div>
					    </div>
					    <div class="form-group">
					      <label class="control-label col-sm-3" >Email:</label>
					      <div class="col-sm-9">
					        <input type="email" class="form-control" name="userName" placeholder="Enter email">
					      </div>
					    </div>
					    <div class="form-group">
					      <label class="control-label col-sm-3" >Port:</label>
					      <div class="col-sm-9">
					        <input type="text" class="form-control" name="mailPort" placeholder="Enter port">
					      </div>
					    </div>
					    <div class="form-group">
					      <label class="control-label col-sm-3">Pass:</label>
					      <div class="col-sm-9">
					        <input type="password" class="form-control" name="emailPass" placeholder="Enter password">
					      </div>
					    </div>
					     <div class="form-group" style="margin-top: 80px;">
					      <label class="control-label col-sm-3" >To:</label>
					      <div class="col-sm-9">
					        <input type="email" class="form-control" id="emailTo" placeholder="Enter email">
					      </div>
					    </div>
					    <div style="padding: 15px;">
					    <div class="form-group">
						  <label for="comment col-sm-3">Content:</label>
						  <textarea class="form-control" rows="5" id="contentTest"></textarea>
						</div>
						</div>
					    <div class="form-group">
					      <div class="col-sm-offset-3 col-sm-9">
					        <button type="submit" class="btn btn-default">Lưu lại & test</button>
					      </div>
					    </div>
					 </form:form>
				</div>
		</div>
	</div>
</aside>
<div class="control-sidebar-bg"></div>
</div>
