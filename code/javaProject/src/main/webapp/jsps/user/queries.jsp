<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    
    <h1>Demo Query:</h1><br>
    <a href="<c:url value='/findAll'/>" target="body">List all the user in the table</a>&nbsp;&nbsp;
    
    <br><br><h3>Simple Queries:</h3>
    <a href="<c:url value='/simple0'/>" target="body">List food with quantity > 3</a>&nbsp;&nbsp;
    <br><a href="<c:url value='/simple1'/>" target="body">List atms that have 45 in their id</a>&nbsp;&nbsp;
    
    <br><br><h3>Aggregate Queries:</h3>
    <a href="<c:url value='/aggregate0'/>" target="body">Get sum of all user balances</a>&nbsp;&nbsp;
    <br><a href="<c:url value='/aggregate1'/>" target="body">Get sum of user balances for each member type</a>&nbsp;&nbsp;
 	<br><a href="<c:url value='/aggregate2'/>" target="body">Get counts of unique restock times for warehouses</a>&nbsp;&nbsp;
    <br><a href="<c:url value='/aggregate3'/>" target="body">Get counts of users for each type</a>&nbsp;&nbsp;
 	
 	<br><br><h3>Complex Queries:</h3>
    <a href="<c:url value='/complex0'/>" target="body">Get address for each warehouse_id</a>&nbsp;&nbsp;
    <br><a href="<c:url value='/complex1'/>" target="body">Get total quantity of food at location type 2</a>&nbsp;&nbsp;
 	<br><a href="<c:url value='/complex2'/>" target="body">Get counts of unique restock times for warehouses</a>&nbsp;&nbsp;
    
  </body>
</html>
