<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
</head>
<body>
	
	
		<h2>이페이지는 로그인 정보가 넘어오는 페이지 입니다.</h2>
	
	<%
	
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		//response.sendRedirect("ResponseRedirect.jsp");//흐름제어
	
	
	%>
		<!--jsp:forward 흐름제어-->
		
		
		<jsp:forward page="ResponseRedirect.jsp"></jsp:forward> 
		
		
		
		<!-- 흐름제어	
		<jsp:forward page="ResponseRedirect.jsp">
			<jsp:param value="mmmm" name="id"/>
			<jsp:param value="1234" name="phone"/>
		</jsp:forward> -->
	

		<h3> 아이디 = <%= id %></h3>


</body>
</html>