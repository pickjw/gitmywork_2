<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- String name =(String) session.getAttribute("name");
/* int age =(int) session.getAttribute("age"); */
String job =(String) session.getAttribute("job");
%> 
이름 : <%=name %><br>
나이 : ${age}<br>
직업 : <%=job %><br> --%>

이름 :  ${sessionScope.name}<br>
나이 : ${sessionScope.age}<br>
직업 :  ${sessionScope.job}<br>
</body>
</html>