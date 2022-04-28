<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>location Create</title>
    
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
  <h1>location Create</h1>
<form action="<c:url value='/locationServletCreate'/>" method="post">
	location_id    :<input type="integer" name="location_id" value="${form.location_id }"/>
	<span style="color: red; font-weight: 900">${errors.location_id }</span>
	<br/>
	location_type：<input type="integer" name="location_type" value="${form.location_type }"/>
	<span style="color: red; font-weight: 900">${errors.location_type }</span>
	<br/>
	location_address	：<input type="text" name="location_address" value="${form.location_address }"/>
	<span style="color: red; font-weight: 900">${errors.location_address }</span>
	<br/>
	<input type="submit" value="Create location"/>
</form>
  </body>
</html>
