<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	ArrayList<String> items = new ArrayList<String>();
	items.add("오렌지");
	items.add("사과");
	items.add("포도");
	items.add("복숭아");
	request.setAttribute("items", items);

%>
<jsp:forward page="ex05_result.jsp"></jsp:forward>
</body>
</html>