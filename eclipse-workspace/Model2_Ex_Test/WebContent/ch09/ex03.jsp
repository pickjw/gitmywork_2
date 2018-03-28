<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/* pageContext.setAttribute("num", 100);
		   request.setAttribute("num", "200"); */
	%>
	<c:set var="num" value="<%= new Integer(100) %>" scope="page" /><!--  생략가능 scope="page" -->
	<c:set var="num" value="200" scope="request" /> <!-- 다음페이지 -->
	<c:set var="num" value="300" scope="session" /> <!-- 모든페이지 -->
	<c:set var="num" value="400" scope="application" /> <!-- 모든 사용자 -->
	
	${num}<br> <!-- 범위를 적지 않으면 현재 페이지임 -->
	${pageScope.num}<br>
	${requestScope.num}<br>
	${sessionScope.num}<br>
	${applicationScope.num}<br>
	
	<c:if test="${num > 10 }"><!-- 범위를 적지 않으면 현재 페이지임 -->
		${num } > 10
	</c:if>

</body>
</html>