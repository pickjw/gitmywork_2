<%-- <%@page import="java.util.ArrayList"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<!-- forEach var="변수" begin="시작" end="끝" 횟수가 정해 진 경우-->
<!-- forEach var="개별값" items="집합"-->
<c:forEach var="fruit" items="${items}">
	${fruit}<br>
</c:forEach>

<%-- <%
ArrayList<String> items = (ArrayList<String>)request.getAttribute("items");
for (String str : items) {
	out.println(str+"<br>");
}


%> --%>
</body>
</html>