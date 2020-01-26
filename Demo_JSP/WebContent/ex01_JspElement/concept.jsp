<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="java.text.*"%>
<%@ page import="viewListDemo.entity.Items"%>
<!DOCTYPE html>
<html>
<head>
<title>Home page</title>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<h1>JSP page element</h1>
	<br>
	<!--表达式语法1-->
	表达式语法1: url is:
	<!--表达式语法2-->
	表达式语法2: 你好,<%=s%><br>
	表达式语法2：x+y=<%=add(10, 5)%><br>
	<br>
	<!--小脚本-->
	<jsp:scriptlet>out.println("Your IP address is " + request.getRemoteAddr());</jsp:scriptlet>
	<br>
	<%
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
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s = sdf.format(new Date());
	%>
	时间:<%=s%>

</body>

</body>
</html>