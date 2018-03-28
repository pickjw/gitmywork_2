<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.js"></script>
</head>
<body>
<%
	String context = request.getContextPath();
%>
	<!-- session(세션) 서버에서 사용자를 인증하는 기술 -->
	<form action="/Model2Login/control_servlet/LoginCon.do" method="post">
	아이디 	<input type="text" name="userId"><br>
	패스워드	<input type="password" name="userPassword"><br>
	      	<input type="submit" value="로그인">
	</form>
	<!-- 로그인 실패, 로그아웃 매세지를 출력할 태그 -->
	<%-- <%
		String message = request.getParameter("message");
		if(message != null) {
	%>
	<span style="color:red;"><%=message%></span> --%>
	<!-- param.변수 request.getParameter("message") -->
	<span style="color:red;">${param.message}</span>  
	<%-- 
	<%
		}
	%>  --%>

</body>
</html>