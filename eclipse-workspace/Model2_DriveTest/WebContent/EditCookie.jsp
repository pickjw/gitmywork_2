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
	response.addCookie(new Cookie("id","park"));
%>

아이디 : ${cookie.id.value}<br>
쿠키가 변경 되었습니다.<br>
<a href="UseCookie.jsp">쿠키확인</a>
</body>
</html>