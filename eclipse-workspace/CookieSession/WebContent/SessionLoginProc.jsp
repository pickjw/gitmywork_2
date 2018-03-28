<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

	<center>
		<h2>세션 로그인 처리 1</h2>

		<%
			request.setCharacterEncoding("Utf-8");
			
			//사용자로 부터 데이터를 읽어 드림
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			
			//아이디와 패스워드 저장- 다음페이지에 넘기기위한 세션저장
			session.setAttribute("id", id);
			session.setAttribute("pass", pass);
			
			//세션의 유지시간 설정 60초간 유지
			session.setMaxInactiveInterval(60*2);//2분간 유지
		
			
			response.sendRedirect("SessionMain.jsp");
		
		%>
		<!-- 

		<h2>당신의 아이디는 <%=id %>입니다. 패스워드는 <%= pass %>입니다.</h2>
		<a href="SessionLoginProc2.jsp">다음페이지로 이동</a>
		<a href="SessionLoginProc2.jsp? id=<%= id %> &pass=<%= pass %>">다음페이지로 이동</a>-->


	</center>

</body>
</html>