<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<h2>세션 네임 페이지 입니다.</h2>
		
		
		<%
			
			//String name1 = request.getParameter("name");//받아보기 시도 (String name = "shin";)
			
			//세션값 받아오기->object타입이라서  String으로 뺴야 한다.
			String name1 = (String) session.getAttribute("name1");
		
		%>
	
		<%= name1 %> 님 반갑습니다.
	
</body>
</html>