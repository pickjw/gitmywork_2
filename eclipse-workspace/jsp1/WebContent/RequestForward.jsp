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
	//사용자의 정보가 저장되어 있는 객체 request의 getParameter() 사용자 정보를 추출
	String id = request.getParameter("id");//사용자의 id값을 읽어 드려서 변수 id에 저장하시오
	
	String pass = request.getParameter("pass");


%>
	<h2> 
	
	RequestForward 페이지 입니다. <br>
	당신의 아이디는 <%= id %> 이고 패스워드는 <%= pass %> 입니다. 
	
	</h2>

</body>
</html>