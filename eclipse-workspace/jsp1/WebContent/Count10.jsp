<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>1~10까지의 숫자를 화면에 표시</h2>

	<%
		//1~10 까지 숫자를 화면에 출력하시오

		for (int i = 1; i < 10; i++) {
			//System.out.println(i);
			
	%>
	
	
	<!-- 브라우져에 보이기 --> 
		<%=  i  %> <br>
	<!-- 브라우져에 보이기 --> 
	
	<%
		}
	%>




</body>
</html>