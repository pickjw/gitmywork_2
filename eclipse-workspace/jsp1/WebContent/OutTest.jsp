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
		String name = "알리미 어플";
	
	
	%>
	
	스크립트로 표현시 <%= name %> 이 화면에 출력
	
	<p>
	
	
	<%
	
		out.println(name+ "이 화면에 출력");
	
	%>
	

</body>
</html>