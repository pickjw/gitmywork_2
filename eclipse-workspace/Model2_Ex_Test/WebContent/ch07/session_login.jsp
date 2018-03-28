<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	 <!-- JSTL(taglib), path 참조-->  
	<%@ include file = "../include/header.jsp"%> <!-- ../include/header.jsp -->
	<script type="text/javascript" src="../include/jquery-3.2.1.min.js"></script>
	
	<!-- if test="조건식"
	param.변수 => request.getPrameter("변수") -->
	<c:if test="${param.message == 'error' }">
	<script>
		console.log(alert);
		alert("아이디 또는 비밀번호가 일치하지 않습니다.");
	</script>
	</c:if>
	<c:if test="${param.message == 'logout' }">
	<script>
		console.log(alert);
		alert("로그아웃이 되었습니다.");
	</script>
	</c:if> 
	
	<%-- <% if (request.getParameter("message")!=null 
	&& request.getParameter("message").equals("error")) { %>
		<script type="text/javascript">
			alert=("아이디 또는 비밀번호가 일치하지 않습니다.")
		</script>
	<% } %> --%>
</head>
<body>
	<h2>세션 로그인</h2> <!-- pageContext.request.contextPath  -->
	<form action="${path}/session_servlet/login.do" method="post" name="form1">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input name="userid"></td> <!-- name Control로 보내기 -->
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userpass"></td> <!-- name Control로 보내기 -->
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>