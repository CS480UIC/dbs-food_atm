<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> address for each warehouse_id </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>address</th>
		<th>warehouse_id</th>

	</tr>
<c:forEach items="${UserList}" var="warehouse">
	<tr>
		<td>${warehouse.warehouse_location}</td>
		<td>${warehouse.warehouse_id}</td>

</c:forEach>
</table>
</body>
</html>
