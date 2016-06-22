<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Input</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<layout:header />
	<span><c:out value="${error}"/></span>
	<form action="add-user" method="post">
		Name: <input type="text" name="name" /><br/>
		Age: <input type="text" name="age" /><br/>
		Address: <input type="text" name="address" /><br/>
		<input type="submit" value="Submit" />
	</form>
	<layout:footer/>
</body>
</html>