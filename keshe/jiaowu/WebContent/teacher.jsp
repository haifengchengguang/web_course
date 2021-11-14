<%@page import="model.Teacher" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<title>老师端</title>
	<link rel="stylesheet" type="text/css" href="css/teacher.css">
	
</head>
	
<body>
	<%
		//获取登录成功的用户信息
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//判断用户是否登录
		if(teacher != null){
	%>
	<header>
		<div class="title">
			<span>学生教务系统</span>
		</div>
		<nav>
			<div class="userinfo">
				<ul>
					<li><%=teacher.getName() %></li>
					<li><a href="TeacherExitServlet">退出登录</a></li>
					<li><a href="loginteacher.html">返回首页</a></li>
				</ul>
			</div>
		</nav>
	</header>
	
	<main>
		<%
		}else{
			response.sendRedirect("loginteacher.html");
		}
		%>
		<div class="container">
			<div class="select">
				<ul id="accordion" class="accordion">
					<li>
						<div class="link">学生信息管理</div>
						<ul class="submenu">
							<li><a onclick="query_all('student')">查看所有学生</a></li>
							<li><a onclick="show_insert('student')">新增学生信息</a></li>
							<li><a onclick="show_delete('student')">删除学生信息</a></li>
							<li><a onclick="show_change('student')">修改学生信息</a></li>
						</ul>
					</li>
					<li>
						<div class="link">课程管理</div>
						<ul class="submenu">
							<li><a onclick="query_all('course')">查看所有课程</a></li>
							<li><a onclick="show_insert('course')">新增课程信息</a></li>
							<li><a onclick="show_delete('course')">删除课程信息</a></li>
							<li><a onclick="show_change('course')">修改课程信息</a></li>
						</ul>
					</li>
					<li>
						<div class="link">学生成绩管理</div>
						<ul class="submenu">
							<li><a onclick="query_all('score')">查看所有学生成绩</a></li>
							<li><a onclick="show_insert('score')">新增成绩信息</a></li>
							<li><a onclick="show_delete('score')">删除成绩信息</a></li>
							<li><a onclick="show_change('score')">修改学生成绩</a></li>
						</ul>
					</li>
					<li>
						<div class="link">学生社会成果管理</div>
						<ul class="submenu">
							<li><a onclick="query_all('achievement')">查看全部学生社会成果</a></li>
							<li><a onclick="show_insert('achievement')">添加学生社会成果</a></li>
							<li><a onclick="show_delete('achievement')">删除学生社会成果</a></li>
							<li><a onclick="show_change('achievement')">修改学生社会成果</a></li>
						</ul>
					</li>
				</ul>
				</div>

				<div id="result" class="result">
				</div>
			</div>
	</main>
	
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/teacher.js"></script>
</body>
</html>