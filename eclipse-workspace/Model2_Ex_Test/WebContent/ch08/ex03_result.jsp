<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <!-- JSTL(taglib), path 참조-->  
<%@ include file = "../include/header.jsp" %>
</head>
<body>
	<!-- set var="변수명" value="초기값"-->
	<c:set var="sum" value="0"/>  
	<!-- forEach var="카운터 변수" begin="시작" end="끝"-->
	<c:forEach var="i" begin="1" end="${param.num }">
		<c:set var="sum" value="${sum + i }"/>
	</c:forEach>
합계 : ${sum}


<%-- <%
int num = Integer.parseInt(request.getParameter("num"));
int sum = 0;
for (int i=1; i<=num; i++) {
	sum += i;
	
}
%>
합계 : <%=sum%> <br> --%>
</body>
</html>