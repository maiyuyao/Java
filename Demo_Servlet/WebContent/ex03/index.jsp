<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <h1>Servlet路径跳转</h1>
    <hr>
    <!-- 使用相对路径访问HelloServlet -->
    <!-- 错误写法: /ex003/HelloServlet 第一个/表示服务器的根目录，会丢掉context root -->
    <a href="ex003/HelloServlet">相对路径访问HelloServlet!</a><br><br>
    <!-- 使用绝对路径 访问HelloServlet,可以使用path变量:path变量表示项目的根目录-->
    <!-- 表单中action的URL地址写法，与超链接href方式完全相同。 -->
    <a href="<%=request.getContextPath()%>/ex003/HelloServlet">绝对路径访问HelloServlet!</a><br><br>
    <a href="ex003/TestServlet">相对路径访问TestServlet，跳转到Test.jsp</a><br><br>
    request.getContextPath()= <%=path%>
     
  </body>
</html>
