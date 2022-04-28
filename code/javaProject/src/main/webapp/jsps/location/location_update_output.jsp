<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>Delete location</title>

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
<h1>Update Location</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
    location_id :<input type="integer" name="location_id" value="${location.location_id }" disabled/>
    <br/>
    location_type：<input type="text" name="location_type" value="${location.location_type }" disabled/>
    <br/>
    address ：<input type="text" name="address" value="${location.address }" disabled/>
    <br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/locationServletUpdate'/>" method="post">
    <input type="hidden" name="method" value="update"/>
    <input type="hidden" name="location_id" value="${location.location_id }"/>
    location_type：<input type="integer" name="location_type" value="${form.location_type }"/>
    <span style="color: red; font-weight: 900">${errors.location_type }</span>
    <br/>
    address ：<input type="text" name="address" value="${form.address}"/>
    <span style="color: red; font-weight: 900">${errors.location_address }</span>
    <br/>
    <input type="submit" value="Update location"/>
</form>

</body>
</html>
