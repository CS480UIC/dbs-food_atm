<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Warehouse</title>
    
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
  <h1>Update Warehouse</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	warehouse_id    :<input type="integer" name="warehouse_id" value="${warehouse.warehouse_id }" disabled/>
	<br/>
	warehouse_location：<input type="integer" name="warehouse_location" value="${warehouse.warehouse_location }" disabled/>
	<br/>
	warehouse_last_restocked	：<input type="datetime" name="warehouse_last_restocked" value="${warehouse.warehouse_last_restocked }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/warehouseServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="warehouse_id" value="${warehouse.warehouse_id }"/>
	warehouse_location：<input type="integer" name="warehouse_location" value="${form.warehouse_location }"/>
	<span style="color: red; font-weight: 900">${errors.warehouse_location }</span>
	<br/>
	warehouse_last_restocked	：<input type="datetime" name="warehouse_last_restocked" value="${form.warehouse_last_restocked }"/>
	<span style="color: red; font-weight: 900">${errors.warehouse_last_restocked }</span>
	<br/>
	<input type="submit" value="Update warehouse"/>
</form>

</body>
</html>
