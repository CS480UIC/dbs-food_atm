<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> id and location of atms that have a warehouse at the same location </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>atm_id</th>
		<th>atm_location</th>

	</tr>
<c:forEach items="${UserList}" var="atm">
	<tr>
		<td>${atm.atm_id}</td>
		<td>${atm.atm_location}</td>

</c:forEach>
</table>
</body>
</html>
