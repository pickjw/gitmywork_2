<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<!-- RequestLogin에서 넘어온 아이디와 패스워드를 읽어 드림  -->

<%
	//사용자의 정보가 저장되어 있는 객체 request의 getParameter() 사용자 정보를 추출
	String id = request.getParameter("id");//사용자의 id값을 읽어 드려서 변수 id에 저장하시오
	
	String pass = request.getParameter("pass");


%>
	<h2> 당신의 아이디는 <%= id %> 이고 패스워드는 <%= pass %> 입니다. </h2>

	<a href="RequestForward.jsp">다음페이지</a>

</body>
</html>