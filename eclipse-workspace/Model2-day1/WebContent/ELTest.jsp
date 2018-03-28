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
		int i = 3;
	
		out.println("i ="+i );
	
		request.setAttribute("ia", 3);//스트링을 자동으로 intgefg 바뀜
	
	%>
	<p> i = <%=  "i" + 3 %> </p>
	
	<p> i = ${ia + 4} </p>




</body>
</html>