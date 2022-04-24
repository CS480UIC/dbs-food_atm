<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>atm Create</title>
    
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
  <h1>atm Create</h1>
<form action="<c:url value='/atmServletCreate'/>" method="post">
	atm_id    :<input type="integer" name="atm_id" value="${form.atm_id }"/>
	<span style="color: red; font-weight: 900">${errors.atm_id }</span>
	<br/>
	atm_location：<input type="integer" name="atm_location" value="${form.atm_location }"/>
	<span style="color: red; font-weight: 900">${errors.atm_location }</span>
	<br/>
	atm_last_restocked	：<input type="datetime" name="atm_last_restocked" value="${form.atm_last_restocked }"/>
	<span style="color: red; font-weight: 900">${errors.atm_last_restocked }</span>
	<br/>
	associated_warehouse	：<input type="integer" name="associated_warehouse" value="${form.associated_warehouse }"/>
	<span style="color: red; font-weight: 900">${errors.associated_warehouse }</span>
	<br/>
	<input type="submit" value="Create atm"/>
</form>
  </body>
</html>
