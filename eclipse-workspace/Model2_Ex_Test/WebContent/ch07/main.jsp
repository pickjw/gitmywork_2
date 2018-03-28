<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
		 <!-- JSTL(taglib), path 참조-->  
	<%@ include file = "../include/header.jsp" %>
		 <!-- session_check 참조-->  
	<%@ include file = "../include/session_check.jsp" %>
	<script type="text/javascript" src="../include/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
	$(function (){
		$("#btnLogout").click(function (){
			location.href="${path}/session_servlet/logout.do";
		});
	});
	
	</script>
</head>
<body>
	<%-- <h2><%=session.getAttribute("message") %></h2>
	<%=session.getAttribute("userid") %>님이 접속중입니다.<br> --%>


	<h2>${sessionScope.message}</h2>
	${sessionScope.userid}님이 접속중입니다.<br>
	<button type="button" id="btnLogout">로그아웃</button>
</body>
</html>