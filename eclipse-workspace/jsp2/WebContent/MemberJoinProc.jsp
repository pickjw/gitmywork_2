<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

	<center>
		<h2>회원정보 보기</h2>
		
		<%
			request.setCharacterEncoding("UTF-8");
		
			//String id = request.getParameter("id");

		%>
	
		<!-- request로 넘어온 데이터를 자바 빈즈랑 맵 핑 시켜주는 useBean-->
		<jsp:useBean  class="bean.MemberBean" id="mbean" ><!-- 객체생성 MemberBean mbean = new MemberBean(); -->
		<!-- Jsp 내용을 자바빈 클래스(MemberBean의미)에 데이터를 맵핑(넣어줌) -->
			<jsp:setProperty  property="*" name="mbean" /><!-- *자동으로 모두 맴핑 -->
		</jsp:useBean>
		
		
	 	<h2>당신의 아이디는 <jsp:getProperty property="id" name="mbean"/></h2>
	 	<h2>당신의 비밀번호는 <jsp:getProperty property="pass1" name="mbean"/></h2>
	 	<h2>당신의 이메일은 <jsp:getProperty property="email" name="mbean"/></h2>
	 	
	 	<h2>당신의 전화번호는
	 	<%= mbean.getTel() %>
	 	</h2>
	 	
	
	</center>



</body>
</html>