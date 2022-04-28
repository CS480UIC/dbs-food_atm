<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> food with quantity > 3 </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>id</th>
		<th>name</th>
		<th>location</th>
		<th>quantity</th>
	</tr>
<c:forEach items="${UserList}" var="food">
	<tr>
		<td>${food.food_id}</td>
		<td>${food.name}</td>
		<td>${food.food_location}</td>
		<td>${food.quantity}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
