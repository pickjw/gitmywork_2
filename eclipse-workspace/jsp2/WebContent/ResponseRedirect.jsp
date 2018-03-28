<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>



	 <h2>ResponseRedirect.jsp 페이지 입니다.</h2>
	
	<%
	
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String phone = request.getParameter("phone");
		
		
	
	
	%>

		<h3> 아이디 = <%= id %> phone= <%= phone  %></h3>
		
		
		
</body>
</html>