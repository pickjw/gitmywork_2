<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%@page import="java.util.Enumeration"%>
<% 
Enumeration<String> headerNames = request.getHeaderNames();
while(headerNames.hasMoreElements()) { //다음요소가 있으면
	String key = (String) headerNames.nextElement();//값을 읽음
	String value = request.getHeader(key);//헤더값 조회
	out.println(key+":"+value+"<br>");
	
}
%> --%>
<!-- taglib prefix="접두사" uri="식별자" -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- forEach var="게별변수" items="집합 " -->
<%-- 	${cookie} => 쿠키정보
	${header} => request 헤더 정보 --%>
<c:forEach var="h" items="${header }">
	${h.key} => ${h.value} <br>
</c:forEach>
<hr>
   
 <!--   et var="변수명" value="값" scope="사용영역" 
 
  pageContext, request, session, application 
 
 user-agent 클라이언트의 웹브라우저 정보
 
 -->
<c:set var="browser" value="${header['user-agent']}"/> <!-- 영역.setAttribute("변수명", 값) -->


<!-- 	출력문 -->
<c:out value="${browser }"/>   <!-- out.println(값) -->

${browser }<br>
<hr>
<c:remove var="browser"/><br> <!-- removeAttribute() 대체-->
<c:out value="${browser }"/><br>













</body>
</html>