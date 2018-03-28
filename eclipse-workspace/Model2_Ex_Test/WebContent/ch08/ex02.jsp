<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- request.getParameter("변수") => ${param.변수} --%>
	<form action="" method="get">
		이름 : <input name="name" value="${param.name}">
		<input type="submit" value="확인">
	</form>
이름 : ${param.name} 

<%-- <%
	//nulll값 처리
	String name = request.getParameter("name");
	if(name == null) {
		name="";
	}

%>

<form action="" method="get">
		이름 : <input name="name" value="<%=name%>">
		<input type="submit" value="확인">
	</form>
이름 : <%=name%> --%>


<%-- null처리 안한 경우
<form action="" method="get"> 
		이름 : <input name="name" value="<%=request.getParameter("name")%>">
		<input type="submit" value="확인">
	</form>
이름 : <%=request.getParameter("name")%> --%>
</body>
</html>