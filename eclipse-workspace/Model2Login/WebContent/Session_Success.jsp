<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.js"></script>
	<% String context = request.getContextPath(); %><!--context context빌드패스 추가하기 위해  -->
	<script type="text/javascript">
	$(function(){
		$("#btnLogout").click(function(){
			//location.href="LogoutCon.do";
			location.href="<%=context%>/control_servlet/LogoutCon.do";/* /Model2Login/control_servlet/LoginCon.do */
		});
	});
	</script>
</head>
<body>
	<!--sessionScope 변수명  -->
	<h2>${sessionScope.message}</h2>
	접속중인 아이디 : ${sessionScope.userId} 입니다. 
	
	 <!--session.getAttribute("message") %> -->
	<%-- <h2><%=session.getAttribute("message") %></h2>
	접속중인 아이디 : <%=session.getAttribute("userId") %> 입니다. --%>
	<button type="button" id="btnLogout">로그아웃</button> 
</body>
</html>