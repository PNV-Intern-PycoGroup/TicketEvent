<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag pageEncoding="UTF-8"%>

<h1>Tạo sự kiện theo cách của bạn</h1>
<div>
	<form method="post">
		<textarea id="create-event-free-style"></textarea>
	</form>
	
	<div id="myrender">
		<button onclick="get_editor_content()"></button>
	</div>
</div>