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
    <h1>CRUD operations for atm </h1>
    <br>
	<a href="<c:url value='/jsps/atm/atmcreate.jsp'/>" target="_parent">Create atm</a> |&nbsp; 
	<a href="<c:url value='/jsps/atm/atmread.jsp'/>" target="_parent">Read atm</a> |&nbsp;
	<a href="<c:url value='/jsps/atm/atmupdate.jsp'/>" target="_parent">Update atm</a> |&nbsp;	 
	<a href="<c:url value='/jsps/atm/atmdelete.jsp'/>" target="_parent">Delete atm</a>	
	    
  </body>
</html>
