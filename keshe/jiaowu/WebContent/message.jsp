<%@page import="model.Stu" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>错误</title>
	<link rel="stylesheet" type="text/css" href="css/message.css">
</head>               
<body>
	<div class="message">
		<div class="top">
		<% String info=(String)request.getAttribute("info"); %>
		<h1><%=info%></h1>
		</div>
                                                                                                                                                          
	<div class="bottom">
		<a class="login" href="loginstu.html">学生登录</a><br>
		<a class="login" href="loginteacher.html">老师登录</a>
	</div>
	</div>
</body>
</html>