<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie cookie = new Cookie("id","");//비어있는 스트링으로 만들어야 함
	cookie.setMaxAge(0);//즉시 삭제됨
	response.addCookie(cookie);
	

%>
쿠키가 삭제 되었습니다.
<!-- <a href="UseCookie.jsp">쿠키 확인</a> -->
<a href="UseCookie.jsp?name=kim">쿠키 확인</a>
</body>
</html>