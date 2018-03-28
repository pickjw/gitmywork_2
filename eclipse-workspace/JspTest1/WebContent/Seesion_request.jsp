<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

	<%
		//session.setAttribue("key",value); 세션에 저장 
		//(String)  session.getAttribute("name"); 세션값 가져오기 반드시 (형변환)

		String name = (String) session.getAttribute("name");
		int age = (int)session.getAttribute("age");
	%>

	이름 : <%= name %> , 나이 : <%= age %>
	
	
	<%
	
		String name2 = (String) request.getAttribute("name");
		Integer age2 = (Integer) request.getAttribute("age");
	%>

	이름 : <%= name2 %> , 나이 : <%= age2 %>


</body>
</html>