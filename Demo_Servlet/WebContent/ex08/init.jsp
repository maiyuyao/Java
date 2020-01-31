<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="ex08_ListenerBase.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

request.setAttribute("requestName", "requestValue");
request.getSession().setAttribute("sessionName", "sessionValue");
request.getSession().getServletContext().setAttribute("contextName", "contextValue");
request.setAttribute("requestName", "requestValue");
request.removeAttribute("requestName");

request.getSession().setAttribute("currentUser", new User());

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'init.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    这是初始化值的界面
    <button onclick="location.href='<%=request.getContextPath()%>/ex08/init.jsp';">Init</button>
    <button onclick="location.href='<%=request.getContextPath()%>/ex08/destory.jsp';">Destory</button>
  </body>
</html>
