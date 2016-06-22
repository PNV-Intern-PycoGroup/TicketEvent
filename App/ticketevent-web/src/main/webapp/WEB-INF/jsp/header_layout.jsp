<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="pnv.intern.pyco/tags" prefix="layout"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Header</title>

<link rel="shortcut icon" href="/ticketevent-web/resources/icon/logo.svg"/>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<layout:header />
	<h1>Welcome <c:out value="${user.name}"/>!</h1>
	<h3>Your information: </h3>
	<table>
		<tr>
			<td>Age: </td>
			<td><c:out value="${user.age}"/></td>
		</tr>
		<tr>
			<td>Address: </td>
			<td><c:out value="${user.address}"/></td>
		</tr>
	</table>
	<layout:footer />
</body>
</html>