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
/* session.removeAttribute("id");//세션변수 삭제(개별삭제)
session.removeAttribute("passwd");//세션변수 삭제(개별삭제) */
session.invalidate();//모든세션 초기화
%>
세션이 삭제 되었습니다.<br>
<a href="viewSession.jsp">세션확인</a>
</body>
</html>