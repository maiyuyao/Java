<%@ page language="java" import="java.util.*,java.io.*,java.lang.*" contentType="text/html; charset=utf-8"%>


<%
	response.setContentType("text/html;charset=utf-8"); //设置响应的MIME类型

	out.println("<h1>response内置对象</h1>");
	out.println("<hr>");
	// out.flush();
	Thread.sleep(2000);
	PrintWriter outer = response.getWriter(); //获得输出流对象

	for (int i = 1; i <= 5; i++) {
		outer.println("response对象:" + i + "<br>");
		Thread.sleep(500);
	}

	//请求重定向
	//response.sendRedirect("request.jsp");
	//请求转发
	request.getRequestDispatcher("request.jsp").forward(request, response);
%>


