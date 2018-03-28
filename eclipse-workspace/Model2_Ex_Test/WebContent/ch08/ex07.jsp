<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.MemberDTO"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
MemberDTO mdto = new MemberDTO();
mdto.setUserid("kim");
mdto.setUsername("김철수");
mdto.setUserpass("1234");
//request 영역에 변수 저장
//pageContext, request, session, application
request.setAttribute("mdto", mdto);
%> --%>
<%
MemberDTO mdto = new MemberDTO();
mdto.setUserid("kim");
mdto.setUsername("김철수");
mdto.setUserpass("1234");
%>
<c:set var="mdto" value="<%=mdto%>" scope="request"/>


<!-- 포워딩 (주소는 그대로, 화면은 넘어감 ) -->
<jsp:forward page="ex07_result.jsp"></jsp:forward>

</body>
</html>