<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
<h1>Delete Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Entity1ServletDelete'/>" method="post">
    <input type="hidden" name="method" value="delete"/>
    <input type="hidden" name="username" value="${atm.atm_id }"/>
    atm_id :<input type="text" name="atm_id" value="${atm.atm_id }" disabled/>
    <br/>

    atm_location：<input type="text" name="atm_location" value="${atm.atm_location }" disabled/>
    <br/>
    atm_last_restocked ：<input type="text" name="atm_last_restocked" value="${atm.atm_last_restocked }" disabled/>
    <br/>
    associated_warehouse ：<input type="text" name="associated_warehouse" value="${atm.associated_warehouse }" disabled/>
    <br/>
    <input type="submit" value="Delete atm"/>
</form>

</body>
</html>
