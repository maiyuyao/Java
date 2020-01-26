<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="com.po.Users"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'testScope.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h1>Javabean Scope Test</h1>
	<hr>
	<!-- 此处修改 scope的值：application,session,request,page-->
	<jsp:useBean id="myUsers" class="com.po.Users" scope="session" />

	jsp:useBean 用户名：<jsp:getProperty name="myUsers" property="username" /><br>
	jsp:useBean 密码：<jsp:getProperty name="myUsers" property="password" /><br>
	<br>
	<!-- 使用内置对象获取用户名和密码 -->
	<hr>

	作用域application
	<br>
	<%
		String Ausername = "";
		String Apassword = "";
		if (application.getAttribute("myUsers") != null) {
			Ausername = ((Users) application.getAttribute("myUsers")).getUsername();
			Apassword = ((Users) application.getAttribute("myUsers")).getPassword();
		}
	%>
	application用户名：<%=Ausername%><br>
	application密码：<%=Apassword%><br>
	<br>


	作用域session
	<br>
	<%
		String Susername = "";
		String Spassword = "";
		if (session.getAttribute("myUsers") != null) {
			Susername = ((Users) session.getAttribute("myUsers")).getUsername();
			Spassword = ((Users) session.getAttribute("myUsers")).getPassword();
		}
	%>
	session用户名：<%=Susername%><br>
	session密码：<%=Spassword%><br>
	<br>


	作用域request
	<br>
	<%
		String Rusername = "";
		String Rpassword = "";
		if (request.getAttribute("myUsers") != null) {
			Rusername = ((Users) request.getAttribute("myUsers")).getUsername();
			Rpassword = ((Users) request.getAttribute("myUsers")).getPassword();
		}
	%>
	request用户名：<%=Rusername%><br>
	request密码：<%=Rpassword%><br>
	<br>


	作用域page
	<br>
	<%
		String Pusername = "";
		String Ppassword = "";
		if (pageContext.getAttribute("myUsers") != null) {
			Pusername = ((Users) pageContext.getAttribute("myUsers")).getUsername();
			Ppassword = ((Users) pageContext.getAttribute("myUsers")).getPassword();
		}
	%>
	pageContext用户名：<%=Pusername%><br>
	pageContext密码：<%=Ppassword%><br>



</body>
</html>
