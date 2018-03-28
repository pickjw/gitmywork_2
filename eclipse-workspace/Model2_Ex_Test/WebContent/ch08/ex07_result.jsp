<%-- <%@page import="model.MemberDTO"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
MemberDTO mdto =(MemberDTO) request.getAttribute("mdto");
if (mdto != null) {
	out.println("이름:"+mdto.getUsername()+"<br>");
	out.println("아이디:"+mdto.getUserid()+"<br>");
	out.println("비번:"+mdto.getUserpass()+"<br>");
}else {
	out.println("출력할 값이 없습니다");
	
}

%> --%>
<!--  java :  pageContext, request, session, application 

	    EL :   pageScope,  requestScope, sessionScope , applicationScope
-->


 이름 : ${mdto.username} <br>  <!-- mdto.getname() -->
 아이디 : ${mdto.userid} <br>
 비번 : ${mdto.userpass} <br>
</body>
</html>