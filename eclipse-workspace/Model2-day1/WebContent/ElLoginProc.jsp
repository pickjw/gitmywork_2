<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

	<%
		String id = request.getParameter("id");
	
	
	%>

	당신의 아이디는 ${param.id} 패스워는 ${param.password}  입니다
</body>
</html>