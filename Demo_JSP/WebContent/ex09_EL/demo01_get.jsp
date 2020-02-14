<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ex01base.po.Users"%>

<!DOCTYPE HTML>
<html>
<head>
<title>el表达式获取数据</title>
</head>

<body>
	<%
		request.setAttribute("name", "01_randy");
	%>
	<%--${name}等同于pageContext.findAttribute("name") --%>
	使用EL表达式获取数据：${name}
	<hr>
	<!-- 在jsp页面中，使用el表达式可以获取bean的属性 -->
	<%
		Users u01 = new Users();
		u01.setUsername("Anna");
		request.setAttribute("Users", u01);
	%>
	使用el表达式可以获取bean的属性：${Users.username}
	<hr>
	<!-- 在jsp页面中，使用el表达式获取list集合中指定位置的数据 -->
	<%
		Users u02 = new Users();
		u02.setUsername("Bill");

		Users u03 = new Users();
		u03.setUsername("Denny");

		List<Users> list = new ArrayList<Users>();
		list.add(u02);
		list.add(u03);

		request.setAttribute("list", list);
	%>

	<!-- 取list指定位置的数据 -->
	list[1]: ${list[1].username}
	<br>
	<!-- 迭代List集合 -->
	迭代List集合: 
	<c:forEach var="U" items="${list}">
     ${U.username}  
    </c:forEach>
	<hr>
	<!-- 在jsp页面中，使用el表达式获取map集合的数据 -->
	<%
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("a", "map01_Kenny");
		map.put("b", "map02_Kevin");
		map.put("c", "map03_Sherry");
		map.put("d", "map04_Belinda");
		request.setAttribute("map", map);
	%>

	<!-- 根据关键字取map集合的数据 -->
	根据关键字取map集合: ${map.c} ${map["1"]}
	<hr>
	<!-- 迭代Map集合 -->
	迭代map集合 :
	<br>
	<c:forEach var="me" items="${map}">
          ${me.key}=${me.value}<br />
	</c:forEach>
	<hr>
</body>
</html>