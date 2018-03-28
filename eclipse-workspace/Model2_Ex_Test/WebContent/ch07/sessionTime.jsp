<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션의 유효시간</h2>
	<%
	session.setMaxInactiveInterval(1200); //1200초(20분)으로 변경
	int timeout = session.getMaxInactiveInterval();//web.xml에서 설정한거 15분 900초
	out.println("세션의 유효시간:"+timeout); //초 단위
	%>
</body>
</html>