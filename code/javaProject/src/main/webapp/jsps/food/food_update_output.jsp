<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Update Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	food_id : <input type="integer" name="food_id" value="${food.food_id }" disabled/>
	<br/>
	
	name ：<input type="text" name="name" value="${food.name }" disabled/>
	<br/>
	food_location ：<input type="integer" name="food_location" value="${food.food_location }" disabled/>
	<br/>
	quantity ：<input type="integer" name="quantity" value="${food.quantity }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/foodServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
		<input type="hidden" name="food_id" value="${food.food_id }"/>
	name：<input type="text" name="name" value="${form.name }"/>
	<span style="color: red; font-weight: 900">${errors.name }</span>
	<br/>
	food_location	：<input type="integer" name="food_location" value="${form.food_location }"/>
	<span style="color: red; font-weight: 900">${errors.food_location }</span>
	<br/>
	quantity	：<input type="integer" name="quantity" value="${form.quantity }"/>
	<span style="color: red; font-weight: 900">${errors.quantity }</span>
	<br/>
	<input type="submit" value="Update food"/>
</form>

</body>
</html>
