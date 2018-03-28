<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

	<center>
		<h2>세션 로그인 처리 2</h2>

		<%
			//전페이지에 세션에 저장했기에 세션데이터를 불러 오기
			//세션받아올떄 무조건 명시적 형변환
			String id = (String) session.getAttribute("id");
		    String pass = (String) session.getAttribute("pass");
		%>

		<h2>당신의 아이디는 <%=id %>입니다. 패스워드는 <%= pass %>입니다.</h2>


	</center>

</body>
</html>