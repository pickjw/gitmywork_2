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
String id = "kim@nate.com";
String passwd = "1234";
int age = 20;
double height = 170.5;
//세션변수는 자료형의 제한이 없음, 인코딩 할 필요 없음
session.setAttribute("id", id);
session.setAttribute("passwd", passwd);
session.setAttribute("age", age);
session.setAttribute("height", height);
%>
세션 변수가 저장 되었습니다.
<a href="viewSession.jsp">세션확인</a>
</body>
</html>