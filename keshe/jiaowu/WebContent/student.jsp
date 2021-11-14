<%@page import="model.Stu" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<title>学生教务界面</title>
	<link rel="stylesheet" type="text/css" href="css/student.css">
	
</head>
	
<body>
	<%
		//获取登录成功的用户信息
		Stu stu = (Stu) session.getAttribute("stu");
		//判断用户是否登录
		if(stu != null){
	%>
	<header>
		<div class="title">
			<span id="spancolor">本科生教务系统</span>
		</div>
		<nav>
			<div class="userinfo">
				<ul>
					<li >姓名<%=stu.getName() %></li>
					<li >学号<%=stu.getId() %></li>
					<li><a href="StuExitServlet">退出登录</a></li>
					<li><a href="loginstu.html">返回首页</a></li>
				</ul>
			</div>
		</nav>
	</header>
	
	<main>
		<%
		}else{
			response.sendRedirect("loginstu.html");
		}
		%>
		<div class="container">
			<div class="select">
				<ul id="accordion" class="accordion">
					<li>
						<div class="link">个人信息</div>
						<ul class="submenu">
						<li><a onclick="query_student('information')">查看信息</a></li>
							<li><a onclick="show_change('student')">修改密码</a></li>
							
						</ul>
					</li>
					<li>
						<div class="link">我的课程</div>
						<ul class="submenu">
							<li><a onclick="query_student('course')">查看我的课程</a></li>
						</ul>
					</li>
					<li>
						<div class="link">选课</div>
						<ul class="submenu">
							<li><a  onclick="query_all('course')">查看所有课程</a></li>
						</ul>
					</li>
					<li>
						<div class="link">成绩</div>
						<ul class="submenu">
							<li><a onclick="query_student('score')">查看我的成绩</a></li>
						</ul>
					</li>
					<li>
						<div class="link">我的社会成果</div>
						<ul class="submenu">
							<li><a  onclick="query_student('achievement')">查看我的社会成果</a></li>
						</ul>
					</li>
				</ul>
				
				</div>
				<input id="name" type="hidden" value=<%=stu.getName() %>>
				<input id="id" type="hidden" value=<%=stu.getId() %>>
				<div id="result" class="result">	
				</div>
		</div> 
	</main>
	
	
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/student.js"></script>
</body>
</html>