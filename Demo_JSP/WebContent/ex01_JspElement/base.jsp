<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="java.text.*"%>
<%@ page import="viewListDemo.entity.Items"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>Home page</title>
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
	<h1>JSP page element</h1>
	<hr>
	•静态内容:
	<br>
	•指令，在头部
	<br>
	•表达式
	<br>
	<!--表达式语法1-->
	表达式语法1: url is:
	<jsp:expression>basePath</jsp:expression><br>
	<!--表达式语法2-->
	表达式语法2: 你好,<%=s%><br>
	表达式语法2：x+y=<%=add(10, 5)%><br>
	表达式语法2： path is
	<%=path%><br>
	<br>
	•脚本
	<br>
	脚本语法1：
	<jsp:scriptlet>out.println("Your IP address is " + request.getRemoteAddr());</jsp:scriptlet>
	<br>
	<%
		//单行注释
		/*多行注释*/
		out.println("脚本语法2：大家好，欢迎大家学习JAVAEE开发。");
	%>
	<br>
	•声明(页面不可见)
	<%!String s = "张三"; //声明了一个字符串变量

	int add(int x, int y) //声明了一个返回整型的函数，实现两个整数的求和。
	{
		return x + y;
	}%>
	<br>
	•注释
	<!-- 我是HTML注释，在客户端可见 -->
	<%-- 我是JSP注释，在客户端不可见 --%>
	<br>
	<h1>JSP生命周期</h1>
	<hr>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s = sdf.format(new Date());
	%>
	时间:<%=s%>
</body>
</html>
